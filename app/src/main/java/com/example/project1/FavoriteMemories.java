package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

public class FavoriteMemories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_memories);

        TextView memory1 = findViewById(R.id.description);
        TextView memory2 = findViewById(R.id.description2);
        TextView memory3 = findViewById(R.id.description3);

        // Make TextViews for memory descriptions scrollable in UI
        memory1.setMovementMethod(new ScrollingMovementMethod());
        memory2.setMovementMethod(new ScrollingMovementMethod());
        memory3.setMovementMethod(new ScrollingMovementMethod());

        Button home = findViewById(R.id.homeButton);
        home.setOnClickListener(v -> {
            Intent homeIntent = new Intent(getApplicationContext(), HomePage.class);
            startActivity(homeIntent);
        });
    }
}