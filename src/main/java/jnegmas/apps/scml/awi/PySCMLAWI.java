package jnegmas.apps.scml.awi;

import jnegmas.apps.scml.common.CFP;
import jnegmas.situated.Contract;
import jnegmas.situated.PyAgentWorldInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public interface PySCMLAWI extends PyAgentWorldInterface {

    ArrayList<HashMap<String, Object>> get_products();
    ArrayList<HashMap<String, Object>> get_processes();
    void register_interest(ArrayList<Integer> products);
    void unregister_interest(ArrayList<Integer> products);
    void register_cfp(HashMap<String, Object> cfp);
    boolean remove_cfp(HashMap<String, Object> cfp);
    Optional<Double> evaluate_insurance(HashMap<String, Object> contract, int t);
    Optional<Double> evaluate_insurance(HashMap<String, Object> contract);
    boolean buy_insurance(HashMap<String, Object> contract);


}
