package jnegmas.apps.scml.common;

import jnegmas.BaseCopyable;

import java.util.HashMap;

public class InputOutput extends BaseCopyable {
    public int product;
    public int quantity;
    public double step;

    /*
    @Override
    public void fromMap(HashMap<String, Object> dict) {
        product = (int) dict.get("product");
        quantity = (int) dict.get("quantity");
        step = (double) dict.get("step");    
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("product", product);
        map.put("quantity", quantity);
        map.put("step", step);
        return map;
    }*/
}
