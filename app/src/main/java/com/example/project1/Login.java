package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText inputUser = findViewById(R.id.editUsernameLogin);
        EditText inputPass = findViewById(R.id.editPasswordLogin);

        Button loginButton = findViewById(R.id.submitLogin);
        loginButton.setOnClickListener(v -> {
            // After "login" button is pressed, retrieve current inputs in fields
            String checkUsername = inputUser.getText().toString();
            String checkPassword = inputPass.getText().toString();

            if ((checkUsername.isEmpty()) || (checkPassword.isEmpty())) {
                Toast.makeText(Login.this,
                        "Please fill both username & password fields",
                        Toast.LENGTH_SHORT).show();
                // Debug/verify result is as expected
                Log.d("Username", "null? : "+checkUsername);
                Log.d("Password", "null? : "+checkPassword);
            } else {
                if ((checkUsername.equals(SignUp.getUsername())) &&
                        (checkPassword.equals(SignUp.getPassword()))) {
                    // Go to Home Page Activity if username and password are correct
                    Log.d("Username", "correct");
                    Log.d("Password", "correct");
                    Intent messageIntent = new Intent(getApplicationContext(), HomePage.class);
                    startActivity(messageIntent);
                } else if (!checkUsername.equals(SignUp.getUsername())) {
                    // Show error message if username does not match stored username
                    Toast.makeText(Login.this,
                            "Incorrect username", Toast.LENGTH_SHORT).show();
                    Log.d("Username", "eq? : "+checkUsername);
                } else {
                    // Show error message if password does not match stored password
                    Toast.makeText(Login.this,
                            "Incorrect password", Toast.LENGTH_SHORT).show();
                    Log.d("Password", "eq? : "+checkPassword);
                }
            }
        });
    }
}