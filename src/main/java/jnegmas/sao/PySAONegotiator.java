package jnegmas.sao;

import jnegmas.PyCallable;
import jnegmas.utilities.UtilityFunction;

import java.util.HashMap;

public interface PySAONegotiator extends PyCallable {

    int respond(HashMap<String, Object> state, HashMap<String, Object> outcome);

    HashMap<String, Object> propose(HashMap<String, Object>  state);

    // General Nagotiator callbacks
    boolean on_enter(HashMap<String, Object>  info, HashMap<String, Object>  state
            , UtilityFunction ufun, String role
            , double cost_per_round
            , double power_per_round
            , double discount_per_round
            , double cost_per_relative_time
            , double power_per_relative_time
            , double discount_per_relative_time
            , double cost_per_real_time
            , double power_per_real_time
            , double discount_per_real_time
            , boolean dynamic_reservation);
    boolean on_enter(HashMap<String, Object>  info, HashMap<String, Object>  state, UtilityFunction ufun, String role);
    boolean on_enter(HashMap<String, Object>  info, HashMap<String, Object>  state, UtilityFunction ufun);
    boolean on_enter(HashMap<String, Object>  info, HashMap<String, Object>  state);

    void on_negotiation_start(HashMap<String, Object>  state);

    void on_round_start(HashMap<String, Object>  state);

    void on_mechanism_error(HashMap<String, Object>  state);

    void on_round_end(HashMap<String, Object>  state);

    void on_leave(HashMap<String, Object>  state);

    void on_negotiation_end(HashMap<String, Object>  state);


    // SAO specific call backs

    void on_partner_proposal(HashMap<String, Object>  state, String agent_id, HashMap<String, Object> offer);

    void on_partner_refused_to_propose(HashMap<String, Object>  state, String agent_id);

    void on_partner_response(HashMap<String, Object>  state, String agent_id, HashMap<String, Object> offer
            , int response, HashMap<String, Object> counter_offer);

    void on_notification(HashMap<String, Object> notification, String notifier);

}
