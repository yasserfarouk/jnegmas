package jnegmas;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The interface defining an object that can be copied back and forth between Java and Python.
 */
public interface PyCopyable {

    default String getPythonClassName() {
        return this.getClass().getName().substring(1);
    }

    default void fromMap(Map<String, Object> map) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        if (map == null) return;
        for (String key : map.keySet()) {
            if (key == JNegmasApp.PYTHON_CLASS_IDENTIFIER) {
                continue;
            }
            if (key.startsWith("_") || key.startsWith("java") || key.startsWith("python_")) {
                continue;
            }
            Field field = null;
            Class<?> current = this.getClass();
            while (current.getSuperclass() != null) {
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
            Object value = map.get(key);
            if (value instanceof PyCopyable) {
                value = ((PyCopyable) value).toMap();
            } else if (value instanceof Map) {
                if (PyCopyable.class.isAssignableFrom(field.getType())) {
                    value = JNegmasApp.createJavaObjectFromMap(field.getType().getName(), (Map) value);
                }
            } else if (field.getType() == Boolean.class) {
                if (value == null) value = null;
                else value = (Boolean) value;
            } else if (field.getType() == boolean.class) {
                if (value == null) value = false;
                else value = (boolean) value;
            } else if (field.getType() == Double.class) {
                if (value == null) value = null;
                else value = ((Number) value).doubleValue();
            } else if (field.getType() == Integer.class) {
                if (value == null) value = null;
                else value = ((Number) value).intValue();
            } else if (field.getType() == double.class) {
                if (value == null) value = -1.0;
                else value = ((Number) value).doubleValue();
            } else if (field.getType() == int.class) {
                if (value == null) value = -1;
                else value = ((Number) value).intValue();
            }
            field.set(this, value);
        }
    }

    default Map<String, Object> toMap() throws IllegalAccessException {
        {
            Map<String, Object> map = new HashMap<>();
            for (Field field : this.getClass().getFields())
                map.put(field.getName(), JNegmasApp.genericToMap(field.get(this)));
            map.put(JNegmasApp.PYTHON_CLASS_IDENTIFIER, this.getClass().getName().substring(1));
            return map;
        }
    }
}
