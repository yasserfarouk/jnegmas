package jnegmas;

/**
 * Defines an object that has a python shadow. It is intended to be used this way:
 *
 */
public interface PyCaller<T> {
    void setPythonShadow(T python_object);
    T getPythonShadow();
}
