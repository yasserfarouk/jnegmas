package jnegmas.apps.scml.factory_managers;

import jnegmas.apps.scml.common.*;
import jnegmas.common.MechanismState;
import jnegmas.common.PythonAgentMechanismInterface;
import jnegmas.sao.SAONegotiator;
import jnegmas.situated.Breach;
import jnegmas.situated.Contract;

import java.util.List;
import java.util.Map;

public class PythonFactoryManager extends AbstractFactoryManager {

    public PythonFactoryManager(){

    }

    public PythonFactoryManager(FactoryManager pythonObject) {
        super(pythonObject);
    }

    public PythonFactoryManager(FactoryManager pythonObject, String name) {
        super(pythonObject);
    }

    @Override
    public void init() {
        // init cannot be called from Java ever for a PythonFactoryManager
    }

    @Override
    public void step() {
        // step cannot be called from Java ever for a PythonFactoryManager
    }

    @Override
    public void onNegRequestRejected(String req_id, List<String> rejectors) {
        shadow.onNegRequestRejected(req_id, rejectors);
    }

    @Override
    public void onNegRequestAccepted(String req_id, PythonAgentMechanismInterface mechanism) {
        shadow.onNegRequestAccepted(req_id, mechanism);
    }

    @Override
    public void onNewCFP(CFP cfp) {
        shadow.onNewCFP(cfp);
    }

    @Override
    public void onRemoveCFP(CFP cfp) {
        shadow.onRemoveCFP(cfp);
    }

    @Override
    public void onContractNullified(Contract contract, String bankruptPartner, double compensation) {
        shadow.onContractNullified(contract, bankruptPartner, compensation);
    }

    @Override
    public void onAgentBankrupt(String agentId) {
        shadow.onAgentBankrupt(agentId);
    }

    @Override
    public boolean confirmPartialExecution(Contract contract, List<Breach> breaches) {
        return shadow.confirmPartialExecution(contract, breaches);
    }

    @Override
    public void onProductionFailure(List<ProductionFailure> failures) {
        shadow.onProductionFailure(failures);
    }

    @Override
    public boolean confirmLoan(Loan loan, boolean bankruptIfRejected) {
        return shadow.confirmLoan(loan, bankruptIfRejected);
    }

    @Override
    public boolean confirmContractExecution(Contract contract) {
        return shadow.confirmContractExecution(contract);
    }

    @Override
    public SAONegotiator respondToNegotiationRequest(CFP cfp, String partner) {
        return shadow.respondToNegotiationRequest(cfp, partner);
    }

    @Override
    public void onNegotiationFailure(List<String> partners, Map<String, Object> annotation, PythonAgentMechanismInterface mechanism, MechanismState state) {
        shadow.onNegotiationFailure(partners, annotation, mechanism, state);
    }

    @Override
    public void onNegotiationSuccess(Contract contract, PythonAgentMechanismInterface mechanism) {
        shadow.onNegotiationSuccess(contract, mechanism);
    }

    @Override
    public void onContractSigned(Contract contract) {
        shadow.onContractSigned(contract);
    }

    @Override
    public void onContractCancelled(Contract contract, List<String> rejectors) {
        shadow.onContractCancelled(contract, rejectors);
    }

    @Override
    public void onNewReport(FinancialReport report) {
        shadow.onNewReport(report);
    }

    @Override
    public String signContract(Contract contract) {
        return shadow.signContract(contract);
    }

    @Override
    public RenegotiationRequest setRenegotiationAgenda(Contract contract, List<Map<String, Breach>> breaches) {
        return shadow.setRenegotiationAgenda(contract, breaches);
    }

    @Override
    public SAONegotiator respondToRenegotiationRequest(Contract contract, List<Map<String, Breach>> breaches, RenegotiationRequest agenda) {
        return shadow.respondToRenegotiationRequest(contract, breaches, agenda);
    }

    @Override
    public void setID(String id) {
        super.setID(id);
        shadow.setID(id);
    }

    @Override
    public String getID() {
        return shadow.getID();
    }


    @Override
    public void setName(String name) {
        super.setName(name);
        shadow.setName(name);
    }

    @Override
    public String getName() {
        return shadow.getName();
    }
}
