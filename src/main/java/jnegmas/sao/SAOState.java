package jnegmas.sao;

import jnegmas.common.MechanismState;

import java.util.Map;

public class SAOState extends MechanismState {
    public Map<String, Object> currentOffer;
    public String currentProposer;
    public Integer nAcceptances;

    /*
    @Override
    public String getPythonClassName() {
        return getClass().getName().substring(1);
    }

    @Override
    public void fromMap(Map<String, Object> map) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        super.fromMap(map);
        currentOffer = (Map<String, Object>) map.get("currentOffer");
        currentProposer = (String) map.get("currentProposer");
        Object tmp = map.get("nAcceptances");
        if (tmp == null) nAcceptances = null;
        else nAcceptances = ((Number) tmp).intValue();
    }

    @Override
    public Map<String, Object> toMap() throws IllegalAccessException {
        Map<String, Object> map = super.toMap();
        map.put("currentOffer", currentOffer);
        map.put("currentProposer", currentProposer);
        map.put("nAcceptances", nAcceptances);
        return map;
    }
    */
}
