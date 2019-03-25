package jnegmas;

import java.util.HashMap;

/**
 * A handler class for dynamic proxies that connect to python
 * @param <T> The `PyCallable` class type.
 */
public class PythonToJavaHandler<T> extends AbstractHandler<T> {


    public PythonToJavaHandler(T pythonObject) {
        super(pythonObject);
    }

    Object convert(Object arg){
        if (arg instanceof HashMap){
            try {
                return JNegmasApp.createJavaObjectFromMap((HashMap<String, Object>) arg);
            }catch(Exception e){
                return arg;
            }
        }
        return arg;
    }

}
