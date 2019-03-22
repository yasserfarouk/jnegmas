package jnegmas.apps.scml.factory_managers;

import jnegmas.PyCopyable;
import jnegmas.apps.scml.awi.PySCMLAWI;
import jnegmas.apps.scml.awi.PythonSCMLAWI;
import jnegmas.apps.scml.common.*;
import jnegmas.apps.scml.common.Process;
import jnegmas.apps.scml.simulators.PythonFactorySimulator;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractFactoryManager extends SCMLAgent implements PyFactoryManager, PyCopyable {
    PythonSCMLAWI awi;
    PythonFactorySimulator simulator;
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

    public void setAWI(PySCMLAWI value) {
        this.awi = new PythonSCMLAWI(value);
    }

    public PySCMLAWI getAWI() {

        return (PySCMLAWI) awi.getPythonShadow();
    }

//    public void fromMap(HashMap<String, Object> dict) {
//        awi = new PythonSCMLAWI((PySCMLAWI) dict.get("awi");
//        simulator = new PythonFactorySimulator((PyFactorySimulator) dict.get("simulator"));
//        transportation_delay = (int) dict.get("transportation_delay");
//        current_step = (int) dict.get("current_step");
//        max_storage = (int) dict.get("max_storage");
//        simulator_type = (String) dict.get("simulator_type");
//        immediate_negotiations = (boolean) dict.get("immediate_negotiations");
//        negotiation_speed_multiple = (int) dict.get("negotiation_speed_multiple");
//        line_profiles = (HashMap<Integer, ManufacturingProfileCompiled>) dict.get("line_profiles");
//        process_profiles = (HashMap<Integer, ManufacturingProfileCompiled>) dict.get("process_profiles");
//        producing = (HashMap<Integer, ArrayList<ProductManufacturingInfo>>) dict.get("producing");
//        consuming = (HashMap<Integer, ArrayList<ProductManufacturingInfo>>) dict.get("consuming");
//        compiled_profiles = (ArrayList<ManufacturingProfileCompiled>) dict.get("compiled_profiles");
//        products = (ArrayList<Product>) dict.get("products");
//        processes = (ArrayList<Process>) dict.get("processes");
//        interesting_products = (ArrayList<Integer>) dict.get("interesting_products");
//        name = (String) dict.get("name");
//    }
//
//    public HashMap<String, Object> toMap() {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("awi", awi.getPythonShadow());
//        map.put("simulator", simulator.getPythonShadow());
//        map.put("transportation_delay", transportation_delay);
//        map.put("current_step", current_step);
//        map.put("max_storage", max_storage);
//        map.put("simulator_type", simulator_type);
//        map.put("immediate_negotiations", immediate_negotiations);
//        map.put("negotiation_speed_multiple", negotiation_speed_multiple);
//        map.put("line_profiles", line_profiles);
//        map.put("process_profiles", process_profiles);
//        map.put("producing", producing);
//        map.put("consuming", consuming);
//        map.put("compiled_profiles", compiled_profiles);
//        map.put("products", products);
//        map.put("processes", processes);
//        map.put("interesting_products", interesting_products);
//        map.put("name", name);
//        return map;
//    }

}

