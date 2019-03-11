package jnegmas.apps.scml.common;

import jnegmas.PyReadable;

import java.util.HashMap;

public class ManufacturingProfile implements PyReadable {
    public int n_steps;
    public double cost;
    public double initial_pause_cost;
    public double running_pause_cost;
    public double resumption_cost;
    public double cancellation_cost;
    public int line;
    public Process process;

    @Override
    public void fromMap(HashMap<String, Object> dict) {
        n_steps = (int) dict.get("n_steps");
        cost = (double) dict.get("cost");
        initial_pause_cost = (double) dict.get("initial_pause_cost");
        running_pause_cost = (double) dict.get("running_pause_cost");
        resumption_cost = (double) dict.get("resumption_cost");
        cancellation_cost = (double) dict.get("cancellation_cost");
        line = (int) dict.get("line");
        process = new Process();
        process.fromMap((HashMap<String, Object>) dict.get("process"));
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("n_steps", n_steps);
        map.put("cost", cost);
        map.put("initial_pause_cost", initial_pause_cost);
        map.put("running_pause_cost", running_pause_cost);
        map.put("resumption_cost", resumption_cost);
        map.put("cancellation_cost", cancellation_cost);
        map.put("line", line);
        map.put("process", process.toMap());
        return map;
    }
}
