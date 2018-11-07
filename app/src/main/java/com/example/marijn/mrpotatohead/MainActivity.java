package com.example.marijn.mrpotatohead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // Create a list with all Mr Potatohead parts
    String[] dressPotato = {"arms", "ears", "eyebrows", "eyes", "glasses", "hat", "mouth", "mustache", "nose", "shoes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            return;
        } else {
            for (String bodyP : dressPotato) {
                int resourceID = getResources().getIdentifier(bodyP, "id", getPackageName());
                ImageView image = findViewById(resourceID);
                image.setVisibility(savedInstanceState.getInt(bodyP));
            }
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState); // always call super

        // Save the state with outState
        for (String bodyP: dressPotato) {
            int resourceID = getResources().getIdentifier(bodyP, "id", getPackageName());
            ImageView image = findViewById(resourceID);
            outState.putInt(bodyP, image.getVisibility());
        }
    }

    // Check if checkbox is checked by user
    public void checkClicked(View v) {

        CheckBox checkbox = (CheckBox) v;

        // Get resource string name
        String potatoVar = checkbox.getText().toString();

        // Get resource ID by using the resources string name.
        // Source: https://android.okhelp.cz/get-resource-id-by-resources-string-name-android-example/
        int resourceID = getResources().getIdentifier(potatoVar, "id", getPackageName());
        ImageView potatoImage = findViewById(resourceID);

        // Hide or show image
        if (potatoImage.getVisibility() == View.INVISIBLE){
            potatoImage.setVisibility(View.VISIBLE);
        }
        else if (potatoImage.getVisibility() == View.VISIBLE) {
            potatoImage.setVisibility(View.INVISIBLE);
        }
    }
}