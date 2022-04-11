/**
 * Models basic types of utility functions.
 *
 * <p>
 * Utility functions are at the core of negotiation. Agents engage in negotiations with the goal of maximizing some utility
 * function. In most cases, these utility functions are assumed to be known a-periori and static for the duration of a
 * single negotiations.
 *</p>
 * <h3>Notes</h3>
 * <br>
 *     We try to allow for applications that do not necessary have these two assumptions in the following ways:
 *     <ul>
 *     <li>A utility_function *value* (\ `UtilityValue`\ ) can always represent represent a utility_function distribution over all
 *       possible utility_function values (\ `UtilityDistribution`\ ) or a `KnownUtilityValue` which is a real number.
 *     </li>
 *     <li>The base class of all utility_function *functions* is
 *       `UtilityFunction` and is assumed to map outcomes (\ `Outcome` objects) to the aforementioned generic utility *values*
 *       (\ `UtilityValue` objects).
 *     </li>
 *     <li>Utility functions can be constructed using any `Callable` which makes it possible to construct them so that
 *       they change depending on the context or the progression of the negotiation.
 *     </li>
 *     </ul>
 */
package jnegmas.utilities;