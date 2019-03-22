package jnegmas.apps.scml.common;

import jnegmas.BaseCopyable;
import jnegmas.BaseCopyable;

import java.util.HashMap;

public class FactoryStatusUpdate extends BaseCopyable {
    public double balance;
    public HashMap<Integer, Integer> storage = new HashMap<>();

    public boolean isEmpty() {
        return Math.abs(balance) < 1e-6 && storage.isEmpty();
    }
}
