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

public class DoNothingFactoryManager extends BaseFactoryManager {
    @Override
    public void init() {

    }

    @Override
    public void step() {

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
    public boolean confirmPartialExecution(Contract contract, ArrayList<Breach> breaches) {
        return false;
    }

    @Override
    public void onProductionFailure(ArrayList<ProductionFailure> failures) {

    }

    @Override
    public boolean confirmLoan(Loan loan, boolean bankruptIfRejected) {
        return false;
    }

    @Override
    public boolean confirmContractExecution(Contract contract) {
        return false;
    }

    @Override
    public SAONegotiator onNegotiationRequest(CFP cfp, String partner) {
        return null;
    }

    @Override
    public void onNegotiationSuccess(Contract contract, PythonMechanismInfo mechanism) {

    }

    @Override
    public void onNegotiationFailure(ArrayList<String> partners, HashMap<String, Object> annotation, PythonMechanismInfo mechanism, MechanismState state) {

    }


    @Override
    public void onContractSigned(Contract contract) {

    }

    @Override
    public void onContractCancelled(Contract contract, ArrayList<String> rejectors) {

    }

    @Override
    public String signContract(Contract contract) {
        return null;
    }

    @Override
    public RenegotiationRequest setRenegotiationAgenda(Contract contract, ArrayList<HashMap<String, Breach>> breaches) {
        return null;
    }

    @Override
    public SAONegotiator respondToRenegotiationRequest(Contract contract, ArrayList<HashMap<String, Breach>> breaches, RenegotiationRequest agenda) {
        return null;
    }

    @Override
    public boolean onRenegotiationRequest(Contract contract, CFP cfp, String partner) {
        return false;
    }


}
