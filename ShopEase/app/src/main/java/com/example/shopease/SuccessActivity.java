package com.example.shopease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        Button payNowButton = findViewById(R.id.buttonContinueShopping);

        // Set click listener for the Pay Now button
        payNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click, navigate to the CheckpageActivity
                Intent checkpageIntent = new Intent(SuccessActivity.this, ProductListActivity.class);
                startActivity(checkpageIntent);
            }
   });
}
}