package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelpfulLinks extends AppCompatActivity {

    private static final Uri theoi = Uri.parse("https://www.theoi.com");
    private static final Uri sanchezBaby = Uri.parse("https://www.stephensanchezofficial.com/#/");
    private static final Uri cars = Uri.parse("https://www.caranddriver.com/");
    private static final Uri picrew = Uri.parse("https://picrew.me/en/image_maker/1426480");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpful_links);

        // website 1: theoi.com
        Button web1 = findViewById(R.id.websiteButton1);
        web1.setOnClickListener(v -> {
            Intent launch = new Intent(Intent.ACTION_VIEW, theoi);
            startActivity(launch);
        });

        // website 2: stephensanchezofficial.com
        Button web2 = findViewById(R.id.websiteButton2);
        web2.setOnClickListener(v -> {
            Intent launch = new Intent(Intent.ACTION_VIEW, sanchezBaby);
            startActivity(launch);
        });

        // website 3: caranddriver.com
        Button web3 = findViewById(R.id.websiteButton3);
        web3.setOnClickListener(v -> {
            Intent launch = new Intent(Intent.ACTION_VIEW, cars);
            startActivity(launch);
        });

        // website 4: picrew.com
        Button web4 = findViewById(R.id.websiteButton4);
        web4.setOnClickListener(v -> {
            Intent launch = new Intent(Intent.ACTION_VIEW, picrew);
            startActivity(launch);
        });

        Button home = findViewById(R.id.homeButton);
        home.setOnClickListener(v -> {
            Intent messageIntent = new Intent(getApplicationContext(), HomePage.class);
            startActivity(messageIntent);
        });
    }
}