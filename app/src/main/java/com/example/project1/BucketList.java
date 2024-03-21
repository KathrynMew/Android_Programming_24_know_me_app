package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class BucketList extends AppCompatActivity {

    private EditText wish;
    private CheckBox item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucket_list);

        // Find editText and checkbox views
        wish = findViewById(R.id.toDoText);
        item = findViewById(R.id.bucketListCheck);

        Button home = findViewById(R.id.homeButton);
        home.setOnClickListener(v -> {
            if (item.getVisibility() == View.VISIBLE) {
                // Resets the visibility of the checkbox upon leaving the page
                item.setVisibility(View.INVISIBLE);
                Log.d("Visibility", "===== Invisible");
            }
            Intent homeIntent = new Intent(getApplicationContext(), HomePage.class);
            startActivity(homeIntent);
        });
    }

    public void addWish(View view) {
        // Retrieve user input when "save" button is pressed
        String checkboxInput = wish.getText().toString();

        // if EditText isEmpty(), then return Toast message
        if (checkboxInput.isEmpty()) {
            Toast.makeText(this, "Nothing to add", Toast.LENGTH_LONG).show();
        } else {
            // Set checkbox text to user input and make the checkbox visible
            item.setText(checkboxInput);
            item.setVisibility(View.VISIBLE);
            Log.d("Visibility", "===== Visible");
            Toast.makeText(this, "Wish added!", Toast.LENGTH_LONG).show();
        }
    }
}