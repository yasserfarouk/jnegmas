package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;
import jnegmas.situated.Contract;

public class InsurancePolicy implements PyCopyable {
    public double premium;
    public int atTime;
    public Contract contract = null;
    public SCMLAgent against = null;

    /*
    @Override
    public void fromMap(HashMap<String, Object> dict) {
        premium = (double) dict.get("premium");
        atTime = (int) dict.get("atTime");
        contract = new Contract();
        contract.fromMap((HashMap<String, Object>) dict.get("contract"));
        against = new SCMLAgent();
        against.fromMap((HashMap<String, Object>) dict.get("against"));
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("premium", premium);
        map.put("atTime", atTime);
        map.put("contract", PyCopyable.toMap(contract));
        map.put("against", PyCopyable.toMap(against));
        return map;
    }
    */
}
