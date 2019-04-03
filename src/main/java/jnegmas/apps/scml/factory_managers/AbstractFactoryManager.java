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

    public void fromMap(Map<String, Object> dict) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        FactoryManager.super.fromMap(dict);
        awi = new PythonSCMLAWI((SCMLAWI) dict.get("awi"));
        simulator = new PythonFactorySimulator((FactorySimulator) dict.get("simulator"));

        /*id = (String) dict.get("id");
        transportationDelay = (int) dict.get("transportationDelay");
        currentStep = (int) dict.get("currentStep");
        maxStorage = (int) dict.get("maxStorage");
        simulatorType = (String) dict.get("simulatorType");
        immediateNegotiations = (boolean) dict.get("immediateNegotiations");
        negotiationSpeedMultiple = (int) dict.get("negotiationSpeedMultiple");
        lineProfiles = (Map<Integer, ManufacturingProfileCompiled>) dict.get("lineProfiles");
        processProfiles = (Map<Integer, ManufacturingProfileCompiled>) dict.get("processProfiles");
        producing = (Map<Integer, List<ProductManufacturingInfo>>) dict.get("producing");
        consuming = (Map<Integer, List<ProductManufacturingInfo>>) dict.get("consuming");
        compiledProfiles = (List<ManufacturingProfileCompiled>) dict.get("compiledProfiles");
        products = (List<Product>) dict.get("products");
        processes = (List<Process>) dict.get("processes");
        contracts = (List<Contract>) dict.get("contracts");
        interestingProducts = (List<Integer>) dict.get("interestingProducts");
        name = (String) dict.get("name");
        */
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

    public List<Integer> getInterestingProducts() {
        return interestingProducts;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public String getName() {
        return name;
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

    /*
    String addNegotiationRequestinfo(List<Issue> issues, List<String> partners, Map<String, Object> annotation
    , Negotiator negotiator, Map<String, Object> extra){
        String reqId = Utils.randomString(18);
        requestedNegotiations.put(reqId, new NegotiationRequestInfo(issues, partners, annotation, negotiator, extra
                , reqId));
        return reqId;
    }
    */
    @Override
    public boolean requestNegotiation(CFP cfp, SAONegotiator negotiator, UtilityFunction ufun) {
        return shadow.requestNegotiation(cfp, negotiator, ufun);
        /*
        if(negotiator != null && ufun != null){
            negotiator.setUtilityFunction(ufun);
        }
        List<String> partners = new ArrayList<String>();
        partners.add(this.getID());
        partners.add(cfp.publisher);

        String reqId = addNegotiationRequestinfo(cfp.getIssues(), partners
                , null, negotiator, null);
        return this.awi.requestNegotiation(cfp, reqId);
        */
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }
}

