package jnegmas.apps.scml.factory_managers;

import jnegmas.apps.scml.common.*;
import jnegmas.common.AgentMechanismInterface;
import jnegmas.common.MechanismState;
import jnegmas.common.PythonAgentMechanismInterface;
import jnegmas.sao.SAONegotiator;
import jnegmas.situated.Breach;
import jnegmas.situated.Contract;
import jnegmas.utilities.UtilityFunction;

import java.util.List;
import java.util.Map;

public class DoNothingFactoryManager extends AbstractFactoryManager {

    @Override
    public void init() {

    }

    @Override
    public void step() {

    }

    @Override
    public void onNegRequestRejected(String req_id, List<String> rejectors) {

    }

    @Override
    public void onNegRequestAccepted(String req_id, PythonAgentMechanismInterface mechanism) {

    }

    @Override
    public void onNewCFP(CFP cfp) {

    }

    @Override
    public void onRemoveCFP(CFP cfp) {

    }

    @Override
    public void onContractNullified(Contract contract, String bankruptPartner, double compensation) {

    }

    @Override
    public void onAgentBankrupt(String agentId) {

    }

    @Override
    public boolean confirmPartialExecution(Contract contract, List<Breach> breaches) {
        return true;
    }

    @Override
    public void onProductionFailure(List<ProductionFailure> failures) {

    }

    @Override
    public boolean confirmLoan(Loan loan, boolean bankruptIfRejected) {
        return bankruptIfRejected;
    }

    @Override
    public boolean confirmContractExecution(Contract contract) {
        return true;
    }

    @Override
    public SAONegotiator respondToNegotiationRequest(CFP cfp, String partner) {
        return null;
    }

    @Override
    public void onNegotiationSuccess(Contract contract, PythonAgentMechanismInterface mechanism) {

    }

    @Override
    public void onNegotiationFailure(List<String> partners, Map<String, Object> annotation
            , PythonAgentMechanismInterface mechanism, MechanismState state) {

    }


    @Override
    public void onContractSigned(Contract contract) {

    }

    @Override
    public void onContractCancelled(Contract contract, List<String> rejectors) {

    }

    @Override
    public void onNewReport(FinancialReport report) {

    }

    @Override
    public String signContract(Contract contract) {
        return null;
    }

    @Override
    public RenegotiationRequest setRenegotiationAgenda(Contract contract, List<Map<String, Breach>> breaches) {
        return null;
    }

    @Override
    public SAONegotiator respondToRenegotiationRequest(Contract contract, List<Map<String, Breach>> breaches
            , RenegotiationRequest agenda) {
        return null;
    }

    @Override
    public boolean requestNegotiation(CFP cfp, SAONegotiator negotiator, UtilityFunction ufun) {
        return super.requestNegotiation(cfp, negotiator, ufun);
    }
}
