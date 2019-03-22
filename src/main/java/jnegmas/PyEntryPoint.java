package jnegmas;

import java.util.HashMap;

/**
 * The interface implemented by NegMAS python entry point class. A member of JNegmasApp (python) implements it and can
 * be called by any object to run python code directly.
 */
public interface PyEntryPoint {

    PyCallable create(HashMap<String, Object> kwargs);
}
