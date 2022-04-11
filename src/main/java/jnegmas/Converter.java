package jnegmas;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class Converter implements InvocationHandler {
    Object target;

    public Converter(Object pythonObject){
        target = pythonObject;
    }

    Object to_python(Object arg) throws IllegalAccessException {
        if(PyCopyable.class.isAssignableFrom(arg.getClass())) {
            PyCopyable obj = (PyCopyable) arg;
            return JNegmasApp.createPythonObjectFromMap(obj.getPythonClassName(), obj.toMap());
        }
        return arg;
    }

    Object from_python(Object arg){
        if (arg instanceof Map){
            try {
                return JNegmasApp.createJavaObjectFromMap((Map<String, Object>) arg);
            }catch(Exception e){
                return arg;
            }
        }
        return arg;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ((args == null) || (args.length < 1)){
            return from_python(method.invoke(target, args));
        }
        /*Object[] converted = new Object[args.length];
        for(int i=0; i< args.length; i++){
            converted[i] = to_python(args[i]);
        }*/
        Object result = method.invoke(target, args);
        return from_python(result);
    }

}
