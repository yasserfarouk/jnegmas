package jnegmas;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * A base class that implements `PyCopyable` with sensible getPythonClassName, toMap and fromMap. It uses reflection
 * to achieve that. This implementation does a deep decoding and encoding.
 */
public class BaseCopyable implements PyCopyable{

    public BaseCopyable(){

    }

    public BaseCopyable(HashMap<String, Object> map) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        this.fromMap(map);
    }


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
