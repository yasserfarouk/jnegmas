package jnegmas.apps.scml.factory_managers;

import jnegmas.PyCallable;

import jnegmas.PyCopyable;
import jnegmas.apps.scml.awi.SCMLAWI;
import jnegmas.apps.scml.common.*;
import jnegmas.apps.scml.simulators.FactorySimulator;
import jnegmas.common.MechanismState;
import jnegmas.common.PythonAgentMechanismInterface;
import jnegmas.sao.SAONegotiator;
import jnegmas.situated.Breach;
import jnegmas.situated.Contract;
import jnegmas.situated.NegotiationRequestInfo;
import jnegmas.utilities.UtilityFunction;

import java.util.List;
import java.util.Map;

public interface FactoryManager extends PyCopyable, PyCallable {

    SCMLAWI getAWI();

    void setAWI(SCMLAWI awi);

    FactorySimulator getSimulator();

    void setSimulator(FactorySimulator simulator);

    void init();

    void step();

    void onNegRequestRejected(String req_id, List<String> rejectors);

    void onNegRequestAccepted(String req_id, PythonAgentMechanismInterface mechanism);

    void onNewCFP(CFP cfp);

    void onRemoveCFP(CFP cfp);

    void onContractNullified(Contract contract, String bankruptPartner, double compensation);

    void onAgentBankrupt(String agentId);

    boolean confirmPartialExecution(Contract contract, List<Breach> breaches);

    void onProductionFailure(List<ProductionFailure> failures);

    boolean confirmLoan(Loan loan, boolean bankruptIfRejected);

    boolean confirmContractExecution(Contract contract);


    SAONegotiator respondToNegotiationRequest(CFP cfp, String partner);


    void onNegotiationFailure(List<String> partners, Map<String, Object> annotation,
                              PythonAgentMechanismInterface mechanism, MechanismState state);


    void onNegotiationSuccess(Contract contract, PythonAgentMechanismInterface mechanism);


    void onContractSigned(Contract contract);


    void onContractCancelled(Contract contract, List<String> rejectors);

    void onNewReport(FinancialReport report);


    String signContract(Contract contract);


    RenegotiationRequest setRenegotiationAgenda(Contract contract
            , List<Map<String, Breach>> breaches);

    SAONegotiator respondToRenegotiationRequest(Contract contract
            , List<Map<String, Breach>> breaches, RenegotiationRequest agenda);

    boolean requestNegotiation(CFP cfp, SAONegotiator negotiator, UtilityFunction ufun);

    default boolean requestNegotiation(CFP cfp, SAONegotiator negotiator) {
        return requestNegotiation(cfp, negotiator, null);
    }

    default boolean requestNegotiation(CFP cfp) {
        return requestNegotiation(cfp, null, null);
    }

    List<NegotiationRequestInfo> getRequestedNegotiations();

    List<NegotiationRequestInfo> getRunningNegotiations();

    void setID(String id);
    String getID();

    void setName(String id);
    String getName();
}
