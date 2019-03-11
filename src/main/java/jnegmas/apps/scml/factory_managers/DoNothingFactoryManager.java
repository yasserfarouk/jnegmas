package jnegmas.apps.scml.factory_managers;

import jnegmas.apps.scml.common.*;
import jnegmas.common.MechanismInfo;
import jnegmas.common.MechanismState;
import jnegmas.situated.Contract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class DoNothingFactoryManager extends AbstractFactoryManager {
    @Override
    public void init() {

    }

    @Override
    public void step() {

    }

    @Override
    public void on_production_failure(ArrayList<ProductionFailure> failures) {

    }

    @Override
    public boolean confirm_loan(Loan loan) {
        return false;
    }

    @Override
    public boolean confirm_contract_execution(Contract contract) {
        return false;
    }

    @Override
    public String on_negotiation_request(CFP cfp, String partner) {
        return "";
    }

    @Override
    public void on_negotiation_failure(ArrayList<String> partners, HashMap<String, Object> annotation
            , MechanismInfo mechanis, MechanismState state) {

    }

    @Override
    public void on_negotiation_success(Contract contract, MechanismInfo mechanism) {

    }

    @Override
    public void on_contract_signed(Contract contract) {

    }

    @Override
    public void on_contract_cancelled(Contract contract, ArrayList<String> rejectors) {

    }

    @Override
    public Optional<String> sign_contract(Contract contract) {
        return Optional.empty();
    }

    @Override
    public Optional<RenegotiationRequest> set_renegotiation_agenda(Contract contract, ArrayList<HashMap<String
            , Breach>> breaches) {
        return Optional.empty();
    }

    @Override
    public String respond_to_renegotiation_request(Contract contract
            , ArrayList<HashMap<String, Breach>> breaches, RenegotiationRequest agenda) {
        return "";
    }

    @Override
    public boolean on_renegotiation_request(Contract contract, CFP cfp, String partner) {
        return false;
    }
}
