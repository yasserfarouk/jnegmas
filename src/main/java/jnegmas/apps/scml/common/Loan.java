package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

import java.util.HashMap;
import java.util.Map;

public class Loan implements PyCopyable {
    public double amount;
    public int startsAt;
    public double total;
    public double interest;
    public double installment;
    public int nInstallments;
    
    /*@Override
    public void fromMap(Map<String, Object> map) {
        amount = (double) map.get("amount");
        startsAt = (int) map.get("startsAt");
        total = (double) map.get("total");
        interest = (double) map.get("interest");
        installment = (double) map.get("installment");
        nInstallments = (int) map.get("nInstallments");
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("amount", amount);
        map.put("startsAt", startsAt);
        map.put("total", total);
        map.put("interest", interest);
        map.put("installment", installment);
        map.put("nInstallments", nInstallments);
        return map;
    }*/
}
