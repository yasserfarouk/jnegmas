package jnegmas.sao;

import jnegmas.common.MechanismInfo;
import jnegmas.common.MechanismState;
import jnegmas.utilities.UtilityFunction;

import java.util.HashMap;

public interface PySAONegotiator {
    /**
     * Respond to an outcome
     *
     * @param state
     * @param outcome
     * @return 0 for acceptance, 1 for rejection, 2 to end the negotiation, and 3 for no-response
     */
    int respond(MechanismState state, HashMap<String, Object> outcome);

    HashMap<String, Object> propose(MechanismState state);

    // General Nagotiator callbacks
    boolean on_enter(MechanismInfo info, MechanismState state
            , UtilityFunction ufun, String role
            , float cost_per_round
            , float power_per_round
            , float discount_per_round
            , float cost_per_relative_time
            , float power_per_relative_time
            , float discount_per_relative_time
            , float cost_per_real_time
            , float power_per_real_time
            , float discount_per_real_time
            , boolean dynamic_reservation);

    void on_negotiation_start(MechanismState state);

    void on_round_start(MechanismState state);

    void on_mechanism_error(MechanismState state);

    void on_round_end(MechanismState state);

    void on_leave(MechanismState state);

    void on_negotiation_end(MechanismState state);


    // SAO specific call backs

    void on_partner_proposal(MechanismState state, String agent_id, HashMap<String, Object> offer);

    void on_partner_refused_to_propose(MechanismState state, String agent_id);

    void on_partner_response(MechanismState state, String agent_id, HashMap<String, Object> offer
            , int response, HashMap<String, Object> counter_offer);
}
