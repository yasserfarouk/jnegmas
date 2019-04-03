package jnegmas.situated;

import jnegmas.PyCopyable;
import jnegmas.common.MechanismState;
import jnegmas.outcomes.Issue;
import jnegmas.sao.SAOState;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * A contract (signed or to be signed).
 */
public class Contract implements PyCopyable {
    public List<String> partners = new ArrayList<>();
    public Map<String, Object> agreement = new HashMap<>();
    public Map<String, Object> annotation = new HashMap<>();
    public List<Issue> issues = new ArrayList<>();
    public Integer signedAt = null;
    public Integer concludedAt = null;
    public Integer nullifiedAt = null;
    public Integer toBeSignedAt = null;
    public List<String> signatures = new ArrayList<>();
    public SAOState mechanismState = null;
    public String id;


}
