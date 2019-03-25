package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

public class ProductManufacturingInfo implements PyCopyable {

    public int profile;
    public int quantity;
    public int step;

    /*
    @Override
    public void fromMap(HashMap<String, Object> dict) {
        profile = (int) dict.get("profile");
        quantity = (int) dict.get("quantity");
        step = (int) dict.get("step");
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("profile", profile);
        map.put("quantity", quantity);
        map.put("step", step);
        return map;
    }*/
}
