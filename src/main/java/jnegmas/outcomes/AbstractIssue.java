package jnegmas.outcomes;

import jnegmas.Utils;

public abstract class AbstractIssue<T> implements Issue<T> {
    String name;

    public AbstractIssue(){
        this(Utils.randomString(16));
    }

    public AbstractIssue(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
