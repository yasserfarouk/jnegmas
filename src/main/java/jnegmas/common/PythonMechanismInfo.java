package jnegmas.common;

import jnegmas.PyCaller;
import jnegmas.PyCopyable;
import jnegmas.outcomes.Issue;

import java.util.ArrayList;
import java.util.HashMap;

public class PythonMechanismInfo extends PyCaller<MechanismInfo> implements PyCopyable, MechanismInfo  {
    public String id;
    public Integer nOutcomes;
    public ArrayList<Issue> issues = new ArrayList<>();
    public ArrayList<HashMap<String, Object>> outcomes;
    public double timeLimit;
    public int nSteps, maxN_agents;
    public boolean dynamicEntry;
    public HashMap<String, Object> annotation;

    @Override
    public ArrayList<HashMap<String, Object>> randomOutcomes(int n) {
        return shadow.randomOutcomes(n);
    }

    @Override
    public ArrayList<HashMap<String, Object>> discreteOutcomes(int nMax) {
        return shadow.discreteOutcomes(nMax);
    }

    @Override
    public Integer outcomeIndex(HashMap<String, Object> outcome) {
        return shadow.outcomeIndex(outcome);
    }
}
