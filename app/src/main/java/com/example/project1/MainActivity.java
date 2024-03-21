/**
 * Author: Kathryn Mew
 * Assignment: Project 1
 */

package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Use ImageButton to proceed to SignUp Activity
        // User can press anywhere on the giant face
        ImageButton goToSignUp = findViewById(R.id.knowMeButton);
        goToSignUp.setOnClickListener(v -> {
            Intent messageIntent = new Intent(getApplicationContext(), SignUp.class);
            startActivity(messageIntent);
        });
    }
}