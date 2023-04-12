package com.example.healthmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton healthHistoryButton, medicationsButton, vitalsButton, notesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize buttons
        healthHistoryButton = findViewById(R.id.health_history_button);
        medicationsButton = findViewById(R.id.medications_button);
        vitalsButton = findViewById(R.id.vital_signs_button);
        notesButton = findViewById(R.id.notes_button);


        //Set button On Click Listeners
        healthHistoryButton.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, HealthHistoryPage.class);
            startActivity(i);
        });

        medicationsButton.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, MedicationsPage.class);
            startActivity(i);
        });

        vitalsButton.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, VitalsPage.class);
            startActivity(i);
        });

        notesButton.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, NotesPage.class);
            startActivity(i);
        });

    }
}