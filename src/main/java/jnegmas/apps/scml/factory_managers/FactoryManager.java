package jnegmas.apps.scml.factory_managers;

import jnegmas.PyCallable;
import jnegmas.PyConstructable;
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

public interface FactoryManager extends PyConstructable, PyCallable {

    void init();

    void step();

    void onNewCFP(CFP cfp);

    void onRemoveCFP(CFP cfp);

    void onContractNullified(Contract contract, String bankruptPartner, double  compensation);

    void onAgentBankrupt(String agentId);

    boolean confirmPartialExecution(Contract contract, ArrayList<Breach> breaches);

    void onProductionFailure(ArrayList<ProductionFailure> failures);

    boolean confirmLoan(Loan loan, boolean bankruptIfRejected);

    boolean confirmContractExecution(Contract contract);


    SAONegotiator onNegotiationRequest(CFP cfp, String partner);


    void onNegotiationFailure(ArrayList<String> partners, HashMap<String, Object> annotation,
                                PythonMechanismInfo mechanism, MechanismState state);


    void onNegotiationSuccess(Contract contract, PythonMechanismInfo mechanism);


    void onContractSigned(Contract contract);


    void onContractCancelled(Contract contract, ArrayList<String> rejectors);


    String signContract(Contract contract);


    RenegotiationRequest setRenegotiationAgenda(Contract contract
            , ArrayList<HashMap<String, Breach>> breaches);

    SAONegotiator respondToRenegotiationRequest(Contract contract
            , ArrayList<HashMap<String, Breach>> breaches, RenegotiationRequest agenda);

    boolean onRenegotiationRequest(Contract contract, CFP cfp, String partner);

}
