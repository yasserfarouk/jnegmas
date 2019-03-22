package jnegmas.sao;

import jnegmas.common.MechanismInfo;
import jnegmas.common.MechanismState;
import jnegmas.utilities.UtilityFunction;

import java.util.ArrayList;
import java.util.HashMap;

public class AspirationNegotiator implements SAONegotiator {
    public double maxAspiration =1.0;
    public double exponent =4.0;
    public boolean aboveReserved =true;
    public double reservedValue=0.0;
    ArrayList<HashMap<String, Object>> orderedOutcomes = new ArrayList<>();
    boolean dynamicUfun = true;
    boolean ranodmizeOffer=false;
    boolean ufunModified=false;
    PySAONegotiator pyNegotiator=null;

    public AspirationNegotiator(){

    }
    public AspirationNegotiator(double exponent, double maxAspiration, double reservedValue, boolean aboveReserved){
        this.maxAspiration = maxAspiration;
        this.exponent = exponent;
        this.aboveReserved = aboveReserved;
        this.reservedValue = reservedValue;
    }
    public AspirationNegotiator(boolean aboveReserved){
        this.aboveReserved = aboveReserved;
    }

    public double aspiration(double t){
        if(this.exponent<1e-7)
            return 0.0;
        double pmin = this.aboveReserved? this.reservedValue : 0.0;
        return pmin + (this.maxAspiration - pmin) * (1.0 - Math.pow(t, this.exponent));
    }

    private void updateOrderedOutcomes(){

    }

    @Override
    public int respond(MechanismState state, HashMap<String, Object> outcome) {
        return 0;
    }

    @Override
    public HashMap<String, Object> propose(MechanismState state) {
        return null;
    }

    @Override
    public boolean on_enter(MechanismInfo info, MechanismState state, UtilityFunction ufun, String role
            , double cost_per_round, double power_per_round, double discount_per_round, double cost_per_relative_time
            , double power_per_relative_time, double discount_per_relative_time, double cost_per_real_time
            , double power_per_real_time, double discount_per_real_time, boolean dynamic_reservation) {
        return false;
    }

    @Override
    public boolean on_enter(MechanismInfo info, MechanismState state, UtilityFunction ufun, String role) {
        return false;
    }

    @Override
    public boolean on_enter(MechanismInfo info, MechanismState state, UtilityFunction ufun) {
        return false;
    }

    @Override
    public boolean on_enter(MechanismInfo info, MechanismState state) {
        return false;
    }

    @Override
    public void on_negotiation_start(MechanismState state) {

    }

    @Override
    public void on_round_start(MechanismState state) {

    }

    @Override
    public void on_mechanism_error(MechanismState state) {

    }

    @Override
    public void on_round_end(MechanismState state) {

    }

    @Override
    public void on_leave(MechanismState state) {

    }

    @Override
    public void on_negotiation_end(MechanismState state) {

    }

    @Override
    public void on_partner_proposal(MechanismState state, String agent_id, HashMap<String, Object> offer) {

    }

    @Override
    public void on_partner_refused_to_propose(MechanismState state, String agent_id) {

    }

    @Override
    public void on_partner_response(MechanismState state, String agent_id, HashMap<String, Object> offer, int response, HashMap<String, Object> counter_offer) {

    }

    @Override
    public void on_notification(HashMap<String, Object> notification, String notifier) {

    }

}
