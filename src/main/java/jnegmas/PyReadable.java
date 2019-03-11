package jnegmas;

import java.util.HashMap;

public interface PyReadable {
    void fromMap(HashMap<String, Object> dict);
    HashMap<String, Object> toMap();

    static PyReadable fromMap(PyReadable object, HashMap<String, Object> dict){
        object.fromMap(dict);
        return object;
    }
    static HashMap<String, Object> toMap(PyReadable object){
        if (object == null)
            return null;
        return object.toMap();
    }
}
