package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

import java.util.HashMap;
import java.util.Map;

public class MissingInput implements PyCopyable {
    public int product;
    public int quantity;

    public String toString(){
        return String.format("%d: %d", product, quantity);
    }
/*
    @Override
    public void fromMap(Map<String, Object> map) {
        product = (int) map.get("product");
        quantity = (int) map.get("quantity");
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("product", product);
        map.put("quantity", quantity);
        return map;
    }
    */
}
