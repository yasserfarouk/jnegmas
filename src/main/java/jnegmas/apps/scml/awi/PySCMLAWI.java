package jnegmas.apps.scml.awi;

import jnegmas.apps.scml.common.CFP;
import jnegmas.apps.scml.common.Process;
import jnegmas.apps.scml.common.Product;
import jnegmas.situated.Contract;
import jnegmas.situated.PyAgentWorldInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public interface PySCMLAWI extends PyAgentWorldInterface {

    void register_cfp(CFP cfp);
    boolean remove_cfp(CFP cfp);
    void register_interest(ArrayList<Integer> products);
    void unregister_interest(ArrayList<Integer> products);
    Optional<Double> evaluate_insurance(Contract contract, int t) throws IllegalAccessException;
    Optional<Double> evaluate_insurance(Contract contract) throws IllegalAccessException;
    boolean buy_insurance(Contract contract) throws IllegalAccessException;
    ArrayList<Product> get_products() throws NoSuchFieldException, IllegalAccessException;
    ArrayList<Process> get_processes() throws NoSuchFieldException, IllegalAccessException;


}
