package jnegmas.sao;

import jnegmas.common.MechanismState;
import jnegmas.common.PythonAgentMechanismInterface;
import jnegmas.utilities.UtilityFunction;

import java.util.Map;

public abstract class AbstractSAONegotiator implements SAONegotiator {
    protected static int ACCEPT_OFFER=0, REJECT_OFFER=1, END_NEGOTIATION=2, NO_RESPONSE=3;
    public UtilityFunction utilityFunction;
    public PythonAgentMechanismInterface ami;
    public MechanismState initialState;
    public String role;

    @Override
    public boolean isIn(String negotiationID) {
        return ami.id == negotiationID;
    }

    @Override
    public boolean join(PythonAgentMechanismInterface ami, SAOState state, UtilityFunction ufun, String role) {
        this.ami = ami;
        initialState = state;
        this.role = role;
        if(ufun != null){
            this.utilityFunction = ufun;
        }
        return true;
    }

    @Override
    public void setUtilityFunction(UtilityFunction ufun) {
        this.utilityFunction = ufun;
    }

    @Override
    public UtilityFunction getUtilityFunction() {
        return this.utilityFunction;
    }

    public Double ufun(Map<String, Object> outcome){
        if (this.utilityFunction != null)
            return this.utilityFunction.call(outcome);
        return null;
    }

    @Override
    public void onNegotiationStart(SAOState state) {

    }

    @Override
    public void onRoundStart(SAOState state) {

    }

    @Override
    public void onMechanismError(SAOState state) {

    }

    @Override
    public void onRoundEnd(SAOState state) {

    }

    @Override
    public void onLeave(SAOState state) {

    }

    @Override
    public void onNegotiationEnd(SAOState state) {

    }

    @Override
    public void onPartnerProposal(SAOState state, String agentId, Map<String, Object> offer) {

    }

    @Override
    public void onPartnerRefusedToPropose(SAOState state, String agentId) {

    }

    @Override
    public void onPartnerResponse(SAOState state, String agentId, Map<String, Object> offer, int response, Map<String, Object> counterOffer) {

    }

    @Override
    public void onUfunChanged() {

    }

    @Override
    public void onNotification(Map<String, Object> notification, String notifier) {

    }

}
