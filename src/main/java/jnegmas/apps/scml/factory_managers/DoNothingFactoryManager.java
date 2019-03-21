package jnegmas.apps.scml.factory_managers;

import jnegmas.apps.scml.common.*;
import jnegmas.common.MechanismInfo;
import jnegmas.common.MechanismState;
import jnegmas.sao.PySAONegotiator;
import jnegmas.sao.SAONegotiator;
import jnegmas.situated.Contract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class DoNothingFactoryManager extends AbstractFactoryManager {
    @Override
    public void init() {

    }

    @Override
    public void step() {

    }

    @Override
    public void onContractNullified(Contract contract, String bankrupt_partner, double compensation) {

    }

    @Override
    public void onAgentBankrupt(String agent_id) {

    }

    @Override
    public boolean confirmPartialExecution(Contract contract, ArrayList<Breach> breaches) {
        return false;
    }

    @Override
    public void onProductionFailure(ArrayList<ProductionFailure> failures) {

    }

    @Override
    public boolean confirmLoan(Loan loan, boolean bankrupt_if_rejected) {
        return false;
    }

    @Override
    public boolean confirmContractExecution(Contract contract) {
        return false;
    }

    @Override
    public PySAONegotiator onNegotiationRequest(CFP cfp, String partner) {
        return null;
    }

    @Override
    public void onNegotiationFailure(ArrayList<String> partners, HashMap<String, Object> annotation
            , MechanismInfo mechanis, MechanismState state) {

    }

    @Override
    public void onNegotiationSuccess(Contract contract, MechanismInfo mechanism) {

    }

    @Override
    public void onContractSigned(Contract contract) {

    }

    @Override
    public void onContractCancelled(Contract contract, ArrayList<String> rejectors) {

    }

    @Override
    public Optional<String> signContract(Contract contract) {
        return Optional.empty();
    }

    @Override
    public Optional<RenegotiationRequest> setRenegotiationAgenda(Contract contract
            , ArrayList<HashMap<String, Breach>> breaches) {
        return Optional.empty();
    }

    @Override
    public PySAONegotiator respondToRenegotiationRequest(Contract contract, ArrayList<HashMap<String, Breach>> breaches
            , RenegotiationRequest agenda) {
        return null;
    }

    @Override
    public boolean onRenegotiationRequest(Contract contract, CFP cfp, String partner) {
        return false;
    }


}
