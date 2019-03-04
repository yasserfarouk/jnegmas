package jnegmas.apps.scml.factory_managers;

import jnegmas.apps.scml.awi.PySCMLAWI;
import jnegmas.apps.scml.common.CFP;

import java.util.HashMap;

public abstract class AbstractFactoryManager implements FactoryManager {

    PySCMLAWI awi = null;

    public boolean test(HashMap<String, Object> map){
        CFP cfp = new CFP(map);
        System.out.format("product %d", cfp.product);
        return true;
    }
}

