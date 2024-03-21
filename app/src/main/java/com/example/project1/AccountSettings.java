package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AccountSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        // Display Username and Password
        TextView viewUser = findViewById(R.id.viewUsername);
        TextView viewPass = findViewById(R.id.viewPassword);
        viewUser.setText(SignUp.getUsername());
        viewPass.setText(SignUp.getPassword());

        // Change Password
        EditText changePass = findViewById(R.id.changePassword);

        Button homeButton = findViewById(R.id.returnToHome);
        homeButton.setOnClickListener(v -> {
            // Retrieve user input from EditTextView, if any
            String newPass = changePass.getText().toString();
            // Verify "New Password" field is behaving as expected
            Log.d("New Password", "====="+newPass);
            if (newPass.equals("")) {
                // Return to home page action will only trigger if "New Password" field is empty
                Intent messageIntent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(messageIntent);
            } else {
                // If the "New Password" field is not empty, do not switch screens
                Toast.makeText(AccountSettings.this,
                        "Clear \"Change Password\" field or save desired change",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    // Called when "save" button is pressed
    public void saveChanges(View view) {
        EditText changePass = findViewById(R.id.changePassword);
        String checkNew = changePass.getText().toString();
        if (SignUp.validPassword(checkNew)) {
            // Modify password variable in SignUp.class to store new password
            SignUp.setPassword(checkNew);
            Log.d("Password Change", "====="+checkNew);
            // Refresh page after changing password to display new password
            Intent refresh = new Intent(getApplicationContext(), AccountSettings.class);
            startActivity(refresh);
        } else {
            Toast.makeText(AccountSettings.this,
                    "Invalid change requested: New password may not meet all 3 requirements",
                    Toast.LENGTH_LONG).show();
        }
    }
}