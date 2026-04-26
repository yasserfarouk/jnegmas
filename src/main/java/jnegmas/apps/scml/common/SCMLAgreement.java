package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

import java.util.HashMap;
import java.util.Map;

public class SCMLAgreement implements PyCopyable {
    public int time;
    public double unitPrice;
    public int quantity;
    public Integer penalty = null;
    public int signingDelay = -1;

    @Override
    public String getPythonClassName() {
        return getClass().getName().substring(1);
    }
/*
    @Override
    public void fromMap(Map<String, Object> map) {
        time = (int) map.get("time");
        unitPrice = (double) map.get("unitPrice");
        quantity = (int) map.get("quantity");
        penalty = (Integer) map.get("penalty");
        signingDelay = (int) map.get("signingDelay");
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("time", time);
        map.put("unitPrice", unitPrice);
        map.put("quantity", quantity);
        map.put("penalty", penalty);
        map.put("signingDelay", signingDelay);
        return map;
    }
    */
}
