package jnegmas.common;

import jnegmas.PyCallable;
import jnegmas.PyCopyable;

import java.util.List;
import java.util.Map;

public interface AgentMechanismInterface extends PyCallable, PyCopyable {
    List<Map<String, Object>> randomOutcomes(int n);
    List<Map<String, Object>> discreteOutcomes(int nMax);
    Integer outcomeIndex(Map<String, Object> outcome);

    List<NegotiatorInfo> getParticipants();

    MechanismState getState();

    Map<String, Object> getRequirements();

    int getNNegotiators();


    List<Map<Object, Object>> getOutcomes();
}
