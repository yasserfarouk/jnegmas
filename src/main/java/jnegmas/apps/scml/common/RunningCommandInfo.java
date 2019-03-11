package jnegmas.apps.scml.common;

import jnegmas.PyReadable;

import java.util.HashMap;

public class RunningCommandInfo implements PyReadable {
    public ManufacturingProfile profile;
    public int beg;
    public int end;
    public int step;
    public boolean paused;
    public String action;
    public HashMap<Integer, FactoryStatusUpdate> updates;

    @Override
    public void fromMap(HashMap<String, Object> dict) {
        profile = (ManufacturingProfile) PyReadable.fromMap(new ManufacturingProfile()
                , (HashMap<String, Object>) dict.get("profile"));
        beg = (int) dict.get("beg");
        end = (int) dict.get("end");
        step = (int) dict.get("step");
        paused = (boolean) dict.get("paused");
        action = (String) dict.get("action");
        updates = (HashMap<Integer, FactoryStatusUpdate>) dict.get("updates");
    }

    @Override
    public HashMap<String, Object> toMap() {
        return null;
    }
}
