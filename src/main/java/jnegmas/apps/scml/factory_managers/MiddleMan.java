package jnegmas.apps.scml.factory_managers;

import jnegmas.apps.scml.common.Product;

import java.util.ArrayList;

class ProductInfo {
    public double buyingPrice = -1.0;
    public double sellingPrice = -1.0;
}

public class MiddleMan extends DoNothingFactoryManager {

    protected ArrayList<ProductInfo> infos;
    protected ArrayList<Product> products;

    @Override
    public void init() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            products = this.awi.getProducts();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        infos = new ArrayList<>(products.size());
        for (int i=0; i < products.size(); i++)
            infos.add(new ProductInfo());
        ArrayList<Integer> productIndices = new ArrayList<>();
        for (int i=0; i< products.size(); i++)
            productIndices.add(i);
        awi.registerInterest(productIndices);
        System.out.format("%d products", products.size());
    }

}
