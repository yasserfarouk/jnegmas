package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

import java.util.HashMap;

public class SCMLAgreement extends HashMap<String, Object> implements PyCopyable {
    public int time;
    public double unitPrice;
    public int quantity;
    public Integer penalty = null;
    public int signingDelay = -1;

    @Override
    public String getPythonClassName() {
        return getClass().getName().substring(1);
    }

    @Override
    public void fromMap(HashMap<String, Object> dict) {
        time = (int) dict.get("time");
        unitPrice = (double) dict.get("unitPrice");
        quantity = (int) dict.get("quantity");
        penalty = (Integer) dict.get("penalty");
        signingDelay = (int) dict.get("signingDelay");
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("time", time);
        map.put("unitPrice", unitPrice);
        map.put("quantity", quantity);
        map.put("penalty", penalty);
        map.put("signingDelay", signingDelay);
        return map;
    }
}
