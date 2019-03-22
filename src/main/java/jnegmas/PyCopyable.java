package jnegmas;

import java.util.HashMap;

/**
 * The interface defining an object that can be copied back and forth between Java and Python.
 */
public interface PyCopyable {

    String getPythonClassName();

    void fromMap(HashMap<String, Object> dict) throws NoSuchFieldException, IllegalAccessException, InstantiationException;
    HashMap<String, Object> toMap() throws IllegalAccessException;
}
