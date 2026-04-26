package jnegmas.outcomes;

import java.util.List;
import java.util.Map;

public abstract class RangeIssue<T> extends AbstractIssue<T> {
    T min, max;

    public RangeIssue(T min, T max) {
        this.min = min;
        this.max = max;
    }

    public RangeIssue(String name, T min, T max) {
        super(name);
        this.min = min;
        this.max = max;
    }

    public RangeIssue(String name){
        name = name;
    }

}
