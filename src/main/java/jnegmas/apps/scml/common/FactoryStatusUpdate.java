package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

import java.util.HashMap;
import java.util.Map;

public class FactoryStatusUpdate implements PyCopyable {
    public double balance;
    public Map<Integer, Integer> storage = new HashMap<>();

    public boolean isEmpty() {
        return Math.abs(balance) < 1e-6 && storage.isEmpty();
    }
}
