package jnegmas.sao;

import jnegmas.PyCopyable;

import java.util.Map;

public class SAOResponse implements PyCopyable {
    public int response;
    public Map<String, Object> outcome;
}
