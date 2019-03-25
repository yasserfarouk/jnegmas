package jnegmas.utilities;

import jnegmas.PyCaller;

import java.util.HashMap;

public class PythonUtilityFunction extends PyCaller<UtilityFunction> implements UtilityFunction{
    @Override
    public Double call(HashMap<String, Object> outcome) {
        return shadow.call(outcome);
    }
}
