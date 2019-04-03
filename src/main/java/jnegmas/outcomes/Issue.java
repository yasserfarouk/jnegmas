package jnegmas.outcomes;

import jnegmas.PyCopyable;

public interface Issue<T> extends PyCopyable {

    T[] getValues(int size);
    String getType();
    Integer cardinality();
    T rand();
    T[] randOutcomes(int n, boolean withReplacement, boolean failIfNotEnough);
    T randInvalid();

    String getName();
    void setName(String name);

    default boolean isContinuous(){
        return getType().equals("continuous");
    }
    default boolean isDiscrete(){
        return ! isContinuous();
    }


}
