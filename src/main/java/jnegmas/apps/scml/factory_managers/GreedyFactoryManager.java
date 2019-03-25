package jnegmas.apps.scml.factory_managers;

import jnegmas.apps.scml.common.CFP;
import jnegmas.apps.scml.common.Loan;
import jnegmas.apps.scml.common.ProductionFailure;
import jnegmas.apps.scml.common.RenegotiationRequest;
import jnegmas.common.MechanismState;
import jnegmas.common.PythonMechanismInfo;
import jnegmas.sao.SAONegotiator;
import jnegmas.situated.Breach;
import jnegmas.situated.Contract;

import java.util.ArrayList;
import java.util.HashMap;

public class GreedyFactoryManager extends BaseFactoryManager {
    @Override
    public void init() {
        ((FactoryManager) shadow).init();
    }

    @Override
    public void step() {
        ((FactoryManager) shadow).step();
    }

    @Override
    public void onNewCFP(CFP cfp) {
        ((FactoryManager) shadow).onNewCFP(cfp);
    }

    @Override
    public void onRemoveCFP(CFP cfp) {
        ((FactoryManager) shadow).onRemoveCFP(cfp);
    }

    @Override
    public void onContractNullified(Contract contract, String bankruptPartner, double compensation) {
        ((FactoryManager) shadow).onContractNullified(contract, bankruptPartner, compensation);
    }

    @Override
    public void onAgentBankrupt(String agentId) {
        ((FactoryManager) shadow).onAgentBankrupt(agentId);
    }

    @Override
    public boolean confirmPartialExecution(Contract contract, ArrayList<Breach> breaches) {
        return ((FactoryManager) shadow).confirmPartialExecution(contract, breaches);
    }

    @Override
    public void onProductionFailure(ArrayList<ProductionFailure> failures) {
        ((FactoryManager) shadow).onProductionFailure(failures);
    }

    @Override
    public boolean confirmLoan(Loan loan, boolean bankruptIfRejected) {
        return ((FactoryManager) shadow).confirmLoan(loan, bankruptIfRejected);
    }

    @Override
    public boolean confirmContractExecution(Contract contract) {
        return ((FactoryManager) shadow).confirmContractExecution(contract);
    }

    @Override
    public SAONegotiator onNegotiationRequest(CFP cfp, String partner) {
        return ((FactoryManager) shadow).onNegotiationRequest(cfp, partner);
    }

    @Override
    public void onNegotiationFailure(ArrayList<String> partners, HashMap<String, Object> annotation
            , PythonMechanismInfo mechanism, MechanismState state) {
        ((FactoryManager) shadow).onNegotiationFailure(partners, annotation, mechanism, state);
    }

    @Override
    public void onNegotiationSuccess(Contract contract, PythonMechanismInfo mechanism) {
        ((FactoryManager) shadow).onNegotiationSuccess(contract, mechanism);
    }

    @Override
    public void onContractSigned(Contract contract) {
        ((FactoryManager) shadow).onContractSigned(contract);
    }

    @Override
    public void onContractCancelled(Contract contract, ArrayList<String> rejectors) {
        ((FactoryManager) shadow).onContractCancelled(contract, rejectors);
    }

    @Override
    public String signContract(Contract contract) {
        return ((FactoryManager) shadow).signContract(contract);
    }

    @Override
    public RenegotiationRequest setRenegotiationAgenda(Contract contract, ArrayList<HashMap<String, Breach>> breaches) {
        return ((FactoryManager) shadow).setRenegotiationAgenda(contract, breaches);
    }

    @Override
    public SAONegotiator respondToRenegotiationRequest(Contract contract, ArrayList<HashMap<String, Breach>> breaches, RenegotiationRequest agenda) {
        return ((FactoryManager) shadow).respondToRenegotiationRequest(contract, breaches, agenda);
    }

    @Override
    public boolean onRenegotiationRequest(Contract contract, CFP cfp, String partner) {
        return ((FactoryManager) shadow).onRenegotiationRequest(contract, cfp, partner);
    }
}
