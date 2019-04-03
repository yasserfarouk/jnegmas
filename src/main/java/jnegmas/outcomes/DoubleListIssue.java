package jnegmas.outcomes;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DoubleListIssue extends ListIssue<Double> {
    Double min, max;

    public DoubleListIssue(String name, Double[] values) {
        super(name, values);
    }

    public DoubleListIssue(String name, List<Double> values) {
        super(name, values);
    }

    public DoubleListIssue(Double[] values) {
        super(values);
    }

    public DoubleListIssue(List<Double> values) {
        super(values);
    }

    @Override
    public Double randInvalid() {
        if (values.length< 1)
            return null;
        if (min==null){
            Double[] sorted = Arrays.copyOf(values, values.length);
            min = sorted[0];
            max = sorted[sorted.length-1];
        }
        Random rnd = new Random();
        if (rnd.nextBoolean())
            return min - rnd.nextDouble() * (max - min + 10.0) - min;
        return max + rnd.nextDouble() * (max - min + 10.0) + min;
    }
}
