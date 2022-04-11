package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;
import jnegmas.situated.Contract;

public class ProductionNeed implements PyCopyable {
    public int product;
    public int quantityToBuy;
    public int quantityInStorage;
    public int step;
    public Contract neededFor = null;


    /*
    @Override
    public void fromMap(Map<String, Object> dict) throws NoSuchFieldException, IllegalAccessException {
        product = (int) dict.get("product");
        quantityToBuy = (int) dict.get("quantityToBuy");
        quantityInStorage = (int) dict.get("quantityInStorage");
        step = (int) dict.get("step");
        neededFor = new Contract();
        neededFor.fromMap((Map<String, Object>) dict.get("neededFor"));
    }

    @Override
    public Map<String, Object> toMap() throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        map.put("product", product);
        map.put("quantityToBuy", quantityToBuy);
        map.put("quantityInStorage", quantityInStorage);
        map.put("step", step);
        map.put("neededFor", neededFor == null? null : neededFor.toMap());
        return map;
    }
    */
}
