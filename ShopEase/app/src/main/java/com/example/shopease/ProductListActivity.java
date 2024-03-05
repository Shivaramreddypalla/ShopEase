package com.example.shopease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProductListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        Button myCartButton = findViewById(R.id.myCartBTN);

        // Set click listener for the MY Cart button
        myCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click, navigate to the MyCartActivity
                Intent myCartIntent = new Intent(ProductListActivity.this, ShoppingCartActivity.class);
                startActivity(myCartIntent);
            }
        });
    }

}