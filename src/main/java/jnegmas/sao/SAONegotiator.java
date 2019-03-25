package jnegmas.sao;

import jnegmas.PyCallable;
import jnegmas.common.MechanismState;
import jnegmas.common.PythonMechanismInfo;
import jnegmas.utilities.UtilityFunction;

import java.util.HashMap;

public interface SAONegotiator extends PyCallable {

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
    boolean onEnter(PythonMechanismInfo info, MechanismState state
            , UtilityFunction ufun, String role);

    void onNegotiationStart(MechanismState state);

    void onRoundStart(MechanismState state);

    void onMechanismError(MechanismState state);

    void onRoundEnd(MechanismState state);

    void onLeave(MechanismState state);

    void onNegotiationEnd(MechanismState state);


    // SAO specific call backs

    void onPartnerProposal(MechanismState state, String agentId, HashMap<String, Object> offer);

    void onPartnerRefusedToPropose(MechanismState state, String agentId);

    void onPartnerResponse(MechanismState state, String agentId, HashMap<String, Object> offer
            , int response, HashMap<String, Object> counterOffer);

    void onNotification(HashMap<String, Object> notification, String notifier);

}
