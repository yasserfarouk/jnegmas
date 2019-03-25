package jnegmas.sao;

import jnegmas.PyCaller;
import jnegmas.common.MechanismState;
import jnegmas.common.PythonMechanismInfo;
import jnegmas.utilities.UtilityFunction;

import java.util.HashMap;

public class PythonSAONegotiator extends PyCaller<SAONegotiator> implements SAONegotiator  {

    public PythonSAONegotiator(){

    }
    public PythonSAONegotiator(SAONegotiator shadow){
        super(shadow);
    }

    @Override
    public int respond(MechanismState state, HashMap<String, Object> outcome) {
        return shadow.respond(state, outcome);
    }

    @Override
    public HashMap<String, Object> propose(MechanismState state) {
        return shadow.propose(state);
    }

    @Override
    public boolean onEnter(PythonMechanismInfo info, MechanismState state, UtilityFunction ufun, String role) {
        return shadow.onEnter(info, state, ufun, role);
    }

    @Override
    public void onNegotiationStart(MechanismState state) {
        shadow.onNegotiationStart(state);
    }

    @Override
    public void onRoundStart(MechanismState state) {
        shadow.onRoundStart(state);
    }

    @Override
    public void onMechanismError(MechanismState state) {
        shadow.onMechanismError(state);
    }

    @Override
    public void onRoundEnd(MechanismState state) {
        shadow.onRoundEnd(state);
    }

    @Override
    public void onLeave(MechanismState state) {
        shadow.onLeave(state);
    }

    @Override
    public void onNegotiationEnd(MechanismState state) {
        shadow.onNegotiationEnd(state);
    }

    @Override
    public void onPartnerProposal(MechanismState state, String agentId, HashMap<String, Object> offer) {
        shadow.onPartnerProposal(state, agentId, offer);
    }

    @Override
    public void onPartnerRefusedToPropose(MechanismState state, String agentId) {
        shadow.onPartnerRefusedToPropose(state, agentId);
    }

    @Override
    public void onPartnerResponse(MechanismState state, String agentId, HashMap<String, Object> offer, int response
            , HashMap<String, Object> counterOffer) {
        shadow.onPartnerResponse(state, agentId, offer, response, counterOffer);
    }

    @Override
    public void onNotification(HashMap<String, Object> notification, String notifier) {
        shadow.onNotification(notification, notifier);
    }
}

