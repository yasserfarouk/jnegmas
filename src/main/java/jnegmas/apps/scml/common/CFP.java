package jnegmas.apps.scml.common;

import jnegmas.BaseCopyable;
import jnegmas.outcomes.Issue;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;

public class CFP extends BaseCopyable {
    public boolean is_buy;
    public String publisher;
    public int product;
    public int min_time;
    public int max_time;
    public int min_quantity;
    public int max_quantity;
    public double min_unit_price;
    public double max_unit_price;
    public double min_penalty;
    public double max_penalty;
    public boolean penalty_negotiable = false;
    public int min_signing_delay;
    public int max_signing_delay;
    public boolean singing_delay_negotiable = false;
    public double money_resolution;
    public boolean has_money_resolution;
    public String id;

    public CFP(HashMap<String, Object> map){
        fromMap(map);
    }

    @Override
    public void fromMap(HashMap<String, Object> dict) {
        is_buy = (boolean) dict.get("is_buy");
        publisher = (String) dict.get("publisher");
        product = (int) dict.get("product");
        min_time = (int) dict.get("min_time");
        max_time = (int) dict.get("max_time");
        min_quantity = (int) dict.get("min_quantity");
        max_quantity = (int) dict.get("max_quantity");
        min_unit_price = (double) dict.get("min_unit_price");
        max_unit_price = (double) dict.get("max_unit_price");
        min_penalty = (double) dict.get("min_penalty");
        max_penalty = (double) dict.get("max_penalty");
        penalty_negotiable = (boolean) dict.get("has_penalty");
        min_signing_delay = (int) dict.get("min_signing_delay");
        max_signing_delay = (int) dict.get("max_signing_delay");
        singing_delay_negotiable = (boolean) dict.get("has_signing_delay");
        money_resolution = (double) dict.get("money_resolution");
        has_money_resolution = (boolean) dict.get("has_money_resolution");
        id = (String) dict.get("id");
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("is_buy", is_buy);
        map.put("publisher", publisher);
        map.put("product", product);
        map.put("min_time", min_time);
        map.put("max_time", max_time);
        map.put("min_quantity", min_quantity);
        map.put("max_quantity", max_quantity);
        map.put("min_unit_price", min_unit_price);
        map.put("max_unit_price", max_unit_price);
        map.put("min_penalty", min_penalty);
        map.put("max_penalty", max_penalty);
        map.put("has_penalty", penalty_negotiable);
        map.put("min_signing_delay", min_signing_delay);
        map.put("max_signing_delay", max_signing_delay);
        map.put("has_signing_delay", singing_delay_negotiable);
        map.put("money_resolution", money_resolution);
        map.put("has_money_resolution", has_money_resolution);
        map.put("id", id);
        return map;
    }

    public boolean satisfies(HashMap<String, Object> query) {
        throw new NotImplementedException();
    }

    public ArrayList<Issue> getIssues() {
        throw new NotImplementedException();
    }

    public ArrayList<HashMap<String, Object>> getOutcomes() {
        throw new NotImplementedException();
    }
}
