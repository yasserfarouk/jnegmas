package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

import java.util.HashMap;

public class Loan implements PyCopyable {
    public double amount;
    public int startsAt;
    public double total;
    public double interest;
    public double installment;
    public int nInstallments;
    
    @Override
    public void fromMap(HashMap<String, Object> dict) {
        amount = (double) dict.get("amount");
        startsAt = (int) dict.get("startsAt");
        total = (double) dict.get("total");
        interest = (double) dict.get("interest");
        installment = (double) dict.get("installment");
        nInstallments = (int) dict.get("nInstallments");
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("amount", amount);
        map.put("startsAt", startsAt);
        map.put("total", total);
        map.put("interest", interest);
        map.put("installment", installment);
        map.put("nInstallments", nInstallments);
        return map;
    }
}
