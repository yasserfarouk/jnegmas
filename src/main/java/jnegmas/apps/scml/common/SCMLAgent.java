package jnegmas.apps.scml.common;

import jnegmas.PyReadable;

import java.util.HashMap;

public class SCMLAgent implements PyReadable {
    public String name;

    public SCMLAgent(String name){
        this.name = name;
    }
    public SCMLAgent(){
        this.name = null;
    }

    @Override
    public void fromMap(HashMap<String, Object> dict) {
        name = (String) dict.get("name");
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", name);
        return map;
    }
}
