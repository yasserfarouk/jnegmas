package jnegmas.apps.scml.common;

import jnegmas.PyCopyable;

public class ProductionReport implements PyCopyable {
    public int line;
    public RunningCommandInfo started = null;
    public RunningCommandInfo continuing = null;
    public RunningCommandInfo finished = null;
    public ProductionFailure failure = null;
    public FactoryStatusUpdate updates = new FactoryStatusUpdate();

    public boolean failed(){
        return failure != null;
    }

    public boolean isEmpty(){
        return isNoProduction() && updates.isEmpty();
    }

    private boolean isNoProduction() {
        return started == null && finished == null && failure == null;
    }

    /*
    @Override
    public void fromMap(HashMap<String, Object> dict) throws NoSuchFieldException, IllegalAccessException {
        line = (int) dict.get("line");
        continuing = new RunningCommandInfo();
        continuing.fromMap((HashMap<String, Object>) dict.get("continuing"));
        started = new RunningCommandInfo();
        started.fromMap((HashMap<String, Object>) dict.get("started"));
        finished = new RunningCommandInfo();
        finished.fromMap((HashMap<String, Object>) dict.get("finished"));
        failure = new ProductionFailure();
        failure.fromMap((HashMap<String, Object>) dict.get("failure"));
        updates = new FactoryStatusUpdate();
        updates.fromMap((HashMap<String, Object>) dict.get("updates"));
    }

    @Override
    public HashMap<String, Object> toMap() throws IllegalAccessException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("line", line);
        map.put("started", started == null? null : started.toMap());
        map.put("continuing", continuing == null? null : continuing.toMap());
        map.put("finished", finished);
        map.put("failure", failure);
        map.put("updates", updates);
        return map;
    }*/
}
