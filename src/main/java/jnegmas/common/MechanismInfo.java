package jnegmas.common;

import jnegmas.*;
import jnegmas.outcomes.Issue;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class MechanismInfo extends PyProxy<PyMechanismInfo> implements PyCopyable {
    PyMechanismInfo shadow;
    public String id;
    public Integer n_outcomes;
    public ArrayList<Issue> issues = new ArrayList<>();
    public ArrayList<HashMap<String, Object>> outcomes;
    public double time_limit;
    public int n_steps, max_n_agents;
    public boolean dynamic_entry;
    public HashMap<String, Object> annotation;


    public String getPythonClassName() {
        return this.getClass().getName().substring(1);
    }


    public void fromMap(HashMap<String, Object> dict) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        for(String key: dict.keySet()) {
            if (key == JNegmasApp.PYTHON_CLASS_IDENTIFIER){
                continue;
            }
            Field field = this.getClass().getField(key);
            Object value = dict.get(key);
            if (value instanceof PyCopyable){
                value = ((PyCopyable) value).toMap();
            }else{
                if (value instanceof HashMap){
                    /*if (((HashMap) value).containsKey(JNegmasApp.PYTHON_CLASS_IDENTIFIER))
                        value = JNegmasApp.createFromMap((HashMap) value);
                    else*/ if (PyCopyable.class.isAssignableFrom(field.getType())){
                        value = JNegmasApp.createFromMap(field.getType().getName(), (HashMap) value);
                    }
                }
            }
            field.set(this, value);
        }
    }

    public HashMap<String, Object> toMap() throws IllegalAccessException {
        HashMap<String, Object> map = new HashMap<>();
        for(Field field: this.getClass().getFields()){
            if(!field.isAccessible()){
                continue;
            }
            Object value = field.get(this);
            if(value instanceof PyCopyable){
                value = ((PyCopyable) value).toMap();
            }
            map.put(field.getName(), value);
        }
        return map;
    }
}
