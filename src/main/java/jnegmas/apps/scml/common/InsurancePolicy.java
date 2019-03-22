package jnegmas.apps.scml.common;

import jnegmas.BaseCopyable;
import jnegmas.situated.Contract;

import java.util.HashMap;

public class InsurancePolicy extends BaseCopyable {
    public double premium;
    public int at_time;
    public Contract contract = null;
    public SCMLAgent against = null;

    /*
    @Override
    public void fromMap(HashMap<String, Object> dict) {
        premium = (double) dict.get("premium");
        at_time = (int) dict.get("at_time");
        contract = new Contract();
        contract.fromMap((HashMap<String, Object>) dict.get("contract"));
        against = new SCMLAgent();
        against.fromMap((HashMap<String, Object>) dict.get("against"));
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("premium", premium);
        map.put("at_time", at_time);
        map.put("contract", PyCopyable.toMap(contract));
        map.put("against", PyCopyable.toMap(against));
        return map;
    }
    */
}
