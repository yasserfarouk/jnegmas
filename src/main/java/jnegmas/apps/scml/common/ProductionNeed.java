package jnegmas.apps.scml.common;

import jnegmas.PyCopiable;
import jnegmas.situated.Contract;

import java.util.HashMap;

public class ProductionNeed implements PyCopiable {
    public int product;
    public int quantity_to_buy;
    public int quantity_in_storage;
    public int step;
    public Contract needed_for = null;


    @Override
    public void fromMap(HashMap<String, Object> dict) {
        product = (int) dict.get("product");
        quantity_to_buy = (int) dict.get("quantity_to_buy");
        quantity_in_storage = (int) dict.get("quantity_in_storage");
        step = (int) dict.get("step");
        needed_for = new Contract();
        needed_for.fromMap((HashMap<String, Object>) dict.get("needed_for"));
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("product", product);
        map.put("quantity_to_buy", quantity_to_buy);
        map.put("quantity_in_storage", quantity_in_storage);
        map.put("step", step);
        map.put("needed_for", needed_for == null? null : needed_for.toMap());
        return map;
    }
}
