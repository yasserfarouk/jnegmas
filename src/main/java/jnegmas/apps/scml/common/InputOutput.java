package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

public class InputOutput implements PyCopyable {
    public int product;
    public int quantity;
    public double step;

    /*
    @Override
    public void fromMap(Map<String, Object> dict) {
        product = (int) dict.get("product");
        quantity = (int) dict.get("quantity");
        step = (double) dict.get("step");    
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("product", product);
        map.put("quantity", quantity);
        map.put("step", step);
        return map;
    }*/
}
