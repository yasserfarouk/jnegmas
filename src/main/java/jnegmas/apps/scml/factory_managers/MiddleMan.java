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
        ArrayList<Product> products = new ArrayList<>();
        try {
            products = this.awi.shadow.get_products();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        infos = new ArrayList<>(products.size());
        for (int i=0; i < products.size(); i++)
            infos.add(new ProductInfo());
        ArrayList<Integer> product_indices = new ArrayList<>();
        for (int i=0; i< products.size(); i++)
            product_indices.add(i);
        awi.shadow.register_interest(product_indices);
        System.out.format("%d products", products.size());
    }

}
