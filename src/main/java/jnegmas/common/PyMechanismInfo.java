package jnegmas.common;

import jnegmas.PyCallable;

import java.util.ArrayList;
import java.util.HashMap;

public interface PyMechanismInfo extends PyCallable {
    ArrayList<HashMap<String, Object>> random_outcomes(int n);
    ArrayList<HashMap<String, Object>> discrete_outcomes(int n_max);
    Integer outcome_index(HashMap<String, Object> outcome);


}
