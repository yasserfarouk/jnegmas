package jnegmas.apps.scml.common;

import jnegmas.PyCopiable;

import java.util.HashMap;

public class FactoryStatusUpdate implements PyCopiable {
    public double balance;
    public HashMap<Integer, Integer> storage;

    public boolean isEmpty() {
        return Math.abs(balance) < 1e-6 && storage.isEmpty();
    }

    @Override
    public void fromMap(HashMap<String, Object> dict) {
        balance = (double) dict.get("balance");
        storage = (HashMap<Integer, Integer>) dict.get("storage");
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("balance", balance);
        map.put("storage", storage);
        return map;
    }
}
