package jnegmas.apps.scml.factory_managers;

import jnegmas.PyCaller;
import jnegmas.apps.scml.common.*;
import jnegmas.apps.scml.awi.PythonSCMLAWI;
import jnegmas.apps.scml.awi.SCMLAWI;
import jnegmas.apps.scml.common.Process;
import jnegmas.apps.scml.simulators.FactorySimulator;
import jnegmas.apps.scml.simulators.PythonFactorySimulator;
import jnegmas.sao.SAONegotiator;
import jnegmas.situated.Contract;
import jnegmas.situated.NegotiationRequestInfo;
import jnegmas.utilities.UtilityFunction;

import java.util.List;
import java.util.Map;

public abstract class AbstractFactoryManager extends PyCaller<FactoryManager> implements FactoryManager {
    public PythonSCMLAWI awi;
    public PythonFactorySimulator simulator;
    public int transportationDelay;
    public int currentStep;
    public int maxStorage;
    public String simulatorType;
    public boolean immediateNegotiations;
    public int negotiationSpeedMultiple;
    public Map<Integer, ManufacturingProfileCompiled> lineProfiles;
    public Map<Integer, ManufacturingProfileCompiled> processProfiles;
    public Map<Integer, List<ProductManufacturingInfo>> producing;
    public Map<Integer, List<ProductManufacturingInfo>> consuming;
    public List<ManufacturingProfileCompiled> compiledProfiles;
    public List<Product> products;
    public List<Process> processes;
    public List<Integer> interestingProducts;
    public List<Contract> contracts;
    public String name;
    public String id;
    // Map<String, NegotiationRequestInfo> requestedNegotiations = new HashMap<>();


    public AbstractFactoryManager() {
        super();
    }

    public AbstractFactoryManager(FactoryManager pythonObject, String name) {
        super(pythonObject);
        this.id = pythonObject.getID();
        this.name = name;
    }

    public AbstractFactoryManager(FactoryManager pythonObject) {
        super(pythonObject);
        this.id = pythonObject.getID();
        this.name = pythonObject.getName();
    }

    public void fromMap(Map<String, Object> dict) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        FactoryManager.super.fromMap(dict);
        awi = new PythonSCMLAWI((SCMLAWI) dict.get("awi"));
        simulator = new PythonFactorySimulator((FactorySimulator) dict.get("simulator"));
    }

    /* Getters and Setters */

    public Map<Integer, ManufacturingProfileCompiled> getLineProfiles() {
        return lineProfiles;
    }

    public Map<Integer, ManufacturingProfileCompiled> getProcessProfiles() {
        return processProfiles;
    }

    public Map<Integer, List<ProductManufacturingInfo>> getProducing() {
        return producing;
    }

    public Map<Integer, List<ProductManufacturingInfo>> getConsuming() {
        return consuming;
    }

    public List<ManufacturingProfileCompiled> getCompiledProfiles() {
        return compiledProfiles;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    @Override
    public List<NegotiationRequestInfo> getRequestedNegotiations() {
        return shadow.getRequestedNegotiations();
    }

    @Override
    public List<NegotiationRequestInfo> getRunningNegotiations() {
        return shadow.getRunningNegotiations();
    }

    @Override
    public PythonSCMLAWI getAWI() {

        return awi;
    }

    @Override
    public void setAWI(SCMLAWI value) {
        this.awi = new PythonSCMLAWI(value);
    }

    @Override
    public FactorySimulator getSimulator() {
        return simulator;
    }

    @Override
    public void setSimulator(FactorySimulator value) {
        this.simulator = new PythonFactorySimulator(value);
    }

    @Override
    public boolean requestNegotiation(CFP cfp, SAONegotiator negotiator, UtilityFunction ufun) {
        return shadow.requestNegotiation(cfp, negotiator, ufun);
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public void setID(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;}

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

