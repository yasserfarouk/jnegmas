package jnegmas.outcomes;


import java.util.Random;

public class DoubleRangeIssue extends RangeIssue<Double> {
    public DoubleRangeIssue(Double min, Double max) {
        super(min, max);
    }

    public DoubleRangeIssue(String name, Double min, Double max) {
        super(name, min, max);
    }

    public DoubleRangeIssue(String name) {
        super(name);
    }

    @Override
    public Double[] getValues(int size) {
        Double[] vals;
        double diff = max - min;
        double delta = diff/(size-1);
        vals = new Double[size];
        for (int i=0; i< size; i++){
            vals[i] = min + delta * i;
        }
        return vals;
    }

    @Override
    public String getType() {
        return "continuous";
    }

    @Override
    public Integer cardinality() {
        return null;
    }

    @Override
    public Double rand() {
        Random rnd = new Random();
        return rnd.nextDouble() *(max-min) + min;
    }

    @Override
    public Double[] randOutcomes(int n, boolean withReplacement, boolean failIfNotEnough) {
        Random rnd = new Random();
        Double[] vals = new Double[n];
        for(int i=0;i<n;i++)
            vals[i] = rand();
        return vals;
    }

    @Override
    public Double randInvalid() {
        Random rnd = new Random();
        if(rnd.nextBoolean())
            return min - rnd.nextDouble() * (max-min + 10) - min;
        return max + rnd.nextDouble() * (max-min + 10) + min;
    }
}
