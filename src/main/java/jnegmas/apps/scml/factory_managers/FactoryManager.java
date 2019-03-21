package jnegmas.apps.scml.factory_managers;

import jnegmas.apps.scml.awi.PySCMLAWI;
import jnegmas.apps.scml.common.*;
import jnegmas.common.MechanismInfo;
import jnegmas.common.MechanismState;
import jnegmas.sao.PySAONegotiator;
import jnegmas.sao.SAONegotiator;
import jnegmas.situated.Contract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.Callable;

public interface FactoryManager {

    void init();

    void step();

    void onContractNullified(Contract contract, String bankrupt_partner,double  compensation);

    void onAgentBankrupt(String agent_id);

    boolean confirmPartialExecution(Contract contract, ArrayList<Breach> breaches);

    void onProductionFailure(ArrayList<ProductionFailure> failures);

    boolean confirmLoan(Loan loan, boolean bankrupt_if_rejected);

    boolean confirmContractExecution(Contract contract);


    PySAONegotiator onNegotiationRequest(CFP cfp, String partner);


    void onNegotiationFailure(ArrayList<String> partners, HashMap<String, Object> annotation,
                                MechanismInfo mechanis, MechanismState state);


    void onNegotiationSuccess(Contract contract, MechanismInfo mechanism);


    void onContractSigned(Contract contract);


    void onContractCancelled(Contract contract, ArrayList<String> rejectors);


    Optional<String> signContract(Contract contract);


    Optional<RenegotiationRequest> setRenegotiationAgenda(Contract contract
            , ArrayList<HashMap<String, Breach>> breaches);

    PySAONegotiator respondToRenegotiationRequest(Contract contract
            , ArrayList<HashMap<String, Breach>> breaches, RenegotiationRequest agenda);

    boolean onRenegotiationRequest(Contract contract, CFP cfp, String partner);


}

