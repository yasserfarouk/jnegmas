package jnegmas.sao;

import java.util.List;
import java.util.Map;

public class RandomNegotiator extends AbstractSAONegotiator {
    private String id;

    @Override
    public int respond(SAOState state, Map<String, Object> outcome) {
        if (Math.random() < 0.5)
            return ACCEPT_OFFER;
        else
            return REJECT_OFFER;
    }

    @Override
    public Map<String, Object> propose(SAOState state) {
        List<Map<String, Object>> outcomes = this.ami.randomOutcomes(1);
        return outcomes.get((int)(Math.random() * outcomes.size()));
    }

    @Override
    public void setID(String id) {
        this.id = id;
    }

    @Override
    public String getID() {
        return this.id;
    }
}
