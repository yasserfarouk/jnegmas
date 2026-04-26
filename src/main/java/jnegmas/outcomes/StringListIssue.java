package jnegmas.outcomes;

import jnegmas.Utils;

import java.util.List;

public class StringListIssue extends ListIssue<String> {
    public StringListIssue(String name, String[] values) {
        super(name, values);
    }

    public StringListIssue(String name, List<String> values) {
        super(name, values);
    }

    public StringListIssue(String[] values) {
        super(values);
    }

    public StringListIssue(List<String> values) {
        super(values);
    }

    @Override
    public String randInvalid() {
        return Utils.randomString(50);
    }
}
