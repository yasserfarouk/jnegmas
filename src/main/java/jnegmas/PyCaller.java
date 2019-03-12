package jnegmas;

public interface PyCaller {
    void setPythonShadow(PyCallable python_object);
    PyCallable getPythonShadow();
}
