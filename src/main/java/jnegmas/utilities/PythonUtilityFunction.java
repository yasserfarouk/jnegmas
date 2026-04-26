package jnegmas.utilities;

import jnegmas.PyCaller;
import jnegmas.PyCopyable;
import jnegmas.common.PythonAgentMechanismInterface;

import java.util.Map;

public class PythonUtilityFunction extends PyCaller<UtilityFunction> implements UtilityFunction, PyCopyable {
    Double reserved_value;
    PythonAgentMechanismInterface ami;

    @Override
    public Double call(Map<String, Object> outcome) {
        return shadow.call(outcome);
    }

    /*
    @Override
    public void fromMap(Map<String, Object> map) {
        ami = (PythonAgentMechanismInterface) map.get("ami");
    }*/
}
