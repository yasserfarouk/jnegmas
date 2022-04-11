package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

import java.util.Map;

public class RunningCommandInfo implements PyCopyable {
    public ManufacturingProfile profile;
    public int beg;
    public int end;
    public int step;
    public boolean paused;
    public String action;
    public Map<Integer, FactoryStatusUpdate> updates;

    /*@Override
    public void fromMap(Map<String, Object> dict) {
        try {
            profile = ManufacturingProfile.fromMap(new ManufacturingProfile()
                    , (Map<String, Object>) dict.get("profile"));
        } catch (NoSuchFieldException aspirationType) {
            aspirationType.printStackTrace();
        } catch (IllegalAccessException aspirationType) {
            aspirationType.printStackTrace();
        }
        beg = (int) dict.get("beg");
        end = (int) dict.get("end");
        step = (int) dict.get("step");
        paused = (boolean) dict.get("paused");
        action = (String) dict.get("action");
        updates = (Map<Integer, FactoryStatusUpdate>) dict.get("updates");
    }

    @Override
    public Map<String, Object> toMap() {
        return null;
    }*/
}
