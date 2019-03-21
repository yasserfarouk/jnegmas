package jnegmas.situated;

import jnegmas.PyCallable;
import jnegmas.PyCaller;
import jnegmas.outcomes.Issue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class AgentWorldInterface implements PyCaller {

    PyAgentWorldInterface shadow;

    public Object getState() {
        return this.shadow.get_state();
    }


    public float relativeTime() {
        return this.shadow.relative_time();
    }


    public int getCurrentStep() {
        return this.shadow.get_current_step();
    }


    public int getNSteps() {
        return this.shadow.get_n_steps();
    }


    public int getDefaultSigningDelay() {
        return this.shadow.get_default_signing_delay();
    }


    public boolean requestNegotiation(ArrayList<Issue> issues, ArrayList<String> partners, String req_id
            , ArrayList<String> roles, HashMap<String, Object> annotation, Optional<String> mechanism_name
            , HashMap<String, Object> mechanism_params) {
        ArrayList<HashMap<String, Object>> pyissues = new ArrayList<>();
        for (Issue issue : issues) {
            pyissues.add(issue.toMap());
        }
        return this.shadow.request_negotiation(
                pyissues, partners, req_id, roles, annotation, mechanism_name, mechanism_params
        );
    }


    public void logInfo(String msg) { this.shadow.loginfo(msg); }


    public void logWarning(String msg) {
        this.shadow.logwarning(msg);
    }


    public void logDebug(String msg) {
        this.shadow.logdebug(msg);
    }


    public void logError(String msg) {
        this.shadow.logerror(msg);
    }


    public void setPythonShadow(PyCallable python_object) {
        this.shadow = (PyAgentWorldInterface) python_object;
    }


    public PyCallable getPythonShadow() {
        return this.shadow;
    }
}
