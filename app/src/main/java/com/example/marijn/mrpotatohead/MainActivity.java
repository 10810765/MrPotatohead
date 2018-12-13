package com.example.marijn.mrpotatohead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

/**
 * Marijn Meijering <m.h.j.meijering@uva.nl>
 * 10810765 Universiteit van Amsterdam
 * Minor Programmeren 17/12/2018
 */
public class MainActivity extends AppCompatActivity {

    // Create a list with all Mr Potatohead parts
    String[] mrPotatoParts = {"arms", "ears", "eyebrows", "eyes", "glasses", "hat", "mouth", "mustache", "nose", "shoes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // If there are previously saved instance states, restore these states
        if (savedInstanceState == null) {
            return;
        } else {
            for (String potatoP : mrPotatoParts) {
                int resourceID = getResources().getIdentifier(potatoP, "id", getPackageName());
                ImageView image = findViewById(resourceID);
                image.setVisibility(savedInstanceState.getInt(potatoP));
            }
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the state with outState
        for (String potatoP: mrPotatoParts) {
            int resourceID = getResources().getIdentifier(potatoP, "id", getPackageName());
            ImageView image = findViewById(resourceID);
            outState.putInt(potatoP, image.getVisibility());
        }
    }

    // On reset button clicked, reset checkboxes and set image views invisible
    public void resetClicked(View v) {
        for (String potatoP : mrPotatoParts) {

            // Reset image visibility
            int imageID = getResources().getIdentifier(potatoP, "id", getPackageName());
            ImageView image = findViewById(imageID);
            image.setVisibility(View.INVISIBLE);

            // Reset checkboxes
            int checkboxID = getResources().getIdentifier(potatoP + "Check", "id", getPackageName());
            CheckBox checkBox = findViewById(checkboxID);
            checkBox.setChecked(false);
        }
    }

    // Check if checkbox is checked by user
    public void checkClicked(View v) {

        // Create a temporary variable to hold the CheckBox
        CheckBox checkbox = (CheckBox) v;

        // Get resource string name
        String potatoVar = checkbox.getText().toString();

        // Get resource ID by using the resources string name.
        // Source: https://android.okhelp.cz/get-resource-id-by-resources-string-name-android-example/
        int resourceID = getResources().getIdentifier(potatoVar, "id", getPackageName());
        ImageView potatoImage = findViewById(resourceID);

        // Hide or show image based on previous state
        if (potatoImage.getVisibility() == View.INVISIBLE){
            potatoImage.setVisibility(View.VISIBLE);
        }
        else {
            potatoImage.setVisibility(View.INVISIBLE);
        }
    }
}