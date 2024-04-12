package com.example.shopease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShoppingCartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        // Initialize RecyclerView
recyclerView = findViewById(R.id.recyclerView);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
cartItemList = new ArrayList<>();
// Initialize adapter with cartItemList (Changed to ShoppingAdapter)
adapter = new ShoppingAdapter(cartItemList, this);
recyclerView.setAdapter(adapter);
// Get the product details from the intent if passed from ProductListActivity
Bundle extras = getIntent().getExtras();
if (extras != null && extras.containsKey("productName") && extras.containsKey("productPrice")) {
String productName = extras.getString("productName");
double productPrice = extras.getDouble("productPrice");
// Add the product to the cart
addToCart(productName, productPrice);
}

        Button payNowButton = findViewById(R.id.checkoutBTN);

        // Set click listener for the Pay Now button
        payNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click, navigate to the CheckpageActivity
                Intent checkpageIntent = new Intent(ShoppingCartActivity.this, CheckoutActivity.class);
                startActivity(checkpageIntent);
            }
        });
    }
}