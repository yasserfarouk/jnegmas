package jnegmas;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * The interface defining an object that can be copied back and forth between Java and Python.
 */
public interface PyCopyable {

    default String getPythonClassName(){
        return this.getClass().getName().substring(1);
    }

    default void fromMap(HashMap<String, Object> dict) throws NoSuchFieldException, IllegalAccessException, InstantiationException{
        for(String key: dict.keySet()) {
            if (key == JNegmasApp.PYTHON_CLASS_IDENTIFIER){
                continue;
            }
            if (key.startsWith("_") || key.startsWith("java") || key.startsWith("python_")){
                continue;
            }
            Field field = null;
            Class<?> current = this.getClass();
            while(current.getSuperclass() != null) {
                try {
                    field = current.getField(key);
                    break;
                } catch (NoSuchFieldException e) {
                    current = current.getSuperclass();
                }
            }
            if (field == null) {
                System.out.format("field %s not found for a %s\n", key, this.getClass().getName());
                continue;
            }
            Object value = dict.get(key);
            if (value instanceof PyCopyable){
                value = ((PyCopyable) value).toMap();
            }else{
                if (value instanceof HashMap){
                    /*if (((HashMap) value).containsKey(JNegmasApp.PYTHON_CLASS_IDENTIFIER))
                        value = JNegmasApp.createJavaObjectFromMap((HashMap) value);
                    else*/ if (PyCopyable.class.isAssignableFrom(field.getType())){
                        value = JNegmasApp.createJavaObjectFromMap(field.getType().getName(), (HashMap) value);
                    }
                }
            }
            field.set(this, value);
        }
    }
    default HashMap<String, Object> toMap() throws IllegalAccessException{
        {
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
}
