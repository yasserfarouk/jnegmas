package jnegmas.utilities;

import jnegmas.PyCallable;

import java.util.HashMap;
import java.util.Optional;

public interface PyUtilityFunction extends PyCallable {
    Optional<Double> call(HashMap<String, Object> outcome);
}
