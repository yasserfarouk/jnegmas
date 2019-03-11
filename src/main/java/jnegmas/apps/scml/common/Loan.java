package jnegmas.apps.scml.common;

import jnegmas.PyReadable;

import java.util.HashMap;

public class Loan implements PyReadable {
    public double amount;
    public int starts_at;
    public double total;
    public double interest;
    public double installment;
    public int n_installments;
    
    @Override
    public void fromMap(HashMap<String, Object> dict) {
        amount = (double) dict.get("amount");
        starts_at = (int) dict.get("starts_at");
        total = (double) dict.get("total");
        interest = (double) dict.get("interest");
        installment = (double) dict.get("installment");
        n_installments = (int) dict.get("n_installments");
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("amount", amount);
        map.put("starts_at", starts_at);
        map.put("total", total);
        map.put("interest", interest);
        map.put("installment", installment);
        map.put("n_installments", n_installments);
        return map;
    }
}
