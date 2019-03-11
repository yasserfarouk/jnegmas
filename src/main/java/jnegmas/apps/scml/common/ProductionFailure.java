package jnegmas.apps.scml.common;

import jnegmas.PyReadable;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductionFailure implements PyReadable {
    public int line;
    public RunningCommandInfo command;
    public ArrayList<MissingInput> missing_inputs = new ArrayList<>();
    public double missing_money;
    public int missing_space;

    @Override
    public void fromMap(HashMap<String, Object> dict) {
        line = (int) dict.get("line");
        command = new RunningCommandInfo();
        command.fromMap((HashMap<String, Object>) dict.get("command"));
        missing_inputs = (ArrayList<MissingInput>) dict.get("missing_inputs");
        missing_money = (double) dict.get("missing_money");
        missing_space = (int) dict.get("missing_space");
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("line", line);
        map.put("command", command == null? null : command.toMap());
        map.put("missing_inputs", missing_inputs);
        map.put("missing_money", missing_money);
        map.put("missing_space", missing_space);
        return map;
    }
}

