package jnegmas.situated;

import jnegmas.PyCaller;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents the interface between an agent and the world it is running in.
 */
public class PythonAgentWorldInterface extends PyCaller<AgentWorldInterface> implements AgentWorldInterface {

    public PythonAgentWorldInterface(AgentWorldInterface pythonObject) {
        super(pythonObject);
    }

    @Override
    public Object getState() {

        return shadow.getState();
    }

    @Override
    public double relativeTime() {

        return shadow.relativeTime();
    }

    @Override
    public int getCurrentStep() {
        return shadow.getCurrentStep();
    }

    @Override
    public int getNSteps() {
        return shadow.getNSteps();
    }

    @Override
    public int getDefaultSigningDelay() {

        return shadow.getDefaultSigningDelay();
    }

    @Override
    public boolean requestNegotiation(ArrayList<HashMap<String, Object>> issues, ArrayList<String> partners
            , String reqId, ArrayList<String> roles, HashMap<String, Object> annotation, String mechanismName
            , HashMap<String, Object> mechanismParams) {
        return shadow.requestNegotiation(issues, partners, reqId, roles, annotation, mechanismName, mechanismParams);
    }

    @Override
    public void loginfo(String msg) {
        shadow.loginfo(msg);
    }

    @Override
    public void logwarning(String msg) {
        shadow.logwarning(msg);
    }

    @Override
    public void logdebug(String msg) {
        shadow.logdebug(msg);
    }

    @Override
    public void logerror(String msg) {
        shadow.logerror(msg);
    }
}
