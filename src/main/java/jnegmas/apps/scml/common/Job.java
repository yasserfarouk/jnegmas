package jnegmas.apps.scml.common;

import jnegmas.BaseCopyable;
import jnegmas.situated.Contract;

import java.util.HashMap;

public class Job extends BaseCopyable {
    public int profile;
    public int time;
    public int line;
    public String action;
    public Contract contract=null;
    public boolean override;

}
