package com.example.project1;

import static java.lang.Character.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private static String name;
    private static String gender;
    private static String age;
    private static String address;
    private static String username;
    private static String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Find editText views by their ids to collect user input info
        EditText uiName = findViewById(R.id.editName);
        EditText uiGender = findViewById(R.id.editGender);
        EditText uiAge = findViewById(R.id.editAge);
        EditText uiAddress = findViewById(R.id.editAddress);
        EditText uiUser = findViewById(R.id.editUsername);
        EditText uiPass = findViewById(R.id.editPassword);

        Button submit = findViewById(R.id.submitSignUp);
        submit.setOnClickListener(v -> {
            // Store the user input of each field
            name = uiName.getText().toString();
            gender = uiGender.getText().toString();
            age = uiAge.getText().toString();
            address = uiAddress.getText().toString();

            String checkUsername = uiUser.getText().toString();
            if (validUsername(checkUsername)) {
                // Stores user input as username if valid
                username = uiUser.getText().toString();
                Log.d("Username", "====="+username);
            } else {
                Toast.makeText(SignUp.this,
                        "Username does not meet specifications",
                        Toast.LENGTH_SHORT).show();
            }

            String checkPassword = uiPass.getText().toString();
            if (validPassword(checkPassword)) {
                // Stores user input as password if is valid
                password = uiPass.getText().toString();
                Log.d("Password", "====="+password);
            } else {
                Toast.makeText(SignUp.this,
                        "Password does not meet specifications",
                        Toast.LENGTH_SHORT).show();
            }

            if ((name.isEmpty()) || (gender.isEmpty()) || (age.isEmpty()) ||
                    (address.isEmpty()) || (username == null) || (password == null)) {
                // Username and password are null if no user input is provided/accepted
                Toast.makeText(SignUp.this,
                        "Please fill all fields before proceeding",
                        Toast.LENGTH_LONG).show();
            } else {
                Intent messageIntent = new Intent(getApplicationContext(), Login.class);
                startActivity(messageIntent);
            }
        });
    }

    public static String getName() { return name; }
    public static String getGender() { return gender; }
    public static String getAge() { return age; }
    public static String getAddress() { return address; }

    // Must be public for global use by other Activities
    public static String getUsername() { return username; }
    public static String getPassword() { return password; }

    // Must be public to allow for other Activities to modify stored password (Account Settings)
    public static void setPassword(String newPass) { password = newPass; }

    // Used by validPassword()
    public static Boolean containsNumeric(String pass) {
        for (char c : pass.toCharArray()) {
            if (isDigit(c)) { return true; }
        }
        return false;
    }

    // Used by validUsername() and validPassword()
    public static Boolean containsOnlyAlphaNumeric(String input) {
        for (char c : input.toCharArray()) {
            if (!isLetterOrDigit(c)) { return false; }
        }
        return true;
    }

    // Username must be 5 characters (no spaces) and lowercase
    public static Boolean validUsername(String user)
    { return (containsOnlyAlphaNumeric(user)) && (user.length() == 5) &&
            (user.equals(user.toLowerCase())); }

    // Password must be 8 characters (no spaces), start with upper case, and contain a number
    public static Boolean validPassword(String pass)
    { return (pass.length() == 8) && (containsNumeric(pass)) &&
            (pass.charAt(0) == toUpperCase((pass.charAt(0)))) && containsOnlyAlphaNumeric(pass); }

}