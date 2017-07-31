package com.example.aryan.shoppingcart;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class ProductDetailsActivity extends Activity {
    TextView textView;
    int numberOfShirts=1;
    String number;


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton_s:
                if (checked)
                    Toast.makeText(this, "small", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton_m:
                if (checked)
                    Toast.makeText(this, "medium", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton_l:
                if (checked)
                    Toast.makeText(this, "l", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton_xl:
                if (checked)
                    Toast.makeText(this, "XL", Toast.LENGTH_SHORT).show();
                break;

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        List<Product> catalog = ShoppingCartHelper.getCatalog(getResources());
        final List<Product> cart = ShoppingCartHelper.getCart();

        int productIndex = getIntent().getExtras().getInt(ShoppingCartHelper.PRODUCT_INDEX);
        final Product selectedProduct = catalog.get(productIndex);

        // Set the proper image and text
        ImageView productImageView = (ImageView) findViewById(R.id.ImageViewProduct);
        productImageView.setImageDrawable(selectedProduct.productImage);
        TextView productTitleTextView = (TextView) findViewById(R.id.TextViewProductTitle);
        productTitleTextView.setText(selectedProduct.title);




        Button addNoOfTshirt =(Button)findViewById(R.id.button_add);
        addNoOfTshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView=(TextView)findViewById(R.id.number_of_tshirt);
                numberOfShirts++;

                    textView.setText(Integer.toString(numberOfShirts));
            }
        });

        Button minusNoOfTshirt =(Button)findViewById(R.id.button_minus);
        minusNoOfTshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView=(TextView)findViewById(R.id.number_of_tshirt);
                if(numberOfShirts>=1){
                    numberOfShirts--;
                    textView.setText(Integer.toString(numberOfShirts));
                }
                else{
                    numberOfShirts=1;
                }

            }
        });


        Button addToCartButton = (Button) findViewById(R.id.ButtonAddToCart);
        addToCartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                cart.add(selectedProduct);
                finish();
            }
        });

        // Disable the add to cart button if the item is already in the cart
        if(cart.contains(selectedProduct)) {
            addToCartButton.setEnabled(false);
            addToCartButton.setText("Item in Cart");
        }
    }

}


