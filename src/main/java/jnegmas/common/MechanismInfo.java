package jnegmas.common;

import jnegmas.PyCallable;

import java.util.ArrayList;
import java.util.HashMap;

public interface MechanismInfo extends PyCallable {
    ArrayList<HashMap<String, Object>> randomOutcomes(int n);
    ArrayList<HashMap<String, Object>> discreteOutcomes(int nMax);
    Integer outcomeIndex(HashMap<String, Object> outcome);


}
