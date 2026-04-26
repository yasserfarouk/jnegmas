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


    void onNegotiationStart(SAOState state);

    void onRoundStart(SAOState state);

    void onMechanismError(SAOState state);

    void onRoundEnd(SAOState state);

    void onLeave(SAOState state);

    void onNegotiationEnd(SAOState state);


    // SAO specific call backs

    void onPartnerProposal(SAOState state, String agentId, Map<String, Object> offer);

    void onPartnerRefusedToPropose(SAOState state, String agentId);

    void onPartnerResponse(SAOState state, String agentId, Map<String, Object> offer
            , int response, Map<String, Object> counterOffer);

    void onUfunChanged();

    void onNotification(Map<String, Object> notification, String notifier);

    void setUtilityFunction(UtilityFunction ufun);
    UtilityFunction getUtilityFunction();

    void setID(String id);
    String getID();

}
