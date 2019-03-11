package jnegmas.utilities;

import jnegmas.PyReadable;

import java.util.HashMap;
import java.util.Optional;

public class AbstractUtilityFunction implements PyUtilityFunction, PyReadable {
    @Override
    public void fromMap(HashMap<String, Object> dict) {

    }

    @Override
    public HashMap<String, Object> toMap() {
        return null;
    }

    @Override
    public Optional<Double> call(HashMap<String, Object> outcome) {
        return Optional.empty();
    }
}
