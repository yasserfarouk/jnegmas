package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

public class Product implements PyCopyable {
    public int id;
    public int productionLevel;
    public String name = "";
    public Integer expiresIn = null;
    public Double catalogPrice = null;

    public String toString(){
        return String.format("%s (%f)", name, catalogPrice);
    }

    /*@Override
    public void fromMap(HashMap<String, Object> dict) {
        id = (int) dict.get("id");
        productionLevel = (int) dict.get("productionLevel");
        name = (String) dict.get("name");
        expiresIn = (Integer) dict.get("expiresIn");
        catalogPrice = (Double) dict.get("catalogPrice");
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("productionLevel", productionLevel);
        map.put("name", name);
        map.put("expiresIn", expiresIn);
        map.put("catalogPrice", catalogPrice);
        return map;
    }*/
}
