package jnegmas.apps.scml.factory_managers;

import jnegmas.apps.scml.common.*;

import java.util.ArrayList;

class ProductInfo {
    public double buying_price = -1.0;
    public double selling_price = -1.0;
}

public class MiddleMan extends DoNothingFactoryManager {

    ArrayList<ProductInfo> infos;
    ArrayList<Product> products;

    @Override
    public void init() {
        ArrayList<Product> products = this.awi.getProducts();
        infos = new ArrayList<>(products.size());
        for (int i=0; i < products.size(); i++)
            infos.add(new ProductInfo());
        System.out.format("%d products", products.size());
    }

}
