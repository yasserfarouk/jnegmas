package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

import java.util.HashMap;

public class MissingInput implements PyCopyable {
    public int product;
    public int quantity;

    public String toString(){
        return String.format("%d: %d", product, quantity);
    }

    @Override
    public void fromMap(HashMap<String, Object> dict) {
        product = (int) dict.get("product");
        quantity = (int) dict.get("quantity");
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("product", product);
        map.put("quantity", quantity);
        return map;
    }
}
