package jnegmas;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class Handler<T> implements InvocationHandler {

    T shadow;

    public Handler(T python_object){
        shadow = python_object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ArrayList<Object> converted = new ArrayList<>();
        for(Object arg: args){
            if (arg instanceof HashMap){
                try {
                    converted.add(JNegmasApp.createFromMap((HashMap<String, Object>) arg));
                }catch(Exception e){
                    converted.add(arg);
                }
            }
        }
        Object result = method.invoke(shadow, args);
        if (result instanceof HashMap){
            try {
                converted.add(JNegmasApp.createFromMap((HashMap<String, Object>) result));
            }catch(Exception e){
                converted.add(result);
            }
        }
        return result;
    }
}
