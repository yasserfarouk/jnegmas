package jnegmas.apps.scml.factory_managers;

import jnegmas.apps.scml.awi.PySCMLAWI;
import jnegmas.apps.scml.common.*;
import jnegmas.common.MechanismInfo;
import jnegmas.common.MechanismState;
import jnegmas.situated.Contract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public interface FactoryManager {

    void init();

    void step();

    void on_production_failure(ArrayList<ProductionFailure> failures);

    boolean confirm_loan(Loan loan);


    boolean confirm_contract_execution(Contract contract);


    String on_negotiation_request(CFP cfp, String partner);


    void on_negotiation_failure(ArrayList<String> partners, HashMap<String, Object> annotation,
                                MechanismInfo mechanis, MechanismState state);


    void on_negotiation_success(Contract contract, MechanismInfo mechanism);


    void on_contract_signed(Contract contract);


    void on_contract_cancelled(Contract contract, ArrayList<String> rejectors);


    Optional<String> sign_contract(Contract contract);


    Optional<RenegotiationRequest> set_renegotiation_agenda(Contract contract
            , ArrayList<HashMap<String, Breach>> breaches);

    String respond_to_renegotiation_request(Contract contract
            , ArrayList<HashMap<String, Breach>> breaches, RenegotiationRequest agenda);

    boolean on_renegotiation_request(Contract contract, CFP cfp, String partner);


}

