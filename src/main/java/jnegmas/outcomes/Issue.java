package jnegmas.outcomes;

import jnegmas.PyCopyable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Issue Type which specifies which fields of the Issue object are filled
 */
enum IssueType{
    ListOfStrings,
    ListOfIntegers,
    ListOfDoubles,
    DoubleRange,
    IntegerRange
}

/**
 * Represents an Issue that can be the subject of a negotiation.
 */
public class Issue implements PyCopyable {
    ArrayList<String> strValues;
    ArrayList<Integer> intValues;
    ArrayList<Double> doubleValues;
    double minDouble, maxDouble;
    int minInt, maxInt;
    IssueType type;


    @Override
    public void fromMap(HashMap<String, Object> dict) {
        switch (((Number) dict.get("type")).intValue()) {
            case 0:
                type = IssueType.ListOfStrings;
                this.strValues = (ArrayList<String>) dict.get("values");
                break;
            case 1:
                type = IssueType.ListOfIntegers;
                this.intValues = (ArrayList<Integer>) dict.get("values");
                break;
            case 2:
                type = IssueType.ListOfDoubles;
                this.doubleValues = (ArrayList<Double>) dict.get("values");
                break;
            case 3:
                type = IssueType.DoubleRange;
                this.minInt = (int) dict.get("min");
                this.maxInt = (int) dict.get("max");
                break;
            case 4:
                type = IssueType.IntegerRange;
                this.minDouble = (double) dict.get("min");
                this.maxDouble = (double) dict.get("max");
                break;
            default:
                throw new IllegalArgumentException("Unknown type given to fromMap");
        }

    }

    @Override
    public HashMap<String, Object> toMap() {
        return null;
    }
}
