package jnegmas;

import java.util.HashMap;

public interface PyCopiable {
    void fromMap(HashMap<String, Object> dict);
    HashMap<String, Object> toMap();

    static PyCopiable fromMap(PyCopiable object, HashMap<String, Object> dict){
        object.fromMap(dict);
        return object;
    }
    static HashMap<String, Object> toMap(PyCopiable object){
        if (object == null)
            return null;
        return object.toMap();
    }
}
