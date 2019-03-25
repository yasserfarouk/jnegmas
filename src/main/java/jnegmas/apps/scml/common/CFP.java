package jnegmas.apps.scml.common;

import jnegmas.NotImplementedYet;
import jnegmas.PyCopyable;
import jnegmas.outcomes.Issue;

import java.util.ArrayList;
import java.util.HashMap;

public class CFP implements PyCopyable {
    public boolean isBuy;
    public String publisher;
    public int product;
    public int minTime;
    public int maxTime;
    public int minQuantity;
    public int maxQuantity;
    public double minUnitPrice;
    public double maxUnitPrice;
    public double minPenalty;
    public double maxPenalty;
    public boolean penaltyNegotiable = false;
    public int minSigningDelay;
    public int maxSigningDelay;
    public boolean singingDelayNegotiable = false;
    public double moneyResolution;
    public boolean hasMoneyResolution;
    public String id;

    @Override
    public void fromMap(HashMap<String, Object> dict) {
        isBuy = (boolean) dict.get("isBuy");
        publisher = (String) dict.get("publisher");
        product = (int) dict.get("product");
        minTime = (int) dict.get("minTime");
        maxTime = (int) dict.get("maxTime");
        minQuantity = (int) dict.get("minQuantity");
        maxQuantity = (int) dict.get("maxQuantity");
        minUnitPrice = ((Number)dict.get("minUnitPrice")).doubleValue();
        maxUnitPrice = ((Number)dict.get("maxUnitPrice")).doubleValue();
        minPenalty = ((Number)dict.get("minPenalty")).doubleValue();
        maxPenalty = ((Number)dict.get("maxPenalty")).doubleValue();
        penaltyNegotiable = (boolean) dict.get("hasPenalty");
        minSigningDelay = (int) dict.get("minSigningDelay");
        maxSigningDelay = (int) dict.get("maxSigningDelay");
        singingDelayNegotiable = (boolean) dict.get("hasSigningDelay");
        moneyResolution = ((Number)dict.get("moneyResolution")).doubleValue();
        hasMoneyResolution = (boolean) dict.get("hasMoneyResolution");
        id = (String) dict.get("id");
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("isBuy", isBuy);
        map.put("publisher", publisher);
        map.put("product", product);
        map.put("minTime", minTime);
        map.put("maxTime", maxTime);
        map.put("minQuantity", minQuantity);
        map.put("maxQuantity", maxQuantity);
        map.put("minUnitPrice", minUnitPrice);
        map.put("maxUnitPrice", maxUnitPrice);
        map.put("minPenalty", minPenalty);
        map.put("maxPenalty", maxPenalty);
        map.put("hasPenalty", penaltyNegotiable);
        map.put("minSigningDelay", minSigningDelay);
        map.put("maxSigningDelay", maxSigningDelay);
        map.put("hasSigningDelay", singingDelayNegotiable);
        map.put("moneyResolution", moneyResolution);
        map.put("hasMoneyResolution", hasMoneyResolution);
        map.put("id", id);
        return map;
    }

    public boolean satisfies(HashMap<String, Object> query) throws NotImplementedYet {
        throw new NotImplementedYet();
    }

    public ArrayList<Issue> getIssues() throws NotImplementedYet {
        throw new NotImplementedYet();
    }

    public ArrayList<HashMap<String, Object>> getOutcomes() throws NotImplementedYet {
        throw new NotImplementedYet();
    }
}
