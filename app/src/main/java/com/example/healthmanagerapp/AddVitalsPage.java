package com.example.healthmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddVitalsPage extends AppCompatActivity {

    private EditText enteredVitalsDate, enteredBloodPressure, enteredHeartRate, enteredOtherSymptoms;
    private Button vitalsSaveButton;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vitals_page);

        enteredVitalsDate = findViewById(R.id.enterVitalsDate);
        enteredBloodPressure = findViewById(R.id.enterVSBloodPressure);
        enteredHeartRate = findViewById(R.id.enterVSHeartRate);
        enteredOtherSymptoms = findViewById(R.id.enteredVSOtherSymptoms);
        vitalsSaveButton = findViewById(R.id.enterVitalsSaveButton);

        dbHelper = new DBHelper(AddVitalsPage.this);

        vitalsSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vitalsDate = enteredVitalsDate.getText().toString();
                String vitalsBP = enteredBloodPressure.getText().toString();
                String vitalsHR = enteredHeartRate.getText().toString();
                String vitalsOtherSymptoms = enteredOtherSymptoms.getText().toString();

                if (vitalsDate.isEmpty() || vitalsBP.isEmpty() || vitalsHR.isEmpty() || vitalsOtherSymptoms.isEmpty()) {
                    Toast.makeText(AddVitalsPage.this, "Please complete all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHelper.addVitals(vitalsDate, vitalsBP, vitalsHR, vitalsOtherSymptoms);

                Toast.makeText(AddVitalsPage.this, "Successfully added to vital signs", Toast.LENGTH_SHORT).show();
                enteredVitalsDate.setText("");
                enteredBloodPressure.setText("");
                enteredHeartRate.setText("");
                enteredOtherSymptoms.setText("");

                Intent i = new Intent(AddVitalsPage.this, VitalsPage.class);
                startActivity(i);
            }
        });


    }
}