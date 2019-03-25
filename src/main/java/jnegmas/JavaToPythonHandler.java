package jnegmas;

public class JavaToPythonHandler<T> extends AbstractHandler<T> {

    public JavaToPythonHandler(T pythonObject) {
        super(pythonObject);
    }

    Object convert(Object arg){
        if (arg instanceof PyCopyable){
            try {
                return ((PyCopyable) arg).toMap();
            }catch(Exception e){
                return arg;
            }
        }
        return arg;
    }

}
