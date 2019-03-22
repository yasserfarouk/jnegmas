package jnegmas;

import java.util.HashMap;

public interface PyEntryPoint {

    PyCallable create(HashMap<String, Object> kwargs);
}
