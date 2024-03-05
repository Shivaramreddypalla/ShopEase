package com.example.shopease;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        EditText usernameEditText = findViewById(R.id.editTextUsername);
        EditText emailEditText = findViewById(R.id.editTextEmail);
        EditText phoneNumberEditText = findViewById(R.id.editTextPhoneNumber);
        EditText passwordEditText = findViewById(R.id.editTextPassword);
        Button createAccountButton = findViewById(R.id.buttonCreateAccount);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// Validate and process user registration
                String username = usernameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phoneNumber = phoneNumberEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (isValidRegistration(username, email, phoneNumber, password)) {
                    Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                }
            }
        });
        TextView loginLink = findViewById(R.id.textViewLoginLink);
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// Redirect to login activity
                Intent loginIntent = new Intent(CreateAccountActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }

    private boolean isValidRegistration(String username, String email, String phoneNumber, String password) {
        return true;
    }
}