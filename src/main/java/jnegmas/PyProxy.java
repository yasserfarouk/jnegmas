package jnegmas;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;


/**
 * The base class of objects that have a python shadow and just passes all calls to this python shadow.
 * @param <T>
 */
public class PyProxy<T> implements PyCaller<T> {
    public T shadow;

    public PyProxy(){

    }

    public PyProxy (T python_object){
        setPythonShadow(python_object);
    }

    @Override
    public void setPythonShadow(T python_object) {
        Handler<T> handler = new Handler<>(python_object);
        setPythonShadow(python_object);
        shadow = (T) Proxy.newProxyInstance(PyCaller.class.getClassLoader(),
                new Class[] { PyCaller.class },
                handler);
    }

    @Override
    public T getPythonShadow() {
        return shadow;
    }

}
