package jnegmas.common;

import jnegmas.PyCaller;
import jnegmas.PyCopyable;
import jnegmas.outcomes.Issue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PythonAgentMechanismInterface extends PyCaller<AgentMechanismInterface>
        implements AgentMechanismInterface {
    public String id;
    public Integer nOutcomes;
    public List<Issue> issues = new ArrayList<>();
    public Double timeLimit;
    public Integer nSteps, maxNAgents;
    public Double stepTimeLimit;
    public List<Map<String, Object>> outcomes;
    public boolean dynamicEntry;
    public Map<String, Object> annotation;

    public PythonAgentMechanismInterface(){

    }

    @Override
    public List<Map<String, Object>> randomOutcomes(int n) {

        return shadow.randomOutcomes(n);
    }

    @Override
    public List<Map<String, Object>> discreteOutcomes(int nMax) {
        return shadow.discreteOutcomes(nMax);
    }

    @Override
    public Integer outcomeIndex(Map<String, Object> outcome) {
        return shadow.outcomeIndex(outcome);
    }

    @Override
    public List<NegotiatorInfo> getParticipants() {
        return shadow.getParticipants();
    }

    @Override
    public MechanismState getState() {
        return shadow.getState();
    }

    @Override
    public Map<String, Object> getRequirements() {
        return shadow.getRequirements();
    }

    @Override
    public int getNNegotiators() {
        return shadow.getNNegotiators();
    }

    @Override
    public List<Map<Object, Object>> getOutcomes() {
        return shadow.getOutcomes();
    }

    /*
    @Override
    public void fromMap(Map<String, Object> map) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        AgentMechanismInterface.super.fromMap(map);
        id = (String) map.get("id");
        nOutcomes = (Integer) map.get("nOutcomes");
        issues = (List<Issue>) map.get("issues");
        Object tmp = map.get("timeLimit");
        if (tmp == null) timeLimit = null;
        else
            timeLimit = ((Number) tmp).doubleValue();
        tmp = map.get("nSteps");
        if (tmp == null) nSteps = null;
        else
            nSteps = ((Number) tmp).intValue();
        tmp = map.get("maxNAgents");
        if (tmp == null) maxNAgents = null;
        else
            maxNAgents = ((Number) tmp).intValue();
        dynamicEntry = (Boolean) map.get("dynamicEntry");
        annotation = (Map<String, Object>) map.get("annotation");
        outcomes = (List<Map<String, Object>>) map.get("outcomes");
        tmp = map.get("stepTimeLimit");
        if (tmp ==null) stepTimeLimit = null;
        else
            stepTimeLimit = ((Number) tmp).doubleValue();
    }*/

}
