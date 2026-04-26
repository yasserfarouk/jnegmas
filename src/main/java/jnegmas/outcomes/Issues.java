package jnegmas.outcomes;

import java.util.*;

public class Issues {

    static Integer nOutcomes(List<Issue> issues){
        int nOutcomes = 1;
        for(Issue issue: issues){
            if (issue.isContinuous())
                return null;
            nOutcomes *= issue.cardinality();
        }
        return nOutcomes;
    }

    /**
     * Converts a list of issues and values to an outcome
     * @param issues the list of issues
     * @param values the list of values
     * @return A hashmap with issues names as keys and values as values.
     */
    static Map<String, Object> asOutcome(List<Issue> issues, List<Object> values){
        HashMap<String, Object> result = new HashMap<>();
        for(int i=0;i<issues.size(); i++){
            result.put(issues.get(i).getName(), values.get(i));
        }
        return result;
    }
    static Map<String, Object> asOutcomeFromNames(List<String> issue_names, List<Object> values){
        HashMap<String, Object> result = new HashMap<>();
        for(int i=0;i<issue_names.size(); i++){
            result.put(issue_names.get(i), values.get(i));
        }
        return result;
    }


    /*
    private static boolean isCountable(List<Issue> issues) {
        boolean countable = true;
        for(Issue issue: issues){
            if (issue.isContinuous())
                return false;
        }
        return true;
    }

    private static Integer cardinality(List<Issue> issues) {
        if (! isCountable(issues))
            return null;
        int count = 1;
        for(Issue issue: issues){
            count *= issue.cardinality();
        }
        return count;
    }

    static Map<String, Object> enumerate(List<Issue> issues,int maxNOutcomes){
        List<String> names = new ArrayList<>();
        for (Issue issue: issues){
            names.add(issue.getName());
        }
        List<List<Object>> values = new ArrayList<>();
        for (Issue issue : issues) {
            values.add(Arrays.asList(issue.getValues(maxNOutcomes)));
        }
        int nOutcomes = 1;
        for (List<Object> v: values)
            nOutcomes *= v.size();

        if (nOutcomes<= maxNOutcomes){

        }

    }

    static Map<String, Object> sample(List<Issue> issues, int nOutcomes, boolean withReplacement, boolean FailIfNOtEnough){

    }
    */
    // Todo: implement the above functionality
}
