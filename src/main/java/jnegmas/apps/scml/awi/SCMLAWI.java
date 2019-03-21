package jnegmas.apps.scml.awi;

import jnegmas.apps.scml.common.CFP;
import jnegmas.apps.scml.common.Process;
import jnegmas.apps.scml.common.Product;
import jnegmas.situated.Contract;

import java.util.ArrayList;
import java.util.Optional;

public interface SCMLAWI {
    public void registerCFP(CFP cfp);
    public boolean removeCFP(CFP cfp);
    public void registerInterest(ArrayList<Integer> products);
    public void unregisterInterest(ArrayList<Integer> products);
    public Optional<Double> evaluateInsurance(Contract contract, int t);
    public Optional<Double> evaluateInsurance(Contract contract);
    public boolean buyInsurance(Contract contract);
    public ArrayList<Product> getProducts();
    public ArrayList<Process> getProcesses();
}
