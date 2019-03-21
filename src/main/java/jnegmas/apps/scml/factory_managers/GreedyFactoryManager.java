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
    public void onContractNullified(Contract contract, String bankrupt_partner, double compensation) {
        this.shadow.on_contract_nullified(contract, bankrupt_partner, compensation);
    }

    @Override
    public void onAgentBankrupt(String agent_id) {
        this.shadow.on_agent_bankrupt(agent_id);
    }

    @Override
    public boolean confirmPartialExecution(Contract contract, ArrayList<Breach> breaches) {
        return this.shadow.confirm_partial_execution(contract, breaches);
    }

    @Override
    public void onProductionFailure(ArrayList<ProductionFailure> failures) {
        this.shadow.on_production_failure(failures);
    }

    @Override
    public boolean confirmLoan(Loan loan, boolean bankrupt_if_rejected) {
        return this.shadow.confirm_loan(loan, bankrupt_if_rejected);
    }

    @Override
    public boolean confirmContractExecution(Contract contract) {
        return this.shadow.confirm_contract_execution(contract);
    }

    @Override
    public PySAONegotiator onNegotiationRequest(CFP cfp, String partner) {
        return this.shadow.on_negotiation_request(cfp, partner);
    }

    @Override
    public void onNegotiationFailure(ArrayList<String> partners, HashMap<String, Object> annotation
            , MechanismInfo mechanism, MechanismState state) {
        this.shadow.on_negotiation_failure(partners, annotation, mechanism, state);
    }

    @Override
    public void onNegotiationSuccess(Contract contract, MechanismInfo mechanism) {
        this.shadow.on_negotiation_success(contract, mechanism);
    }

    @Override
    public void onContractSigned(Contract contract) {
        this.shadow.on_contract_signed(contract);
    }

    @Override
    public void onContractCancelled(Contract contract, ArrayList<String> rejectors) {
        this.shadow.on_contract_cancelled(contract, rejectors);
    }

    @Override
    public Optional<String> signContract(Contract contract) {
        return this.shadow.sign_contract(contract);
    }

    @Override
    public Optional<RenegotiationRequest> setRenegotiationAgenda(Contract contract, ArrayList<HashMap<String
            , Breach>> breaches) {
        return this.shadow.set_renegotiation_agenda(contract, breaches);
    }

    @Override
    public PySAONegotiator respondToRenegotiationRequest(Contract contract, ArrayList<HashMap<String, Breach>> breaches
            , RenegotiationRequest agenda) {
        return this.shadow.respond_to_renegotiation_request(contract, breaches, agenda);
    }

    @Override
    public boolean onRenegotiationRequest(Contract contract, CFP cfp, String partner) {
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
