package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;
import jnegmas.situated.Contract;

public class Job implements PyCopyable {
    public int profile;
    public int time;
    public int line;
    public String action;
    public Contract contract=null;
    public boolean override;

}
