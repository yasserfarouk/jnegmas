package jnegmas.apps.scml.factory_managers;

import jnegmas.PyReadable;
import jnegmas.apps.scml.awi.PySCMLAWI;
import jnegmas.apps.scml.common.*;
import jnegmas.apps.scml.common.Process;
import jnegmas.apps.scml.simulators.PyFactorySimulator;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractFactoryManager extends SCMLAgent implements FactoryManager, PyReadable {
    PySCMLAWI awi;
    PyFactorySimulator simulator;
    int transportation_delay;
    int current_step;
    int max_storage;
    String simulator_type;
    boolean immediate_negotiations;
    int negotiation_speed_multiple;
    HashMap<Integer, ManufacturingProfileCompiled> line_profiles;
    HashMap<Integer, ManufacturingProfileCompiled> process_profiles;
    HashMap<Integer, ArrayList<ProductManufacturingInfo>> producing;
    HashMap<Integer, ArrayList<ProductManufacturingInfo>> consuming;
    ArrayList<ManufacturingProfileCompiled> compiled_profiles;
    ArrayList<Product> products;
    ArrayList<Process> processes;
    ArrayList<Integer> interesting_products;
    String name;

    public boolean test(HashMap<String, Object> map) {
        CFP cfp = new CFP(map);
        System.out.format("product %d", cfp.product);
        return true;
    }

    public void setAWI(PySCMLAWI value) {

        this.awi = value;
    }

    public PySCMLAWI getAWI() {
        return awi;
    }

    public void fromMap(HashMap<String, Object> dict) {
        awi = (PySCMLAWI) dict.get("awi");
        simulator = (PyFactorySimulator) dict.get("simulator");
        transportation_delay = (int) dict.get("transportation_delay");
        current_step = (int) dict.get("current_step");
        max_storage = (int) dict.get("max_storage");
        simulator_type = (String) dict.get("simulator_type");
        immediate_negotiations = (boolean) dict.get("immediate_negotiations");
        negotiation_speed_multiple = (int) dict.get("negotiation_speed_multiple");
        line_profiles = (HashMap<Integer, ManufacturingProfileCompiled>) dict.get("line_profiles");
        process_profiles = (HashMap<Integer, ManufacturingProfileCompiled>) dict.get("process_profiles");
        producing = (HashMap<Integer, ArrayList<ProductManufacturingInfo>>) dict.get("producing");
        consuming = (HashMap<Integer, ArrayList<ProductManufacturingInfo>>) dict.get("consuming");
        compiled_profiles = (ArrayList<ManufacturingProfileCompiled>) dict.get("compiled_profiles");
        products = (ArrayList<Product>) dict.get("products");
        processes = (ArrayList<Process>) dict.get("processes");
        interesting_products = (ArrayList<Integer>) dict.get("interesting_products");
    }

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("awi", awi);
        map.put("simulator", simulator);
        map.put("transportation_delay", transportation_delay);
        map.put("current_step", current_step);
        map.put("max_storage", max_storage);
        map.put("simulator_type", simulator_type);
        map.put("immediate_negotiations", immediate_negotiations);
        map.put("negotiation_speed_multiple", negotiation_speed_multiple);
        map.put("line_profiles", line_profiles);
        map.put("process_profiles", process_profiles);
        map.put("producing", producing);
        map.put("consuming", consuming);
        map.put("compiled_profiles", compiled_profiles);
        map.put("products", products);
        map.put("processes", processes);
        map.put("interesting_products", interesting_products);
        return map;
    }

    public void on_construction(String name, PyFactorySimulator simulator) {
        this.name = name;
        this.simulator = simulator;
    }

}

