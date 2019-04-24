package jnegmas.sao;

import jnegmas.PyCallable;
import jnegmas.PyCopyable;
import jnegmas.common.PythonAgentMechanismInterface;
import jnegmas.negotiators.Negotiator;
import jnegmas.utilities.UtilityFunction;

import java.util.Map;

public interface SAONegotiator extends PyCallable, Negotiator, PyCopyable {
    /**
     * Respond to an offer
     *
     * @param state The mechanism state
     * @param outcome The outcome to respond to
     * @return 0 for acceptance, 1 for rejection, 2 to end the negotiation, and 3 for no-response
     */
    int respond(SAOState state, Map<String, Object> outcome);

    Map<String, Object> propose(SAOState state);

    // negotiator functionality
    boolean isIn(String negotiationID);


    // General Nagotiator callbacks
    boolean join(PythonAgentMechanismInterface info, SAOState state, UtilityFunction ufun, String role);


    default void onNegotiationStart(SAOState state){}

    default void onRoundStart(SAOState state){}

    default void onMechanismError(SAOState state){}

    default void onRoundEnd(SAOState state){}

    default void onLeave(SAOState state){}

    default void onNegotiationEnd(SAOState state){}


    // SAO specific call backs

    default void onPartnerProposal(SAOState state, String agentId, Map<String, Object> offer){}

    default void onPartnerRefusedToPropose(SAOState state, String agentId){}

    default void onPartnerResponse(SAOState state, String agentId, Map<String, Object> offer
            , int response, Map<String, Object> counterOffer){}

    default void onUfunChanged() {}

    default void onNotification(Map<String, Object> notification, String notifier){}

    void setUtilityFunction(UtilityFunction ufun);
    UtilityFunction getUtilityFunction();

    void setID(String id);
    String getID();

}
