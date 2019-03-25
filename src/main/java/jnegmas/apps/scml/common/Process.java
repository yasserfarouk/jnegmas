package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

import java.util.ArrayList;

public class Process implements PyCopyable {
    public int id;
    public int productionLevel;
    public String name;
    public ArrayList<InputOutput> inputs = new ArrayList<>();
    public ArrayList<InputOutput> outputs = new ArrayList<>();
    public double historicalCost;

    /*
    @Override
    public void fromMap(HashMap<String, Object> dict) {
        id = (int) dict.get("id");
        productionLevel = (int) dict.get("productionLevel");
        name = (String) dict.get("name");
        inputs = (ArrayList<InputOutput>) dict.get("inputs");
        outputs = (ArrayList<InputOutput>) dict.get("outputs");
        historicalCost = (double) dict.get("historicalCost");
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("productionLevel", productionLevel);
        map.put("name", name);
        map.put("inputs", inputs);
        map.put("outputs", outputs);
        map.put("historicalCost", historicalCost);
        return map;
    }*/
}
