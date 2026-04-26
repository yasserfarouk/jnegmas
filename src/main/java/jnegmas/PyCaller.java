package jnegmas;

import java.lang.reflect.*;
import java.util.*;
import java.util.List;

/**
 * Defines an object that implements its methods by calling a python target object.
 *
 * Examples of classes in JNegmas that extend this one are AgentWorldInterface, and FactorySimulator. It is used when
 * there is no intention to implement the corresponding classes in Java and making them available to python code running
 * NegMAS.
 */
public class PyCaller<T> {

    protected T shadow = null;
    protected Class<?> myInterface = null;


    public Class<?> getInterface(){
        return myInterface;
    }

    /**
     * Get the underlying class for a type, or null if the type is a variable type.
     * @param type the type
     * @return the underlying class
     */
    public static Class<?> getClass(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        else if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        else if (type instanceof GenericArrayType) {
            Type componentType = ((GenericArrayType) type).getGenericComponentType();
            Class<?> componentClass = getClass(componentType);
            if (componentClass != null ) {
                return Array.newInstance(componentClass, 0).getClass();
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    public static <T> List<Class<?>> getTypeArguments(
            Class<T> baseClass, Class<? extends T> childClass) {
        Map<Type, Type> resolvedTypes = new HashMap<Type, Type>();
        Type type = childClass;
        // start walking up the inheritance hierarchy until we hit baseClass
        while (! getClass(type).equals(baseClass)) {
            if (type instanceof Class) {
                // there is no useful information for us in raw types, so just keep going.
                type = ((Class) type).getGenericSuperclass();
            }
            else {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class<?> rawType = (Class) parameterizedType.getRawType();

                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                TypeVariable<?>[] typeParameters = rawType.getTypeParameters();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    resolvedTypes.put(typeParameters[i], actualTypeArguments[i]);
                }

                if (!rawType.equals(baseClass)) {
                    type = rawType.getGenericSuperclass();
                }
            }
        }
        // finally, for each actual type argument provided to baseClass, determine (if possible)
        // the raw class for that type argument.
        Type[] actualTypeArguments;
        if (type instanceof Class) {
            actualTypeArguments = ((Class) type).getTypeParameters();
        }
        else {
            actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        }
        List<Class<?>> typeArgumentsAsClasses = new ArrayList<Class<?>>();
        // resolve types by chasing down type variables.
        for (Type baseType: actualTypeArguments) {
            while (resolvedTypes.containsKey(baseType)) {
                baseType = resolvedTypes.get(baseType);
            }
            typeArgumentsAsClasses.add(getClass(baseType));
        }
        return typeArgumentsAsClasses;
    }

    public PyCaller() {
        myInterface = getTypeArguments(PyCaller.class, getClass()).get(0);
    }

    /**
     * Connects the proxy to an existing python object
     *
     * @param pythonObject The python object to connect to.
     */
    public PyCaller(T pythonObject) {
        this();
        setPythonShadow(pythonObject);
    }

    public void setPythonShadow(T pythonObject) {
        shadow = pythonObject;
        /*
        if (pythonObject == null) {
            shadow = null;
            return;
        }
        if (myInterface == null){
            myInterface = getTypeArguments(PyCaller.class, getClass()).get(0);
        }
        Converter converter = new Converter(pythonObject);
        shadow = (T) Proxy.newProxyInstance(myInterface.getClassLoader(),
                new Class[]{myInterface},
                converter);
        */
    }

    public T getPythonShadow() {
        return shadow;
    }

    /**
     * Creates a python object of the corresponding class and connects this object to it
     * @param kwargs Key-value pairs representing the parameters to pass to the constructor. Null will call the default.
     * @throws NoSuchFieldException if a field does not exist in the python target
     */
    public void createPythonShadow(Map<String, Object> kwargs) throws NoSuchFieldException {
        String pythonClassName = getClass().getName().substring(1);
        Object pythonObject = JNegmasApp.createPythonShadowFromMap(pythonClassName, kwargs);
        if (pythonObject != null) {
            setPythonShadow((T) pythonObject);
            return;
        }
        throw new NoClassDefFoundError(String.format("Python class %s could not be constructed using %s", pythonClassName
        , kwargs.toString()));
    }
}
