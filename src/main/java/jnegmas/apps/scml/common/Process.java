package jnegmas.apps.scml.common;

import jnegmas.BaseCopyable;

import java.util.ArrayList;
import java.util.HashMap;

public class Process extends BaseCopyable {
    public int id;
    public int production_level;
    public String name;
    public ArrayList<InputOutput> inputs = new ArrayList<>();
    public ArrayList<InputOutput> outputs = new ArrayList<>();
    public double historical_cost;

    @Override
    public void fromMap(HashMap<String, Object> dict) {
        id = (int) dict.get("id");
        production_level = (int) dict.get("production_level");
        name = (String) dict.get("name");
        inputs = (ArrayList<InputOutput>) dict.get("inputs");
        outputs = (ArrayList<InputOutput>) dict.get("outputs");
        historical_cost = (double) dict.get("historical_cost");
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("production_level", production_level);
        map.put("name", name);
        map.put("inputs", inputs);
        map.put("outputs", outputs);
        map.put("historical_cost", historical_cost);
        return map;
    }
}
