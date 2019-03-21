package jnegmas.sao;

import jnegmas.common.MechanismInfo;
import jnegmas.common.MechanismState;
import jnegmas.utilities.UtilityFunction;

import java.util.HashMap;

public interface SAONegotiator {

    /**
     * Respond to an outcome
     *
     * @param state The mechanism state
     * @param outcome The outcome to respond to
     * @return 0 for acceptance, 1 for rejection, 2 to end the negotiation, and 3 for no-response
     */
    int respond(MechanismState state, HashMap<String, Object> outcome);

    HashMap<String, Object> propose(MechanismState state);

    // General Nagotiator callbacks
    boolean onEnter(MechanismInfo info, MechanismState state
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

    boolean onEnter(MechanismInfo info, MechanismState state
            , UtilityFunction ufun, String role);
    boolean onEnter(MechanismInfo info, MechanismState state
            , UtilityFunction ufun);
    boolean onEnter(MechanismInfo info, MechanismState state);

    void onNegotiationStart(MechanismState state);

    void onRoundStart(MechanismState state);

    void onMechanismError(MechanismState state);

    void onRoundEnd(MechanismState state);

    void onLeave(MechanismState state);

    void onNegotiationEnd(MechanismState state);


    // SAO specific call backs

    void onPartnerProposal(MechanismState state, String agent_id, HashMap<String, Object> offer);

    void onPartnerRefusedToPropose(MechanismState state, String agent_id);

    void onPartnerResponse(MechanismState state, String agent_id, HashMap<String, Object> offer
            , int response, HashMap<String, Object> counter_offer);

    void onNotification(HashMap<String, Object> notification, String notifier);

}
