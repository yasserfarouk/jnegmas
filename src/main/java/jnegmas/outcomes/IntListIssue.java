package jnegmas.outcomes;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class IntListIssue extends ListIssue<Integer> {

    Integer min, max;

    public IntListIssue(String name, Integer[] values) {
        super(name, values);
    }

    public IntListIssue(String name, List<Integer> values) {
        super(name, values);
    }

    public IntListIssue(Integer[] values) {
        super(values);
    }

    public IntListIssue(List<Integer> values) {
        super(values);
    }

    @Override
    public Integer randInvalid() {
        if (values.length< 1)
            return null;
        if (min==null){
            Integer[] sorted = Arrays.copyOf(values, values.length);
            min = sorted[0];
            max = sorted[sorted.length-1];
        }
        Random rnd = new Random();
        if (rnd.nextBoolean())
            return min - rnd.nextInt(max - min + 10) - min;
        return max + rnd.nextInt(max - min + 10) + min;
    }
}
