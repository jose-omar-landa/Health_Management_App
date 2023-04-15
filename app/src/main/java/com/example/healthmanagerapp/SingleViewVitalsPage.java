package com.example.healthmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SingleViewVitalsPage extends AppCompatActivity {

    TextView vitalsDate, bloodPressure, heartRate, otherSymptoms;
    Button updateVitalsBtn, deleteVitalsBtn;

    String vsDate,  vsBloodPressure, vsHeartRate, vsOtherSymptoms;

    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view_vitals_page);

        vitalsDate = findViewById(R.id.TV_vitals_date);
        bloodPressure = findViewById(R.id.TV_vitals_blood_pressure);
        heartRate = findViewById(R.id.TV_vitals_heart_rate);
        otherSymptoms = findViewById(R.id.TV_vitals_other_symptoms);

        updateVitalsBtn = findViewById(R.id.updateVitalsButton);
        deleteVitalsBtn = findViewById(R.id.deleteVitalsButton);

        dbHelper = new DBHelper(SingleViewVitalsPage.this);


        //Get data passed from adapter class
        vsDate = getIntent().getStringExtra("date");
        vsBloodPressure = getIntent().getStringExtra("bloodPressure");
        vsHeartRate = getIntent().getStringExtra("heartRate");
        vsOtherSymptoms = getIntent().getStringExtra("otherSymptoms");

        //Set data to EditText fields
        vitalsDate.setText(vsDate);
        bloodPressure.setText(vsBloodPressure);
        heartRate.setText(vsHeartRate);
        otherSymptoms.setText(vsOtherSymptoms);


        //Update vitals button click listener
        updateVitalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SingleViewVitalsPage.this, UpdateVitalsPage.class);
                startActivity(i);
            }
        });

        //Delete vitals button click listener
        deleteVitalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteVitals(vsDate);
                Toast.makeText(SingleViewVitalsPage.this, "Vitals Deleted", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(SingleViewVitalsPage.this, VitalsPage.class);
                startActivity(i);
            }
        });

    }
}