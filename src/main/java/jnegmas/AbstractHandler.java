package jnegmas;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public abstract class AbstractHandler<T> implements InvocationHandler {

    T target;

    public AbstractHandler(T pythonObject){
        target = pythonObject;
    }

    abstract Object convert(Object arg);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ((args == null) || (args.length < 1)){
            return method.invoke(target, args);
        }
        Object[] converted = new Object[args.length];
        for(int i=0; i< args.length; i++){
            converted[i] = convert(args[i]);
        }
        Object result = method.invoke(target, converted);
        return convert(result);
    }

}
