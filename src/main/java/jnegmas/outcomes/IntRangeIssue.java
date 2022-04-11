package jnegmas.outcomes;

import java.util.*;

public class IntRangeIssue extends RangeIssue<Integer> {

    public IntRangeIssue(Integer min, Integer max) {
        super(min, max);
    }

    public IntRangeIssue(String name, Integer min, Integer max) {
        super(name, min, max);
    }

    public IntRangeIssue(String name) {
        super(name);
    }

    @Override
    public Integer[] getValues(int size) {
        Integer[] vals;
        int diff = max - min + 1;
        if (diff <= size){
            vals = new Integer[diff];
            for (int i=min; i<= max; i++){
                vals[i] = i;
            }
        }else{
            List<Integer> valList = new ArrayList<>();
            for (int i=min; i<= max; i++){
                valList.add(i);
            }
            Collections.shuffle(valList);
            vals = new Integer[size];
            vals = Arrays.copyOfRange(valList.toArray(vals), 0, size);
        }
        return vals;
    }

    @Override
    public String getType() {
        return "discrete";
    }

    @Override
    public Integer cardinality() {
        return max - min + 1;
    }

    @Override
    public Integer rand() {
        Random rnd = new Random();
        return rnd.nextInt(max - min) + min; // Todo confirm whether nextInt is inclusive of bound
    }

    @Override
    public Integer[] randOutcomes(int n, boolean withReplacement, boolean failIfNotEnough) {
        Integer[] vals = new Integer[max - min + 1];
        for(int i=0;i<max-min+1; i++)
            vals[i] = min + i;
        List<Integer> lst = Arrays.asList(vals);
        IntListIssue i = new IntListIssue(vals);
        return i.randOutcomes(n, withReplacement, failIfNotEnough);
    }

    @Override
    public Integer randInvalid() {
        Random rnd = new Random();
        if (rnd.nextBoolean())
            return min - rnd.nextInt(max - min + 10) - min;
        return max + rnd.nextInt(max - min + 10) + min;
    }
}
