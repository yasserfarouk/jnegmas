package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

import java.util.HashMap;

public class ManufacturingProfileCompiled implements PyCopyable {
    public int nSteps;
    public double cost;
    public double initialPauseCost;
    public double runningPauseCost;
    public double resumptionCost;
    public double cancellationCost;
    public int line;
    public int process;

    @Override
    public void fromMap(HashMap<String, Object> dict) {
        nSteps = (int) dict.get("nSteps");
        cost = (double) dict.get("cost");
        initialPauseCost = (double) dict.get("initialPauseCost");
        runningPauseCost = (double) dict.get("runningPauseCost");
        resumptionCost = (double) dict.get("resumptionCost");
        cancellationCost = (double) dict.get("cancellationCost");
        line = (int) dict.get("line");
        process = (int) dict.get("process");
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("nSteps", nSteps);
        map.put("cost", cost);
        map.put("initialPauseCost", initialPauseCost);
        map.put("runningPauseCost", runningPauseCost);
        map.put("resumptionCost", resumptionCost);
        map.put("cancellationCost", cancellationCost);
        map.put("line", line);
        map.put("process", process);
        return map;
    }
}
