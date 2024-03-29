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

        recyclerView = findViewById(R.id.recyclerViewProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Product> productList = generateSampleData();
        adapter = new ProductAdapter(productList, this);
        recyclerView.setAdapter(adapter);

        // Inside the onCreate method of ProductListActivity
        adapter.setOnAddItemClickListener(new ProductAdapter.OnAddItemClickListener() {
            @Override
            public void onAddItemClick(int position) {
                // Get the selected product
                Product selectedProduct = productList.get(position);

                // Create an intent to pass the selected product details to ShoppingCartActivity
                Intent intent = new Intent(ProductListActivity.this, ShoppingCartActivity.class);
                intent.putExtra("productName", selectedProduct.getName());
                intent.putExtra("productPrice", selectedProduct.getPrice());

                // Start ShoppingCartActivity
                startActivity(intent);
            }
        });

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