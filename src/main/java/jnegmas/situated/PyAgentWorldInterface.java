package jnegmas.situated;

import jnegmas.PyCallable;
import jnegmas.outcomes.Issue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;


/**
 * The interface between any agent and the world it is running within.
 *
 * The agent can call any method on this interface at any time. World designers can override this interface
 * to provide new functionality that is only available in their world.
 *
 */
public interface PyAgentWorldInterface extends PyCallable {
    Object get_state();
    float relative_time();
    int get_current_step();
    int get_n_steps();
    int get_default_signing_delay();

    boolean request_negotiation(ArrayList<HashMap<String, Object>> issues, ArrayList<String> partners, String req_id
    , ArrayList<String> roles, HashMap<String, Object> annotation, Optional<String> mechanism_name
    , HashMap<String, Object> mechanism_params);

    void loginfo(String msg);
    void logwarning(String msg);
    void logdebug(String msg);
    void logerror(String msg);
}


