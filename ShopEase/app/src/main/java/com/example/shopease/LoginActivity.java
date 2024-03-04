package com.example.shopease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText emailEditText = findViewById(R.id.editTextLoginEmail);
        EditText passwordEditText = findViewById(R.id.editTextLoginPassword);
        Button loginButton = findViewById(R.id.buttonLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Validate credentials (implement your authentication logic here)
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Check credentials (you need to implement this)
                if (isValidCredentials(email, password)) {
                    // Successful login, navigate to the next activity
                    Intent intent = new Intent(LoginActivity.this, ProductListActivity.class);
                    startActivity(intent);
                    finish(); // Optional: Close the login activity to prevent going back
                } else {
                    // Show an error message or handle unsuccessful login
                }
            }
        });

        TextView createAccountLink = findViewById(R.id.textViewNewHereLink);
        createAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to create account activity
                Intent createAccountIntent = new Intent(LoginActivity.this, CreateAccountActivity.class);
                startActivity(createAccountIntent);
            }
        });

    }

    // Add your authentication logic here
    private boolean isValidCredentials(String email, String password) {

        return true; // For demonstration purposes, always return true
    }
}

}