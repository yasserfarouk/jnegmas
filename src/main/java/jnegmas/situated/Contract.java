package jnegmas.situated;

import jnegmas.BaseCopyable;
import jnegmas.common.MechanismState;
import jnegmas.outcomes.Issue;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A contract (signed or to be signed).
 */
public class Contract extends BaseCopyable {
    public ArrayList<String> partners = new ArrayList<>();
    public HashMap<String, Object> agreement = new HashMap<>();
    public HashMap<String, Object> annotation = new HashMap<>();
    public ArrayList<Issue> issues = new ArrayList<>();
    public Integer signed_at = null;
    public Integer concluded_at = null;
    public Integer to_be_signed_at = null;
    public ArrayList<String> signatures = new ArrayList<>();
    public MechanismState state = null;
    public String id;


}
