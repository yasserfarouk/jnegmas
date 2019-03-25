package jnegmas.situated;

import jnegmas.PyCallable;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * The interface between any agent and the world it is running within.
 *
 * The agent can call any method on this interface at any time. World designers can override this interface
 * to provide new functionality that is only available in their world.
 *
 */
public interface AgentWorldInterface extends PyCallable {
    Object getState();
    double relativeTime();
    int getCurrentStep();
    int getNSteps();
    int getDefaultSigningDelay();

    boolean requestNegotiation(ArrayList<HashMap<String, Object>> issues, ArrayList<String> partners, String reqId
    , ArrayList<String> roles, HashMap<String, Object> annotation, String mechanismName
    , HashMap<String, Object> mechanismParams);

    void loginfo(String msg);
    void logwarning(String msg);
    void logdebug(String msg);
    void logerror(String msg);
}


