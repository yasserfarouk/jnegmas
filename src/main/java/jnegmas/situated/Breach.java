package jnegmas.situated;

import jnegmas.PyCopyable;

import java.util.ArrayList;

public class Breach implements PyCopyable {
    public Contract contract;
    public String perpetrator;
    public String type;
    public ArrayList<String> victims;
    public double level;
    public int step;
    public String id;
}
