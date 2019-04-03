package jnegmas.apps.scml.factory_managers;

import jnegmas.apps.scml.common.*;
import jnegmas.common.MechanismState;
import jnegmas.common.PythonAgentMechanismInterface;
import jnegmas.sao.SAONegotiator;
import jnegmas.situated.Breach;
import jnegmas.situated.Contract;

import java.util.List;
import java.util.Map;

public class GreedyFactoryManager extends AbstractFactoryManager {


    @Override
    public void init() {
        ((FactoryManager) shadow).init();
    }

    @Override
    public void step() {
        ((FactoryManager) shadow).step();
    }

    @Override
    public void onNegRequestRejected(String req_id, List<String> rejectors) {
        ((FactoryManager) shadow).onNegRequestRejected(req_id, rejectors);
    }

    @Override
    public void onNegRequestAccepted(String req_id, PythonAgentMechanismInterface mechanism) {
        ((FactoryManager) shadow).onNegRequestAccepted(req_id, mechanism);
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
    public boolean confirmPartialExecution(Contract contract, List<Breach> breaches) {
        return ((FactoryManager) shadow).confirmPartialExecution(contract, breaches);
    }

    @Override
    public void onProductionFailure(List<ProductionFailure> failures) {
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
    public SAONegotiator respondToNegotiationRequest(CFP cfp, String partner) {
        return ((FactoryManager) shadow).respondToNegotiationRequest(cfp, partner);
    }


    @Override
    public void onNegotiationFailure(List<String> partners, Map<String, Object> annotation
            , PythonAgentMechanismInterface mechanism, MechanismState state) {
        ((FactoryManager) shadow).onNegotiationFailure(partners, annotation, mechanism, state);
    }

    @Override
    public void onNegotiationSuccess(Contract contract, PythonAgentMechanismInterface mechanism) {
        ((FactoryManager) shadow).onNegotiationSuccess(contract, mechanism);
    }

    @Override
    public void onContractSigned(Contract contract) {
        ((FactoryManager) shadow).onContractSigned(contract);
    }

    @Override
    public void onContractCancelled(Contract contract, List<String> rejectors) {
        ((FactoryManager) shadow).onContractCancelled(contract, rejectors);
    }

    @Override
    public void onNewReport(FinancialReport report) {
        ((FactoryManager) shadow).onNewReport(report);
    }

    @Override
    public String signContract(Contract contract) {
        return ((FactoryManager) shadow).signContract(contract);
    }

    @Override
    public RenegotiationRequest setRenegotiationAgenda(Contract contract, List<Map<String, Breach>> breaches) {
        return ((FactoryManager) shadow).setRenegotiationAgenda(contract, breaches);
    }

    @Override
    public SAONegotiator respondToRenegotiationRequest(Contract contract, List<Map<String, Breach>> breaches, RenegotiationRequest agenda) {
        return ((FactoryManager) shadow).respondToRenegotiationRequest(contract, breaches, agenda);
    }
}
