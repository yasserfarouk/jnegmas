package jnegmas.apps.scml.factory_managers;

import jnegmas.apps.scml.common.CFP;
import jnegmas.apps.scml.common.Product;
import jnegmas.common.MechanismState;
import jnegmas.common.PythonAgentMechanismInterface;
import jnegmas.sao.AspirationNegotiator;
import jnegmas.sao.SAONegotiator;
import jnegmas.situated.Breach;
import jnegmas.situated.Contract;
import jnegmas.utilities.UtilityFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ProductInfo {
    public double buyingPrice = -1.0;
    public double sellingPrice = -1.0;
}

/**
 * The utility function used by DummyMiddleMan negotiators
 */
class DummyMiddleManUFun implements UtilityFunction{
    DummyMiddleMan parent;
    CFP cfp;

    public DummyMiddleManUFun(DummyMiddleMan parent, CFP cfp){
        this.parent = parent;
        this.cfp = cfp;
    }

    @Override
    public Double call(Map<String, Object> outcome) {
        int product = this.cfp.product;
        if (cfp.isBuy){
            if (parent.infos[product].buyingPrice>= 0)
                return ((Number)outcome.get("unitPrice")).doubleValue() - parent.infos[product].buyingPrice;
            return ((Number)outcome.get("unitPrice")).doubleValue();
        }
        if (parent.infos[product].sellingPrice>= 0)
            return parent.infos[product].sellingPrice - ((Number)outcome.get("unitPrice")).doubleValue();
        return 100.0 - ((Number)outcome.get("unitPrice")).doubleValue();
    }
}

/**
 * A simple middle-man agent.
 *
 * This factory manager tries to secure sell contracts for any products then tries to buy whatever
 * quantities it needs to honor these contracts at a lower price. It does not do any production.
 *
 * It is an example of a factory manager that inherits from DoNothingFactoryManager
 */
public class DummyMiddleMan extends DoNothingFactoryManager {

    ProductInfo[] infos;
    Product[] products;

    @Override
    public void init() {
        List<Product> products;
        try {
            products = this.awi.getProducts();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return;
        }
        this.products = new Product[products.size()];
        infos = new ProductInfo[products.size()];
        List<Integer> productIndices = new ArrayList<>();
        for (int i=0; i < products.size(); i++) {
            this.products[i] = products.get(i);
            infos[i] = new ProductInfo();
            productIndices.add(i);
        }
        awi.registerInterest(productIndices);
    }

    @Override
    public void onNegRequestRejected(String req_id, List<String> rejectors) {
        //System.out.format("req %s was rejected by %%", rejectors);
    }

    @Override
    public void onNegRequestAccepted(String req_id, PythonAgentMechanismInterface mechanism) {
        //System.out.format("req %s was accepted", req_id);
    }

    @Override
    public boolean confirmPartialExecution(Contract contract, List<Breach> breaches) {
        return true;
    }

    @Override
    public boolean confirmContractExecution(Contract contract) {
        return true;
    }

    @Override
    public void onNegotiationSuccess(Contract contract, PythonAgentMechanismInterface mechanism) {
        //System.out.format("Negotiation success with %%", contract.partners);
    }

    @Override
    public void onNegotiationFailure(List<String> partners, Map<String, Object> annotation
            , PythonAgentMechanismInterface mechanism, MechanismState state) {
        //System.out.format("Negotiation failure with %%", partners);
    }

    @Override
    public void onContractSigned(Contract contract) {
        //System.out.format("Contract secured: %%: ", contract);
        if(contract.annotation.get("seller") == this.id){
            // System.out.format("I am a seller\n");
            CFP contractCFP = ((CFP)contract.annotation.get("cfp"));
            CFP cfp = new CFP(true, id, contractCFP.product
                    , awi.getCurrentStep(), (int) (contract.agreement.get("time")), 1
                    , (int) (contract.agreement.get("quantity")), 0.0
                    , (double) (contract.agreement.get("unit_price")));
            awi.registerCFP(cfp);
        }//else{
            //System.out.format("I am a buyer\n");
        //}
    }

    @Override
    public SAONegotiator respondToNegotiationRequest(CFP cfp, String partner){
        DummyMiddleManUFun ufun = new DummyMiddleManUFun(this, cfp);
        try {
            AspirationNegotiator negotiator = new AspirationNegotiator(0.95, "conceder", false, true, false);
            negotiator.setUtilityFunction(ufun);
            return negotiator;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        //System.out.format("I will reject the negotiation!!");
        return null;
    }

    @Override
    public void onContractCancelled(Contract contract, List<String> rejectors) {
        //System.out.format("Contract cancelled: %%: ", contract);
    }

    @Override
    public String signContract(Contract contract) {

        return id;
    }

    @Override
    public void onNewCFP(CFP cfp) {
        super.onNewCFP(cfp);
        DummyMiddleManUFun ufun = new DummyMiddleManUFun(this, cfp);
        //RandomNegotiator negotiator = null;
        //negotiator = new RandomNegotiator();
        AspirationNegotiator negotiator = null;
        try {
            negotiator = new AspirationNegotiator(0.95, "conceder", false, true, false);
            negotiator.setUtilityFunction(ufun);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        if (negotiator == null)
            return;
        requestNegotiation(cfp, negotiator, ufun);
    }
}
