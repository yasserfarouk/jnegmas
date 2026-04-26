package jnegmas.apps.scml.awi;

import jnegmas.PyCaller;
import jnegmas.apps.scml.common.CFP;
import jnegmas.apps.scml.common.Process;
import jnegmas.apps.scml.common.Product;
import jnegmas.outcomes.Issue;
import jnegmas.situated.Contract;

import java.util.List;
import java.util.Map;

public class PythonSCMLAWI extends PyCaller<SCMLAWI> implements SCMLAWI{
    public PythonSCMLAWI(SCMLAWI shadow){
        super(shadow);
    }

    @Override
    public void registerCFP(CFP cfp) {
        shadow.registerCFP(cfp);
    }

    @Override
    public boolean removeCFP(CFP cfp) {
        return shadow.removeCFP(cfp);
    }

    @Override
    public void registerInterest(List<Integer> products) {
        shadow.registerInterest(products);
    }

    @Override
    public void unregisterInterest(List<Integer> products) {
        shadow.unregisterInterest(products);
    }

    @Override
    public Double evaluateInsurance(Contract contract, int t) throws IllegalAccessException {
        return shadow.evaluateInsurance(contract, t);
    }

    @Override
    public Double evaluateInsurance(Contract contract) throws IllegalAccessException {
        return shadow.evaluateInsurance(contract);
    }

    @Override
    public boolean buyInsurance(Contract contract) throws IllegalAccessException {
        return shadow.buyInsurance(contract);
    }

    @Override
    public boolean requestNegotiation(CFP cfp, String reqId, List<String> roles, String mechanismName
            , Map<String, Object> mechanismParams) {
        return shadow.requestNegotiation(cfp, reqId, roles, mechanismName, mechanismParams);
    }

    @Override
    public List<Product> getProducts() throws NoSuchFieldException, IllegalAccessException {
        return shadow.getProducts();
    }

    @Override
    public List<Process> getProcesses() throws NoSuchFieldException, IllegalAccessException {
        return shadow.getProcesses();
    }

    @Override
    public Object getState() {

        return shadow.getState();
    }

    @Override
    public double relativeTime() {

        return shadow.relativeTime();
    }

    @Override
    public int getCurrentStep() {
        return shadow.getCurrentStep();
    }

    @Override
    public int getNSteps() {
        return shadow.getNSteps();
    }

    @Override
    public int getDefaultSigningDelay() {

        return shadow.getDefaultSigningDelay();
    }

    @Override
    public void loginfo(String msg) {
        shadow.loginfo(msg);
    }

    @Override
    public void logwarning(String msg) {
        shadow.logwarning(msg);
    }

    @Override
    public void logdebug(String msg) {
        shadow.logdebug(msg);
    }

    @Override
    public void logerror(String msg) {
        shadow.logerror(msg);
    }
}
