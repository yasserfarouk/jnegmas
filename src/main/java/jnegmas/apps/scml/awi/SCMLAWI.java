package jnegmas.apps.scml.awi;

import jnegmas.apps.scml.common.CFP;
import jnegmas.apps.scml.common.Process;
import jnegmas.apps.scml.common.Product;
import jnegmas.situated.AgentWorldInterface;
import jnegmas.situated.Contract;

import java.util.List;
import java.util.Map;

public interface SCMLAWI extends AgentWorldInterface {
    List<Product> getProducts() throws NoSuchFieldException, IllegalAccessException;
    List<Process> getProcesses() throws NoSuchFieldException, IllegalAccessException;
    void registerCFP(CFP cfp);
    boolean removeCFP(CFP cfp);
    void registerInterest(List<Integer> products);
    void unregisterInterest(List<Integer> products);
    Double evaluateInsurance(Contract contract, int t) throws IllegalAccessException;
    Double evaluateInsurance(Contract contract) throws IllegalAccessException;
    boolean buyInsurance(Contract contract) throws IllegalAccessException;
    boolean requestNegotiation(CFP cfp, String reqId, List<String> roles
    , String mechanismName, Map<String, Object> mechanismParams);
    default boolean requestNegotiation(CFP cfp, String reqId){
        return requestNegotiation(cfp, reqId, null, null, null);
    }
}
