package jnegmas.utilities;

import java.util.HashMap;
import java.util.Optional;

public abstract class AbstractUtilityFunction implements PyUtilityFunction {
    @Override
    public Optional<Double> call(HashMap<String, Object> outcome) {
        return Optional.empty();
    }
}
