package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

import java.util.ArrayList;

public class ProductionFailure implements PyCopyable {
    public int line;
    public RunningCommandInfo command;
    public ArrayList<MissingInput> missingInputs = new ArrayList<>();
    public double missingMoney;
    public int missingSpace;

    /*
    @Override
    public void fromMap(HashMap<String, Object> dict) {
        line = (int) dict.get("line");
        command = new RunningCommandInfo();
        try {
            command.fromMap((HashMap<String, Object>) dict.get("command"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        missingInputs = (ArrayList<MissingInput>) dict.get("missingInputs");
        missingMoney = (double) dict.get("missingMoney");
        missingSpace = (int) dict.get("missingSpace");
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("line", line);
        map.put("command", command == null? null : command.toMap());
        map.put("missingInputs", missingInputs);
        map.put("missingMoney", missingMoney);
        map.put("missingSpace", missingSpace);
        return map;
    }
    */
}

