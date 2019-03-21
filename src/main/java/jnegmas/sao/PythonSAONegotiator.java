package jnegmas.sao;

import jnegmas.PyCallable;
import jnegmas.PyCaller;
import jnegmas.common.MechanismInfo;
import jnegmas.common.MechanismState;
import jnegmas.utilities.UtilityFunction;

import java.util.HashMap;

public class PythonSAONegotiator implements SAONegotiator, PyCaller {

    PySAONegotiator shadow;

    @Override
    public int respond(MechanismState state, HashMap<String, Object> outcome) {
        return shadow.respond(state.toMap(), outcome);
    }

    @Override
    public HashMap<String, Object> propose(MechanismState state) {
        return shadow.propose(state.toMap());
    }

    @Override
    public boolean onEnter(MechanismInfo info, MechanismState state, UtilityFunction ufun, String role
            , float cost_per_round, float power_per_round, float discount_per_round, float cost_per_relative_time
            , float power_per_relative_time, float discount_per_relative_time, float cost_per_real_time
            , float power_per_real_time, float discount_per_real_time, boolean dynamic_reservation) {
        return shadow.on_enter(info.toMap(), state.toMap(), ufun, role, cost_per_round, power_per_round
                , discount_per_round, cost_per_relative_time, power_per_relative_time, discount_per_relative_time
                , cost_per_real_time, power_per_real_time, discount_per_real_time, dynamic_reservation);
    }

    @Override
    public boolean onEnter(MechanismInfo info, MechanismState state, UtilityFunction ufun, String role) {
        return shadow.on_enter(info.toMap(), state.toMap(), ufun, role);
    }

    @Override
    public boolean onEnter(MechanismInfo info, MechanismState state, UtilityFunction ufun) {
        return shadow.on_enter(info.toMap(), state.toMap(), ufun);
    }

    @Override
    public boolean onEnter(MechanismInfo info, MechanismState state) {
        return shadow.on_enter(info.toMap(), state.toMap());
    }

    @Override
    public void onNegotiationStart(MechanismState state) {
        shadow.on_negotiation_start(state.toMap());
    }

    @Override
    public void onRoundStart(MechanismState state) {
        shadow.on_round_start(state.toMap());
    }

    @Override
    public void onMechanismError(MechanismState state) {
        shadow.on_mechanism_error(state.toMap());
    }

    @Override
    public void onRoundEnd(MechanismState state) {
        shadow.on_round_end(state.toMap());
    }

    @Override
    public void onLeave(MechanismState state) {
        shadow.on_leave(state.toMap());
    }

    @Override
    public void onNegotiationEnd(MechanismState state) {
        shadow.on_negotiation_end(state.toMap());
    }

    @Override
    public void onPartnerProposal(MechanismState state, String agent_id, HashMap<String, Object> offer) {
        shadow.on_partner_proposal(state.toMap(), agent_id, offer);
    }

    @Override
    public void onPartnerRefusedToPropose(MechanismState state, String agent_id) {
        shadow.on_partner_refused_to_propose(state.toMap(), agent_id);
    }

    @Override
    public void onPartnerResponse(MechanismState state, String agent_id, HashMap<String, Object> offer, int response
            , HashMap<String, Object> counter_offer) {
        shadow.on_partner_response(state.toMap(), agent_id, offer, response, counter_offer);
    }

    @Override
    public void onNotification(HashMap<String, Object> notification, String notifier) {
        shadow.on_notification(notification, notifier);
    }

    @Override
    public void setPythonShadow(PyCallable python_object) {
        shadow = (PySAONegotiator) python_object;

    }

    @Override
    public PyCallable getPythonShadow() {
        return shadow;
    }
}
