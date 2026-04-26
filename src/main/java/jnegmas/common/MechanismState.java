package jnegmas.common;

import jnegmas.PyCopyable;

import java.util.Map;

public class MechanismState implements PyCopyable {
    public boolean running, started, broken, timedout, hasError;
    public int step, nNegotiators;
    public double time, relativeTime;
    public Map<String, Object> agreement;
    public String errorDetails;

    public boolean ended(){
        return started && (broken || timedout || (agreement == null));
    }

}
