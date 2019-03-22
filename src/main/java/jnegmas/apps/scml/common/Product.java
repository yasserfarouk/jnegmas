package jnegmas.apps.scml.common;

import jnegmas.BaseCopyable;

import java.util.HashMap;

public class Product extends BaseCopyable {
    public int id;
    public int production_level;
    public String name = "";
    public Integer expires_in = null;
    public Double catalog_price = null;

    public String toString(){
        return String.format("%s (%f)", name, catalog_price);
    }

    @Override
    public void fromMap(HashMap<String, Object> dict) {
        id = (int) dict.get("id");
        production_level = (int) dict.get("production_level");
        name = (String) dict.get("name");
        expires_in = (Integer) dict.get("expires_in");
        catalog_price = (Double) dict.get("catalog_price");
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("production_level", production_level);
        map.put("name", name);
        map.put("expires_in", expires_in);
        map.put("catalog_price", catalog_price);
        return map;
    }
}
