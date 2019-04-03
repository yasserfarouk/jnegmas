package jnegmas.outcomes;

import java.util.*;

/**
 * Represents an Issue that can be the subject of a negotiation.
 */
public abstract class ListIssue<T> extends AbstractIssue<T> {
    T[] values;

    public ListIssue(String name, T[] values){
        super(name);
        this.values = values;
    }

    public ListIssue(String name, List<T> values){
        this(name, (T[]) values.toArray());
    }
    public ListIssue(T[] values){
        super();
        this.values = values;
    }
    public ListIssue(List<T> values){
        this((T[]) values.toArray());
    }

    @Override
    public Map<String, Object> toMap() {
        return null;
    }

    @Override
    public T[] getValues(int size) {
        if (values==null){
            return null;
        }
        if (values.length < size)
            return values;
        T[] vals = Arrays.copyOf(values, size);
        return vals;
    }

    @Override
    public String getType() {
        if (values==null){
            return null;
        }
        return "discrete";
    }

    @Override
    public Integer cardinality() {
        if (values==null){
            return null;
        }
        return values.length;
    }

    @Override
    public T rand() {
        if (values==null){
            return null;
        }
        Random  rnd = new Random();
        return values[(int)(rnd.nextFloat()*values.length)];
    }

    @Override
    public T[] randOutcomes(int n, boolean withReplacement, boolean failIfNotEnough) {
        if (values==null){
            return null;
        }
        Random rnd = new Random();
        if ((!withReplacement) && failIfNotEnough && values.length<n){
            throw new RuntimeException(String.format("Cannot sample %s from %s without replacement", n, values.length));
        }
        T[] vals = Arrays.copyOf(values, n);
        if (withReplacement){
            for (int i=0;i< n; i++){
                vals[i] = rand();
            }
            return vals;
        }
        List<T> lst = Arrays.asList(values);
        Collections.shuffle(lst);
        for (int i=0; i< n; i++)
            vals[i] = lst.get(i);
        return vals;
    }

    @Override
    public boolean isContinuous() {
        return false;
    }

    @Override
    public boolean isDiscrete() {
        return true;
    }
}
