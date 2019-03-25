package jnegmas.apps.scml.factory_managers;

import jnegmas.PyCaller;
import jnegmas.apps.scml.common.ManufacturingProfileCompiled;
import jnegmas.apps.scml.common.Process;
import jnegmas.apps.scml.awi.PythonSCMLAWI;
import jnegmas.apps.scml.awi.SCMLAWI;
import jnegmas.apps.scml.common.Product;
import jnegmas.apps.scml.common.ProductManufacturingInfo;
import jnegmas.apps.scml.simulators.FactorySimulator;
import jnegmas.apps.scml.simulators.PythonFactorySimulator;
import jnegmas.situated.Contract;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class BaseFactoryManager extends PyCaller<FactoryManager> implements FactoryManager {
    protected PythonSCMLAWI awi;
    protected PythonFactorySimulator simulator;
    protected int transportationDelay;
    protected int currentStep;
    protected int maxStorage;
    protected String simulatorType;
    protected boolean immediateNegotiations;
    protected int negotiationSpeedMultiple;
    protected HashMap<Integer, ManufacturingProfileCompiled> lineProfiles;
    protected HashMap<Integer, ManufacturingProfileCompiled> processProfiles;
    protected HashMap<Integer, ArrayList<ProductManufacturingInfo>> producing;
    protected HashMap<Integer, ArrayList<ProductManufacturingInfo>> consuming;
    protected ArrayList<ManufacturingProfileCompiled> compiledProfiles;
    protected ArrayList<Product> products;
    protected ArrayList<Process> processes;
    protected ArrayList<Integer> interestingProducts;
    protected ArrayList<Contract> contracts;
    protected String name;

    public BaseFactoryManager(){
        super();
    }

    @Override
    public void construct(HashMap<String, Object> dict) {
        awi = new PythonSCMLAWI((SCMLAWI) dict.get("awi"));
        simulator = new PythonFactorySimulator((FactorySimulator) dict.get("simulator"));
        transportationDelay = (int) dict.get("transportationDelay");
        currentStep = (int) dict.get("currentStep");
        maxStorage = (int) dict.get("maxStorage");
        simulatorType = (String) dict.get("simulatorType");
        immediateNegotiations = (boolean) dict.get("immediateNegotiations");
        negotiationSpeedMultiple = (int) dict.get("negotiationSpeedMultiple");
        lineProfiles = (HashMap<Integer, ManufacturingProfileCompiled>) dict.get("lineProfiles");
        processProfiles = (HashMap<Integer, ManufacturingProfileCompiled>) dict.get("processProfiles");
        producing = (HashMap<Integer, ArrayList<ProductManufacturingInfo>>) dict.get("producing");
        consuming = (HashMap<Integer, ArrayList<ProductManufacturingInfo>>) dict.get("consuming");
        compiledProfiles = (ArrayList<ManufacturingProfileCompiled>) dict.get("compiledProfiles");
        products = (ArrayList<Product>) dict.get("products");
        processes = (ArrayList<Process>) dict.get("processes");
        contracts = (ArrayList<Contract>) dict.get("contracts");
        interestingProducts = (ArrayList<Integer>) dict.get("interestingProducts");
        name = (String) dict.get("name");
    }

    /* Getters and Setters */

    public HashMap<Integer, ManufacturingProfileCompiled> getLineProfiles() {
        return lineProfiles;
    }

    public HashMap<Integer, ManufacturingProfileCompiled> getProcessProfiles() {
        return processProfiles;
    }

    public HashMap<Integer, ArrayList<ProductManufacturingInfo>> getProducing() {
        return producing;
    }

    public HashMap<Integer, ArrayList<ProductManufacturingInfo>> getConsuming() {
        return consuming;
    }

    public ArrayList<ManufacturingProfileCompiled> getCompiledProfiles() {
        return compiledProfiles;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Process> getProcesses() {
        return processes;
    }

    public ArrayList<Integer> getInterestingProducts() {
        return interestingProducts;
    }

    public ArrayList<Contract> getContracts() {
        return contracts;
    }

    public String getName() {
        return name;
    }

    public PythonSCMLAWI getAWI() {

        return awi;
    }

    public void setAWI(SCMLAWI value) {
        this.awi = new PythonSCMLAWI(value);
    }

    public PythonFactorySimulator getSimulator(){
        return simulator;
    }
    public void setSimulator(FactorySimulator value){
        this.simulator = new PythonFactorySimulator(value);
    }

}

