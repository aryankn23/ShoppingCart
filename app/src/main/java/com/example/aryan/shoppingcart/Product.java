package com.example.aryan.shoppingcart;

import android.graphics.drawable.Drawable;

/**
 * Created by aryan on 31/7/17.
 */

public class Product {

    public String title;
    public Drawable productImage;

    public String productSize;
    public String productNumber;
    public double price;
    public boolean selected;

    public Product(String title, Drawable productImage, String description,
                   double price) {
        this.title = title;
        this.productImage = productImage;

        this.price = price;
    }

}