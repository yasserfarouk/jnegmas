package jnegmas.situated;

import jnegmas.negotiators.Negotiator;
import jnegmas.outcomes.Issue;

import java.util.List;
import java.util.Map;

public class NegotiationRequestInfo {
    public List<Issue> issues;
    public List<String> partners;
    public Map<String, Object> annotation;
    public Negotiator negotiator;
    public Map<String, Object> extra;
    public String reqId;

    public NegotiationRequestInfo(List<Issue> issues, List<String> partners, Map<String, Object> annotation
            , Negotiator negotiator, Map<String, Object> extra, String reqId) {
        this.issues = issues;
        this.partners = partners;
        this.annotation = annotation;
        this.negotiator = negotiator;
        this.extra = extra;
        this.reqId = reqId;
    }
}
