package jnegmas.situated;

import jnegmas.PyCaller;
import jnegmas.outcomes.Issue;

import java.util.List;
import java.util.Map;

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
