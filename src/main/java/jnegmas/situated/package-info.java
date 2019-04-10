/**
 * This module defines the base classes for worlds within which multiple agents engage in situated negotiations.
 *
 * <p>
 * The `Agent` class encapsulates the managing entity that creates negotiators to engage in negotiations within a world
 * `Simulation` in order to maximize its own total utility.
 *</p>
 * <h3>Remarks</h3>
 *  <ul><li>
 *     When immediate_negotiations is true, negotiations start in the same step they are registered in (they may also end
 *       in that step) and `negotiation_speed_multiple` steps of it are conducted. That entails that requesting a
 *       negotiation may result in new contracts in the same time-step only of `immediate_negotiations` is true.
 * </li></ul>
 * <h3>Simulation steps</h3>
 * <ul><li>
 *     prepare custom stats (call `_pre_step_stats`)
 * </li><li>
 *     sign contracts that are to be signed at this step calling `on_contract_signed` as needed.
 * </li><li>
 *     step all existing negotiations `negotiation_speed_multiple` times handling any failed negotiations and creating
 *        contracts for any resulting agreements
 * </li><li>
 *     run all `Entity` objects registered (i.e. all agents) in the predefined `simulation_order`.
 * </li><li>
 *     execute contracts that are executable at this time-step handling any breaches
 * </li><li>
 *     allow custom simulation steps to run (call `_simulation_step`)
 * </li><li>
 *     remove any negotiations that are completed!
 * </li><li>
 *     update basic stats
 * </li><li>
 *     update custom stats (call `_post_step_stats`)
 * </li></ul>
 */
package jnegmas.situated;