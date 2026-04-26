package jnegmas.apps.scml.common;

import jnegmas.JNegmasApp;
import jnegmas.NotImplementedYet;
import jnegmas.PyCopyable;
import jnegmas.Utils;
import jnegmas.outcomes.DoubleListIssue;
import jnegmas.outcomes.DoubleRangeIssue;
import jnegmas.outcomes.IntRangeIssue;
import jnegmas.outcomes.Issue;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

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
    public Double minPenalty=null;
    public Double maxPenalty=null;
    public Integer minSigningDelay=null;
    public Integer maxSigningDelay=null;
    public Double moneyResolution;
    public String id;
    public List<Issue> issues = new ArrayList<>();

    public CFP(){
        super();
        id = Utils.randomString(16);
    }

    public CFP(boolean isBuy, String publisher, int product, int minTime, int maxTime, int minQuantity, int maxQuantity
            , double minUnitPrice, double maxUnitPrice) {
        super();
        this.isBuy = isBuy;
        this.publisher = publisher;
        this.product = product;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
        this.minUnitPrice = minUnitPrice;
        this.maxUnitPrice = maxUnitPrice;
        // todo populate issues and outcomes here
    }
/*
    @Override
    public void fromMap(Map<String, Object> map) {
        isBuy = (boolean) map.get("isBuy");
        publisher = (String) map.get("publisher");
        product = (int) map.get("product");
        minTime = (int) map.get("minTime");
        maxTime = (int) map.get("maxTime");
        minQuantity = (int) map.get("minQuantity");
        maxQuantity = (int) map.get("maxQuantity");
        minUnitPrice = ((Number) map.get("minUnitPrice")).doubleValue();
        maxUnitPrice = ((Number) map.get("maxUnitPrice")).doubleValue();
        if (map.get("minPenalty") == null) {
            minPenalty = null; maxPenalty = null;
        }else {
            minPenalty = ((Number) map.get("minPenalty")).doubleValue();
            maxPenalty = ((Number) map.get("maxPenalty")).doubleValue();
        }
        if (map.get("minSigningDelay") == null){
            minSigningDelay = null; maxSigningDelay = null;
        }else {
            minSigningDelay = (int) map.get("minSigningDelay");
            maxSigningDelay = (int) map.get("maxSigningDelay");
        }
        if (map.get("moneyResolution") == null){
            moneyResolution = null;
        }else {
            moneyResolution = ((Number) map.get("moneyResolution")).doubleValue();
        }
        id = (String) map.get("id");
        issues = getIssues();
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
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
        map.put("minSigningDelay", minSigningDelay);
        map.put("maxSigningDelay", maxSigningDelay);
        map.put("moneyResolution", moneyResolution);
        map.put("id", id);
        return map;
    }
*/
    public List<Issue> getIssues() throws NotImplementedYet {
        ArrayList<Issue> issues = new ArrayList<>();
        issues.add(new IntRangeIssue("time", minTime, maxTime));
        issues.add(new IntRangeIssue("quantity", minQuantity, maxQuantity));
        if (this.moneyResolution != null) {
            int n = (int)((maxUnitPrice - minUnitPrice)/(moneyResolution)) + 1;
            if (n < 2){
                issues.add(new DoubleListIssue("unit_price", new Double[]{minUnitPrice}));
            }
            Double[] values = new Double[n];
            for(int i = 0; i < n; i++){
                values[i] = minUnitPrice + i * moneyResolution;
            }
            issues.add(new DoubleListIssue("unit_price", values));
        }else{
            if (Math.abs(minUnitPrice - maxUnitPrice)<1e-6){
                issues.add(new DoubleListIssue("unit_price", new Double[]{minUnitPrice}));
            }else {
                issues.add(new DoubleRangeIssue("unit_price", minUnitPrice, maxUnitPrice));
            }
        }
        if (minSigningDelay != null){
            issues.add(new IntRangeIssue("signing_delay", minSigningDelay, maxSigningDelay));
        }
        if (minPenalty != null){
            issues.add(new DoubleRangeIssue("penalty", minPenalty, maxPenalty));
        }
        return issues;
    }

    public List<Map<String, Object>> getOutcomes() throws NotImplementedYet {
        throw new NotImplementedYet();
    }
    public boolean satisfies(Map<String, Object> query) throws NotImplementedYet {
        throw new NotImplementedYet();
    }
}
