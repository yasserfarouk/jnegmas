package jnegmas.situated;

import jnegmas.PyCopyable;
import jnegmas.common.MechanismState;
import jnegmas.outcomes.Issue;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A contract (signed or to be signed).
 */
public class Contract implements PyCopyable {
    public ArrayList<String> partners = new ArrayList<>();
    public HashMap<String, Object> agreement = new HashMap<>();
    public HashMap<String, Object> annotation = new HashMap<>();
    public ArrayList<Issue> issues = new ArrayList<>();
    public Integer signedAt = null;
    public Integer concludedAt = null;
    public Integer toBeSignedAt = null;
    public ArrayList<String> signatures = new ArrayList<>();
    public MechanismState state = null;
    public String id;


}
