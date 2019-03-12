package jnegmas.apps.scml.factory_managers;

import jnegmas.PyCallable;
import jnegmas.PyCaller;
import jnegmas.apps.scml.common.*;
import jnegmas.common.MechanismInfo;
import jnegmas.common.MechanismState;
import jnegmas.sao.PySAONegotiator;
import jnegmas.situated.Contract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class GreedyFactoryManager extends AbstractFactoryManager implements PyCaller {
    PyFactoryManager shadow;

    @Override
    public void init() {
        this.shadow.init();
    }

    @Override
    public void step() {
        this.shadow.step();
    }

    @Override
    public void on_production_failure(ArrayList<ProductionFailure> failures) {
        this.shadow.on_production_failure(failures);
    }

    @Override
    public boolean confirm_loan(Loan loan) {
        return this.shadow.confirm_loan(loan);
    }

    @Override
    public boolean confirm_contract_execution(Contract contract) {
        return this.shadow.confirm_contract_execution(contract);
    }

    @Override
    public PySAONegotiator on_negotiation_request(CFP cfp, String partner) {
        return this.shadow.on_negotiation_request(cfp, partner);
    }

    @Override
    public void on_negotiation_failure(ArrayList<String> partners, HashMap<String, Object> annotation
            , MechanismInfo mechanism, MechanismState state) {
        this.shadow.on_negotiation_failure(partners, annotation, mechanism, state);
    }

    @Override
    public void on_negotiation_success(Contract contract, MechanismInfo mechanism) {
        this.shadow.on_negotiation_success(contract, mechanism);
    }

    @Override
    public void on_contract_signed(Contract contract) {
        this.shadow.on_contract_signed(contract);
    }

    @Override
    public void on_contract_cancelled(Contract contract, ArrayList<String> rejectors) {
        this.shadow.on_contract_cancelled(contract, rejectors);
    }

    @Override
    public Optional<String> sign_contract(Contract contract) {
        return this.shadow.sign_contract(contract);
    }

    @Override
    public Optional<RenegotiationRequest> set_renegotiation_agenda(Contract contract, ArrayList<HashMap<String
            , Breach>> breaches) {
        return this.shadow.set_renegotiation_agenda(contract, breaches);
    }

    @Override
    public PySAONegotiator respond_to_renegotiation_request(Contract contract, ArrayList<HashMap<String, Breach>> breaches
            , RenegotiationRequest agenda) {
        return this.shadow.respond_to_renegotiation_request(contract, breaches, agenda);
    }

    @Override
    public boolean on_renegotiation_request(Contract contract, CFP cfp, String partner) {
        return this.shadow.on_renegotiation_request(contract, cfp, partner);
    }

    @Override
    public void setPythonShadow(PyCallable python_object) {
        this.shadow = (PyFactoryManager) python_object;
    }

    @Override
    public PyCallable getPythonShadow() {
        return this.shadow;
    }
}
