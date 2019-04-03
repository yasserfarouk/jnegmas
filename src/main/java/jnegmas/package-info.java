package jnegmas;

/**
 * Provides classes necessary for connecting to NegMAS worlds.
 * <p>
 *     JNegMAS was created for the sole purpose of allowing Java developers to create agents capable of interacting with
 *     worlds running on  <a href=http://negmas.readthedocs.io>NegMAS</a>.
 * </p>
 * <p>
 *     Even though, it is possible to create agents using JNegMAS, running world simulations will always require
 *     NegMAS to be installed and running.
 * </p>
 * <p>
 *     You can start a world in NegMAS using {@code negmas scml} or {@code negmas tournament} with the full name of your
 *     factory manager (including package name) given as one of the agents.
 * </p>
 * <p>
 *     The easiest way to use JNegMAS is to download the source code from
 *     <a href=https://www.github.com/yasserfarouk/jnegmas>GitHub</a>, and add a new class for your agent (let's call it
 *     {@code MyFacttoryManager} in the package {@code jnegmas.apps.scml.factory_managers}.
 * </p>
 * <p>
 *     You can then run a tournament between your agent and the built in greedy factory manager using negmnas as follows:
 * </p>
 * <pre>
 *     negmas tournament --competitors=negmas.apps.scml.factory_managers.GreedyFactoryManager;jnegmas.apps.scml.factory_managers.MyFactoryManager
 * </pre>
 *
 * @author Yasser Mohammad
 */