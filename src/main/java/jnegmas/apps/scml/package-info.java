package jnegmas.apps.scml;

/**
 * The implementation file for all entities needed for ANAC-SCML 2019.
 *
 * Participants need to provide a class inherited from `FactoryManager` that implements all of its abstract functions.
 *
 * Participants can optionally override any other methods of this class or implement new `NegotiatorUtility` class.
 *
 * <h2> Simulation steps</h2> 
 * <ol>
 *     <li>prepare custom stats (call `_preStepStats`)</li>
 *     <li>sign contracts that are to be signed at this step calling `onContractSigned` as needed</li>
 *     <li>step all existing negotiations `negotiationSpeedMultiple` times handling any failed negotiations and creating
 *        contracts for any resulting agreements</li>
 *     <li>run all `ActiveEntity` objects registered (i.aspirationType. all agents). `Consumer` s run first then `FactoryManager` s then
 *        `Miner` s</li>
 *     <li>execute contracts that are executable at this time-step handling any breaches</li>
 *     <li>Custom Simulation Steps<ol>
 *         <li>step all factories (`Factory` objects) running any pre-scheduled commands</li>
 *         <li>Apply interests and pay loans</li>
 *         <li>remove expired `CFP` s</li>
 *         <li>Deliver any products that are in transportation</li>
 *        </ol></li>
 *     <li>remove any negotiations that are completed!</li>
 *     <li>update basic stats</li>
 *     <li>update custom stats (call `_postStepStats`)</li>
 * </ol>
 * <h2>>Remarks about re-negotiation on breaches</h2>
 * <ul>
 *     <li> The victim is asked first to specify the negotiation agenda (issues) then the perpetrator</li>
 *     <li></li> renegotiations for breaches run immediately to completion independent from settings of
 *       `negotiationSpeedMultiplier` and `immediateNegotiations`. That include conclusion and signing of any resulting</li>
 *       agreements.
 * </ul>
 * <h2>Remarks about timing</h2>
 *
 *     The order of events within a single time-step are as follows
 *     <ol>
 *         <li>Contracts scheduled to be signed are signed.</li>
 *         <li>Scheduled negotiations run for the predefined number of steps. Any negotiation that result in a contract or
 *            fail may trigger other negotiations.</li>
 *         <li>If `immediateNegotiations`, some of the newly added negotiations may be concluded/failed.</li>
 *         <li>Any newly concluded contracts that are to be signed at this step are signed</li>
 *         <li>Contracts are executed including full execution of any re-negotiations and breaches are handled. Notice that
 *            if re-negotiation leads to new contracts, these will be concluded and signed immediately at this step. Please
 *            note the following about contract execution:
 *            <p>
 *            Products are moved from the seller's storage to a temporary *truck* as int as they are available at the
 *              time of contract execution. Because contract execution happens *before* actual production, outputs from
 *              production processes *CANNOT* be sold at the same time-step.</p></li>
 *
 *         <li>Production is executed on all factories. For a `Process` to start/continue on a `Line`, all its inputs
 *            required at this time-step **MUST** be available in storage of the corresponding factory *by this point*.
 *            This implies that it is impossible for any processes to start at time-step *0* except if initial storage was
 *            nonzero. `FactoryManager` s are informed about processes that cannot start due to storage or fund shortage
 *            (or cannot continue due to storage shortage) through an `onProductionFailure` call.</li>
 *         <li>Outputs of the `Process` are generated at *the end* of the corresponding time-step. It is immediately moved
 *            to storage. Because outputs are generated at the *end* of the step and inputs are consumed at the beginning,
 *            a factory cannot use outputs of a process as inputs to another process that starts at the same time-step.</li>
 *         <li>Products are moved from the temporary *truck* to the buyer's storage after the `transportationDelay` have
 *            passed at the *end* of the time-step. Transportation completes at the *end* of the time-step no matter
 *            what is the value for `transportationDelay`. This means that if a `FactoryManager` believes
 *            that it can produce some product at time *t*, it should never contract to sell it before *t+d + 1* where
 *            *d* is the `transportationDelay` (the *1* comes from the fact that contract execution happens *before*
 *            production). Even for a zero transportation delay, you cannot produce something and sell it in the same
 *            time-step. Moreover, the buyer should never use the product to be delivered at time *t* as an input to a
 *            production process that needs it before step *t+1*.</li>
 *         <li>When contracts are executed, the funds are deducted from the buyer's wallet at the *beginning* of the
 *            simulation step and deposited in the seller's wallet at the *end* of that step (similar to what happens to
 *            the products). This means that a factory manager cannot use funds it receives from sales at time *t* for
 *            buying products before *t + 1*.</li>
 * </ol>
 * <h2>Remarks about ANAC 2019 SCML League</h2>
 *
 *     Given the information above, and settings for the ANAC 2019 SCML you can confirm for yourself that the following
 *     rules are all correct:
 *  <ol>
 *         <li>No agents except miners should contract on delivery at time *0*.</li>
 *         <li>`FactoryManager` s should never sign contracts to sell the output of their production with delivery at *t*
 *            except if this production starts at step *t* and the contract is signed no later than than *t-1*.</li>
 *         <li>If not all inputs are available in storage, `FactoryManager` s should never sign contracts to sell the output
 *            of production with delivery at *t* later than *t-2* (and that is optimistic).</li>
 *  </ol>
 */