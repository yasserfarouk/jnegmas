package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

import java.util.ArrayList;
import java.util.List;

public class Process implements PyCopyable {
    public int id;
    public int productionLevel;
    public String name;
    public List<InputOutput> inputs = new ArrayList<>();
    public List<InputOutput> outputs = new ArrayList<>();
    public double historicalCost;

    /*
    @Override
    public void fromMap(Map<String, Object> dict) {
        id = (int) dict.get("id");
        productionLevel = (int) dict.get("productionLevel");
        name = (String) dict.get("name");
        inputs = (List<InputOutput>) dict.get("inputs");
        outputs = (List<InputOutput>) dict.get("outputs");
        historicalCost = (double) dict.get("historicalCost");
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("productionLevel", productionLevel);
        map.put("name", name);
        map.put("inputs", inputs);
        map.put("outputs", outputs);
        map.put("historicalCost", historicalCost);
        return map;
    }*/
}
