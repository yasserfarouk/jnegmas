package jnegmas.apps.scml.common;

import jnegmas.PyCaller;
import jnegmas.PyCopyable;

public class SCMLAgent implements PyCopyable {
    public String name;

    public SCMLAgent(String name){

        this.name = name;
    }
    public SCMLAgent(){
        super();
        this.name = null;
    }

    /*
    @Override
    public void fromMap(Map<String, Object> dict) {
        name = (String) dict.get("name");
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        return map;
    }*/
}
