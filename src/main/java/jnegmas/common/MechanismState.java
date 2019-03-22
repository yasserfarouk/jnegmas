package jnegmas.common;

import jnegmas.BaseCopyable;

import java.util.HashMap;

public class MechanismState extends BaseCopyable {
    public boolean running, started, broken, timedout, has_error;
    public int step, n_negotiators;
    public double time, relative_time;
    public HashMap<String, Object> agreement;
    public String error_details;
    public MechanismInfo info;

    public boolean ended(){
        return started && (broken || timedout || (agreement == null));
    }

}
