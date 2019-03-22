package jnegmas.situated;

import jnegmas.BaseCopyable;
import jnegmas.situated.Contract;

import java.util.ArrayList;

public class Breach extends BaseCopyable {
    public Contract contract;
    public String perpetrator;
    public String type;
    public ArrayList<String> victims;
    public double level;
    public int step;
    public String id;
}
