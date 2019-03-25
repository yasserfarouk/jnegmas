package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

import java.util.HashMap;

public class RunningCommandInfo implements PyCopyable {
    public ManufacturingProfile profile;
    public int beg;
    public int end;
    public int step;
    public boolean paused;
    public String action;
    public HashMap<Integer, FactoryStatusUpdate> updates;

    /*@Override
    public void fromMap(HashMap<String, Object> dict) {
        try {
            profile = ManufacturingProfile.fromMap(new ManufacturingProfile()
                    , (HashMap<String, Object>) dict.get("profile"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
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
    }*/
}
