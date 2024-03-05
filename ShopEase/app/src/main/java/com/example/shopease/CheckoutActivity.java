package com.example.shopease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Button payNowButton = findViewById(R.id.buttonPay);

        // Set click listener for the Pay Now button
        payNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click, navigate to the CheckpageActivity
                Intent checkpageIntent = new Intent(CheckoutActivity.this, SuccessActivity.class);
                startActivity(checkpageIntent);
            }
        });
    }
}