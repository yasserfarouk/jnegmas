package jnegmas.apps.scml.common;

import jnegmas.PyReadable;
import jnegmas.situated.Contract;

import java.util.HashMap;

public class Job implements PyReadable {
    public int profile;
    public int time;
    public int line;
    public String action;
    public Contract contract=null;
    public boolean override;

    @Override
    public void fromMap(HashMap<String, Object> dict) {
        profile = (int) dict.get("profile");
        time = (int) dict.get("time");
        line = (int) dict.get("line");
        action = (String) dict.get("action");
        contract = new Contract();
        contract.fromMap((HashMap<String, Object>)dict.get("contract"));
        override = (boolean) dict.get("override");
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("profile", profile);
        map.put("time", time);
        map.put("line", line);
        map.put("action", action);
        map.put("contract", contract == null? null: contract.toMap());
        map.put("override", override);
        return map;
    }
}
