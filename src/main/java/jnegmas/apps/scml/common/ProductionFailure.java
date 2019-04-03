package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

import java.util.ArrayList;
import java.util.List;

public class ProductionFailure implements PyCopyable {
    public int line;
    public RunningCommandInfo command;
    public List<MissingInput> missingInputs = new ArrayList<>();
    public double missingMoney;
    public int missingSpace;

    /*
    @Override
    public void fromMap(Map<String, Object> dict) {
        line = (int) dict.get("line");
        command = new RunningCommandInfo();
        try {
            command.fromMap((Map<String, Object>) dict.get("command"));
        } catch (NoSuchFieldException aspirationType) {
            aspirationType.printStackTrace();
        } catch (IllegalAccessException aspirationType) {
            aspirationType.printStackTrace();
        }
        missingInputs = (List<MissingInput>) dict.get("missingInputs");
        missingMoney = (double) dict.get("missingMoney");
        missingSpace = (int) dict.get("missingSpace");
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("line", line);
        map.put("command", command == null? null : command.toMap());
        map.put("missingInputs", missingInputs);
        map.put("missingMoney", missingMoney);
        map.put("missingSpace", missingSpace);
        return map;
    }
    */
}

