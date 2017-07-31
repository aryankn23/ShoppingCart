package com.example.aryan.shoppingcart;

import android.content.res.Resources;

import java.util.List;
import java.util.Vector;

/**
 * Created by aryan on 31/7/17.
 */

public class ShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    private static List<Product> cart;

    public static List<Product> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<Product>();
            catalog.add(new Product("Polo", res
                    .getDrawable(R.drawable.polo),
                    "Dead or Alive by Tom Clancy with Grant Blackwood", 29.99));
            catalog.add(new Product("Design 1", res
                    .getDrawable(R.drawable.design1),
                    "Switch by Chip Heath and Dan Heath", 24.99));
            catalog.add(new Product("Design 2", res
                    .getDrawable(R.drawable.design2),
                    "Watchmen by Alan Moore and Dave Gibbons", 14.99));
        }

        return catalog;
    }

    public static List<Product> getCart() {
        if(cart == null) {
            cart = new Vector<Product>();
        }

        return cart;
    }

}
