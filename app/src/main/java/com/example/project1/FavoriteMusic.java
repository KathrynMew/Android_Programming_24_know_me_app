package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class FavoriteMusic extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String[] songs = {"Select song to play",
            "Caught In A Blue - Stephen Sanchez",
            "The Pool - Stephen Sanchez",
            "Ring of Fire (feat. Avi Kaplan) - Home Free",
            "Sinners - Barns Courtney",
            "Flash Mountain - Djo"};

    private static final String[] links = {"https://www.youtube.com/watch?v=JVaIHQuGq8Y",
            "https://www.youtube.com/watch?v=xx-Xqmmzlk4&pp=ygUYdGhlIHBvb2wgc3RlcGhlbiBzYW5jaGV6",
            "https://www.youtube.com/watch?v=0l3dsHCScxU&pp=ygUWUmluZyBvZiBGaXJlIGhvbWUgZnJlZQ%3D%3D",
            "https://www.youtube.com/watch?v=gJQTd0aoqHY&pp=ygUHU2lubmVycw%3D%3D",
            "https://www.youtube.com/watch?v=3Ol5SZtJpdY&pp=ygUORmxhc2ggTW91bnRhaW4%3D"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_music);

        Spinner spinner = findViewById(R.id.musicSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                songs
        );
        // Apply the adapter to the spinner.
        spinner.setAdapter(adapter);
        // Set listener on the activity that implements AdapterView
        spinner.setOnItemSelectedListener(this);

        // onClickListener for Caught In A Blue
        ImageButton ciab = findViewById(R.id.songButton);
        ciab.setOnClickListener(v -> {
            Intent launch = new Intent(Intent.ACTION_VIEW, Uri.parse(links[0]));
            startActivity(launch);
        });

        // onClickListener for The Pool
        ImageButton pool = findViewById(R.id.songButton2);
        pool.setOnClickListener(v -> {
            Intent launch = new Intent(Intent.ACTION_VIEW, Uri.parse(links[1]));
            startActivity(launch);
        });

        // onClickListener for Ring of Fire
        ImageButton rof = findViewById(R.id.songButton3);
        rof.setOnClickListener(v -> {
            Intent launch = new Intent(Intent.ACTION_VIEW, Uri.parse(links[2]));
            startActivity(launch);
        });

        // onClickListener for Sinners
        ImageButton sin = findViewById(R.id.songButton4);
        sin.setOnClickListener(v -> {
            Intent launch = new Intent(Intent.ACTION_VIEW, Uri.parse(links[3]));
            startActivity(launch);
        });

        // onClickListener for Flash Mountain
        ImageButton fm = findViewById(R.id.songButton5);
        fm.setOnClickListener(v -> {
            Intent launch = new Intent(Intent.ACTION_VIEW, Uri.parse(links[4]));
            startActivity(launch);
        });

        Button home = findViewById(R.id.homeButton);
        home.setOnClickListener(v -> {
            Intent messageIntent = new Intent(getApplicationContext(), HomePage.class);
            startActivity(messageIntent);
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        if (pos > 0) {
            // get corresponding link in links[] for selected song
            int index = pos - 1;
            // For debugging
            Log.d("Song", "====="+parent.getItemAtPosition(pos).toString());
            Log.d("Link index", "====="+index);
            // Create Intent to navigate to Youtube page to watch music video
            Intent launch = new Intent(Intent.ACTION_VIEW, Uri.parse(links[index]));
            startActivity(launch);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // does nothing
    }
}