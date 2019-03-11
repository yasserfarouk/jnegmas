package jnegmas.utilities;

import java.util.HashMap;
import java.util.Optional;

public interface PyUtilityFunction {
    Optional<Double> call(HashMap<String, Object> outcome);
}
