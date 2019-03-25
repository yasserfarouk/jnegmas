package jnegmas.apps.scml.awi;

import jnegmas.apps.scml.common.CFP;
import jnegmas.apps.scml.common.Process;
import jnegmas.apps.scml.common.Product;
import jnegmas.situated.AgentWorldInterface;
import jnegmas.situated.Contract;

import java.util.ArrayList;

public interface SCMLAWI extends AgentWorldInterface {
    void registerCFP(CFP cfp);
    boolean removeCFP(CFP cfp);
    void registerInterest(ArrayList<Integer> products);
    void unregisterInterest(ArrayList<Integer> products);
    Double evaluateInsurance(Contract contract, int t) throws IllegalAccessException;
    Double evaluateInsurance(Contract contract) throws IllegalAccessException;
    boolean buyInsurance(Contract contract) throws IllegalAccessException;
    ArrayList<Product> getProducts() throws NoSuchFieldException, IllegalAccessException;
    ArrayList<Process> getProcesses() throws NoSuchFieldException, IllegalAccessException;
}
