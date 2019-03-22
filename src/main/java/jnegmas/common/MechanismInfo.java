package jnegmas.common;

import jnegmas.*;
import jnegmas.outcomes.Issue;

import java.util.ArrayList;
import java.util.HashMap;

public class MechanismInfo extends PyProxy<PyMechanismInfo> implements PyCopyable {
    PyMechanismInfo shadow;
    public String id;
    public Integer n_outcomes;
    public ArrayList<Issue> issues = new ArrayList<>();
    public ArrayList<HashMap<String, Object>> outcomes;
    public double time_limit;
    public int n_steps, max_n_agents;
    public boolean dynamic_entry;
    public HashMap<String, Object> annotation;


    @Override
    public String getPythonClassName() {
        return null;
    }

    @Override
    public void fromMap(HashMap<String, Object> dict) throws NoSuchFieldException, IllegalAccessException {

    }

    @Override
    public HashMap<String, Object> toMap() throws IllegalAccessException {
        return null;
    }
}
