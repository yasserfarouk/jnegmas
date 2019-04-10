/**
 * Defines basic concept related to outcomes.
 *
 * <p>
 * Outcomes in this package are always assumed to be multi-issue outcomes where  single-issue outcomes can be implemented
 * as the special case with a single issue.
 *</p>
 * <ul><li>
 * Both Continuous and discrete issues are supported. All issue will have names. If none is given, a random name will be
 *   used. It is HIGHLY recommended to always name your issues.
 * </li><li>Outcomes are dictionaries with issue names as keys and issue values as values.
 * </li></ul>
 *
 */
package jnegmas.outcomes;