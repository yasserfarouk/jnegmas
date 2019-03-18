package jnegmas.apps.scml.factory_managers;

import jnegmas.apps.scml.common.*;
import jnegmas.common.MechanismInfo;
import jnegmas.common.MechanismState;
import jnegmas.sao.PySAONegotiator;
import jnegmas.situated.Contract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

class ProductInfo {
    public double buying_price = -1.0;
    public double selling_price = -1.0;
}

public class MiddleMan extends AbstractFactoryManager {

    ArrayList<ProductInfo> infos;
    ArrayList<Product> products;

    @Override
    public void init() {
        products = this.awi._allProducts();
        infos = new ArrayList<>(products.size());
        for (int i=0; i < products.size(); i++)
            infos.set(i, new ProductInfo());
        System.out.format("%d products", products.size());
    }

    @Override
    public void step() {

    }

    @Override
    public void on_production_failure(ArrayList<ProductionFailure> failures) {

    }

    @Override
    public boolean confirm_loan(Loan loan) {
        return false;
    }

    @Override
    public boolean confirm_contract_execution(Contract contract) {
        return false;
    }

    @Override
    public PySAONegotiator on_negotiation_request(CFP cfp, String partner) {
        return null;
    }

    @Override
    public void on_negotiation_failure(ArrayList<String> partners, HashMap<String, Object> annotation
            , MechanismInfo mechanis, MechanismState state) {

    }

    @Override
    public void on_negotiation_success(Contract contract, MechanismInfo mechanism) {

    }

    @Override
    public void on_contract_signed(Contract contract) {

    }

    @Override
    public void on_contract_cancelled(Contract contract, ArrayList<String> rejectors) {

    }

    @Override
    public Optional<String> sign_contract(Contract contract) {
        return Optional.empty();
    }

    @Override
    public Optional<RenegotiationRequest> set_renegotiation_agenda(Contract contract, ArrayList<HashMap<String
            , Breach>> breaches) {
        return Optional.empty();
    }

    @Override
    public PySAONegotiator respond_to_renegotiation_request(Contract contract, ArrayList<HashMap<String, Breach>> breaches
            , RenegotiationRequest agenda) {
        return null;
    }

    @Override
    public boolean on_renegotiation_request(Contract contract, CFP cfp, String partner) {
        return false;
    }
}
