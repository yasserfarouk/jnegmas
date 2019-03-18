package jnegmas.apps.scml.awi;

import jnegmas.apps.scml.common.CFP;
import jnegmas.apps.scml.common.Product;
import jnegmas.situated.Contract;
import jnegmas.situated.PyAgentWorldInterface;

import java.util.ArrayList;
import java.util.Optional;

public interface PySCMLAWI extends PyAgentWorldInterface {

    void register_cfp(CFP cfp);
    boolean remove_cfp(CFP cfp);
    Optional<Double> evaluate_insurance(Contract contract, int t);
    Optional<Double> evaluate_insurance(Contract contract);
    boolean buy_insurance(Contract contract);
    ArrayList<Product> _allProducts();
    ArrayList<Process> _allProcesses();

}
