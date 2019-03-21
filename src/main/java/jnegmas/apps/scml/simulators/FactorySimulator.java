package jnegmas.apps.scml.simulators;

import jnegmas.PyCallable;
import jnegmas.PyCaller;

public class FactorySimulator implements PyCaller {
    PyFactorySimulator shadow;

    public FactorySimulator(PyFactorySimulator shadow){
        this.setPythonShadow(shadow);
    }


    @Override
    public void setPythonShadow(PyCallable python_object) {
        this.shadow = (PyFactorySimulator) python_object;
    }

    @Override
    public PyCallable getPythonShadow() {
        return this.shadow;
    }
}
