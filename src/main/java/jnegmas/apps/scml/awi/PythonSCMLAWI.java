package jnegmas.apps.scml.awi;

import jnegmas.PyCallable;
import jnegmas.PyCaller;
import jnegmas.PyCopiable;
import jnegmas.apps.scml.common.CFP;
import jnegmas.apps.scml.common.Product;
import jnegmas.apps.scml.common.Process;
import jnegmas.situated.AgentWorldInterface;
import jnegmas.situated.Contract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class PythonSCMLAWI extends AgentWorldInterface implements PyCaller, SCMLAWI {

    PySCMLAWI shadow;

    public PythonSCMLAWI(PySCMLAWI shadow){
        this.setPythonShadow(shadow);
    }

    public void registerCFP(CFP cfp) {
        this.shadow.register_cfp(cfp.toMap());
    }

    public boolean removeCFP(CFP cfp) {
        return this.shadow.remove_cfp(cfp.toMap());
    }
    public void registerInterest(ArrayList<Integer> products){
        this.shadow.register_interest(products);
    }
    public void unregisterInterest(ArrayList<Integer> products){
        this.shadow.unregister_interest(products);
    }
    public Optional<Double> evaluateInsurance(Contract contract, int t) {
        return this.shadow.evaluate_insurance(contract.toMap(), t);
    }

    public Optional<Double> evaluateInsurance(Contract contract) {
        return this.shadow.evaluate_insurance(contract.toMap());
    }

    public boolean buyInsurance(Contract contract) {
        return this.shadow.buy_insurance(contract.toMap());
    }

    public ArrayList<Product> getProducts() {
        ArrayList<HashMap<String, Object>> maps = this.shadow.get_products();
        ArrayList<Product> products = new ArrayList<>(maps.size());
        for (HashMap<String, Object> map : maps) {
            products.add((Product) PyCopiable.fromMap(new Product(), map));
        }
        return products;
    }

    public ArrayList<Process> getProcesses() {
        ArrayList<HashMap<String, Object>> maps = this.shadow.get_processes();
        ArrayList<Process> processs = new ArrayList<>(maps.size());
        for (HashMap<String, Object> map : maps) {
            processs.add((Process) PyCopiable.fromMap(new Process(), map));
        }
        return processs;
    }

    public void setPythonShadow(PyCallable python_object) {
        this.shadow = (PySCMLAWI) python_object;
    }


    public PyCallable getPythonShadow() {
        return this.shadow;
    }
}
