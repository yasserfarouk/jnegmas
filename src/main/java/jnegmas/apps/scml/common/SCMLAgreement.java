package jnegmas.apps.scml.common;

import jnegmas.PyReadable;
import jnegmas.outcomes.OutcomeType;

import java.util.HashMap;

public class SCMLAgreement implements OutcomeType, PyReadable {
    public int time;
    public double unit_price;
    public int quantity;
    public Integer penalty = null;
    public int signing_delay = -1;

    @Override
    public void fromMap(HashMap<String, Object> dict) {
        time = (int) dict.get("time");
        unit_price = (double) dict.get("unit_price");
        quantity = (int) dict.get("quantity");
        penalty = (Integer) dict.get("penalty");
        signing_delay = (int) dict.get("signing_delay");
    }  

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("time", time);
        map.put("unit_price", unit_price);
        map.put("quantity", quantity);
        map.put("penalty", penalty);
        map.put("signing_delay", signing_delay);
        return map;
    }
}
