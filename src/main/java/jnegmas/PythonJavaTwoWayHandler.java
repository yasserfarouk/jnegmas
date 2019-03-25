package jnegmas;

import java.util.HashMap;

/**
 * A handler class for dynamic proxies that connect to python
 * @param <T> The `PyCallable` class type.
 */
public class PythonJavaTwoWayHandler<T> extends AbstractHandler<T> {
    PythonToJavaHandler<T> pythonToJavaHandler;
    JavaToPythonHandler<T> javaToPythonHandler;

    public PythonJavaTwoWayHandler(T pythonObject) {
        pythonToJavaHandler = new PythonToJavaHandler<>(pythonObject);
        javaToPythonHandler = new JavaToPythonHandler<>(pythonObject);
    }

    Object convert(Object arg){
        if (arg instanceof HashMap)
            return pythonToJavaHandler.convert(arg);
        else if (arg instanceof PyCopyable)
            return javaToPythonHandler.convert(arg);
        return arg;
    }

}
