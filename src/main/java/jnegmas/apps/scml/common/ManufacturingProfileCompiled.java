package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

import java.util.HashMap;
import java.util.Map;

public class ManufacturingProfileCompiled implements PyCopyable {
    public int nSteps;
    public double cost;
    public double initialPauseCost;
    public double runningPauseCost;
    public double resumptionCost;
    public double cancellationCost;
    public int line;
    public int process;
/*
    @Override
    public void fromMap(Map<String, Object> map) {
        nSteps = (int) map.get("nSteps");
        cost = (double) map.get("cost");
        initialPauseCost = (double) map.get("initialPauseCost");
        runningPauseCost = (double) map.get("runningPauseCost");
        resumptionCost = (double) map.get("resumptionCost");
        cancellationCost = (double) map.get("cancellationCost");
        line = (int) map.get("line");
        process = (int) map.get("process");
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
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
    */
}
