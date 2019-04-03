package jnegmas.sao;

import jnegmas.PyCaller;
import jnegmas.common.PythonAgentMechanismInterface;
import jnegmas.negotiators.Controller;
import jnegmas.utilities.UtilityFunction;

import java.util.Map;

public class PythonSAONegotiator extends PyCaller<SAONegotiator> implements SAONegotiator {
    public String name;
    public Controller parent;

    public PythonSAONegotiator() {

    }

    public PythonSAONegotiator(SAONegotiator pythonObject, String name, Controller parent) {
        super(pythonObject);
        this.name = name;
        this.parent = parent;
    }

    public PythonSAONegotiator(String name, Controller parent) {
        this.name = name;
        this.parent = parent;
    }

    public PythonSAONegotiator(SAONegotiator shadow) {
        super(shadow);
    }

    @Override
    public int respond(SAOState state, Map<String, Object> outcome) {

        return shadow.respond(state, outcome);
    }

    @Override
    public Map<String, Object> propose(SAOState state) {
        return shadow.propose(state);
    }

    @Override
    public boolean isIn(String negotiationID) {
        return shadow.isIn(negotiationID);
    }

    @Override
    public boolean join(PythonAgentMechanismInterface ami, SAOState state, UtilityFunction ufun, String role) {
        return shadow.join(ami, state, ufun, role);
    }

    @Override
    public void onNegotiationStart(SAOState state) {
        shadow.onNegotiationStart(state);
    }

    @Override
    public void onRoundStart(SAOState state) {
        shadow.onRoundStart(state);
    }

    @Override
    public void onMechanismError(SAOState state) {
        shadow.onMechanismError(state);
    }

    @Override
    public void onRoundEnd(SAOState state) {
        shadow.onRoundEnd(state);
    }

    @Override
    public void onLeave(SAOState state) {
        shadow.onLeave(state);
    }

    @Override
    public void onNegotiationEnd(SAOState state) {
        shadow.onNegotiationEnd(state);
    }

    @Override
    public void onPartnerProposal(SAOState state, String agentId, Map<String, Object> offer) {
        shadow.onPartnerProposal(state, agentId, offer);
    }

    @Override
    public void onPartnerRefusedToPropose(SAOState state, String agentId) {
        shadow.onPartnerRefusedToPropose(state, agentId);
    }

    @Override
    public void onPartnerResponse(SAOState state, String agentId, Map<String, Object> offer, int response
            , Map<String, Object> counterOffer) {
        shadow.onPartnerResponse(state, agentId, offer, response, counterOffer);
    }

    @Override
    public void onNotification(Map<String, Object> notification, String notifier) {
        shadow.onNotification(notification, notifier);
    }

    @Override
    public void setUtilityFunction(UtilityFunction ufun) {

        shadow.setUtilityFunction(ufun);
    }

    @Override
    public UtilityFunction getUtilityFunction() {

        return shadow.getUtilityFunction();
    }

    @Override
    public void setID(String id) {
        shadow.setID(id);
    }

    @Override
    public String getID() {
        return shadow.getID();
    }

}

