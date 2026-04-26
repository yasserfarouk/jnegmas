package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

public class ManufacturingProfile implements PyCopyable {
    public int nSteps;
    public double cost;
    public double initialPauseCost;
    public double runningPauseCost;
    public double resumptionCost;
    public double cancellationCost;
    public int line;
    public Process process;

    /*
    @Override
    public void fromMap(Map<String, Object> dict) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        nSteps = (int) dict.get("nSteps");
        cost = (double) dict.get("cost");
        initialPauseCost = (double) dict.get("initialPauseCost");
        runningPauseCost = (double) dict.get("runningPauseCost");
        resumptionCost = (double) dict.get("resumptionCost");
        cancellationCost = (double) dict.get("cancellationCost");
        line = (int) dict.get("line");
        process = new Process();
        process.fromMap((Map<String, Object>) dict.get("process"));
    }

    @Override
    public Map<String, Object> toMap() throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        map.put("nSteps", nSteps);
        map.put("cost", cost);
        map.put("initialPauseCost", initialPauseCost);
        map.put("runningPauseCost", runningPauseCost);
        map.put("resumptionCost", resumptionCost);
        map.put("cancellationCost", cancellationCost);
        map.put("line", line);
        map.put("process", process.toMap());
        return map;
    }*/
}
