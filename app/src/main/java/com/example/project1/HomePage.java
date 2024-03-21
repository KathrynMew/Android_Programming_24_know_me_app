package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Set text display of welcome message with user's name (from SignUp.class)
        TextView editWelcome = findViewById(R.id.welcomeUserTextView);
        String welcomeMessage = "welcome "+SignUp.getName();
        editWelcome.setText(welcomeMessage);

        /*
          DONE: Display username and password
          DONE: Change password
         */
        Button accSetButton = findViewById(R.id.accountSettingsButton);
        accSetButton.setOnClickListener(v -> {
            Intent settingsIntent = new Intent(getApplicationContext(), AccountSettings.class);
            startActivity(settingsIntent);
        });

        /*
          DONE: Add some songs
          DONE: Option to play their favorite music (from dropdown [])
          DONE: Selection from the dropdown menu should navigate to the YouTube page and
           play the corresponding song. Uri objects will be helpful for this.
          EXTRA: Added a horizontal scrollview containing ImageButtons for the songs, organized
           as they are in the songs[]
        */
        Button favMusButton = findViewById(R.id.favoriteMusicButton);
        favMusButton.setOnClickListener(v -> {
            Intent musicIntent = new Intent(getApplicationContext(), FavoriteMusic.class);
            startActivity(musicIntent);
        });

        /*
          DONE: Textbox to enter what you wish to do in the future
          DONE: Save button
          DONE: Display what was added to a checkbox (indicating the goal was added to the list)
        */
        Button bktLstButton = findViewById(R.id.bucketListButton);
        bktLstButton.setOnClickListener(v -> {
            Intent bucketIntent = new Intent(getApplicationContext(), BucketList.class);
            startActivity(bucketIntent);
        });

        /*
          DONE: Only displays values (no public or private variables)
          DONE: Title - Subject line
          DONE: A special/favorite memory - Description of a memory
          DONE: A related picture
        */
        Button favMemButton = findViewById(R.id.favoriteMemoriesButton);
        favMemButton.setOnClickListener(v -> {
            Intent memoryIntent = new Intent(getApplicationContext(), FavoriteMemories.class);
            startActivity(memoryIntent);
        });

        /*
          DONE: Add 4 buttons that provide links to some informational websites.
           Clicking on these buttons should navigate to the corresponding website.
          DONE: Uri link=intent.getData();
           Intent launch=new Intent(Intent.ACTION_VIEW,link);
           startActivity(launch);
        */
        Button helpLkButton = findViewById(R.id.helpfulLinksButton);
        helpLkButton.setOnClickListener(v -> {
            Intent linkIntent = new Intent(getApplicationContext(), HelpfulLinks.class);
            startActivity(linkIntent);
        });

        Button backButton = findViewById(R.id.backButton);
        backButton.setEnabled(false);
    }
}