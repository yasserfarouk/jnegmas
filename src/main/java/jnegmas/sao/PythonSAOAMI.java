package jnegmas.sao;

import jnegmas.common.MechanismState;
import jnegmas.common.NegotiatorInfo;
import jnegmas.common.PythonAgentMechanismInterface;

import java.util.List;
import java.util.Map;

public class PythonSAOAMI extends PythonAgentMechanismInterface implements SAOAMI {
    boolean endOnNoResponse = true;
    boolean publishProposer = true;
    boolean publishNAcceptances = false;

    public PythonSAOAMI(boolean endOnNoResponse, boolean publishProposer, boolean publishNAcceptances) {
        super();
        this.endOnNoResponse = endOnNoResponse;
        this.publishProposer = publishProposer;
        this.publishNAcceptances = publishNAcceptances;
    }

    @Override
    public List<Map<String, Object>> randomOutcomes(int n) {
        return super.randomOutcomes(n);
    }

    @Override
    public List<Map<String, Object>> discreteOutcomes(int nMax) {
        return super.discreteOutcomes(nMax);
    }

    @Override
    public Integer outcomeIndex(Map<String, Object> outcome) {
        return super.outcomeIndex(outcome);
    }

    @Override
    public List<NegotiatorInfo> getParticipants() {
        return super.getParticipants();
    }

    @Override
    public MechanismState getState() {
        return super.getState();
    }

    @Override
    public Map<String, Object> getRequirements() {
        return super.getRequirements();
    }

    @Override
    public int getNNegotiators() {
        return super.getNNegotiators();
    }

    /*
    @Override
    public void fromMap(Map<String, Object> map) {
        super.fromMap(map);
        endOnNoResponse = (boolean) map.get("endOnNoResponse");
        publishNAcceptances = (boolean) map.get("publishNAcceptances");
        publishProposer = (boolean) map.get("publishProposer");
    }
    */
}
