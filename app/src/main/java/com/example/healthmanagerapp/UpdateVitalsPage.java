package com.example.healthmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateVitalsPage extends AppCompatActivity {

    private EditText vitalsDate, bloodPressure, heartRate, otherSymptoms;
    private Button updateVitalsBtn;
    private DBHelper dbHelper;
    String vsDate,  vsBloodPressure, vsHeartRate, vsOtherSymptoms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_vitals_page);

        //initialize EditTexts
        vitalsDate = findViewById(R.id.updateVitalsDate);
        bloodPressure = findViewById(R.id.updateBloodPressure);
        heartRate = findViewById(R.id.updateHeartRate);
        otherSymptoms = findViewById(R.id.updateOtherSymptoms);

        //Initialize Button
        updateVitalsBtn = findViewById(R.id.updateVitalsSaveButton);

        //Initialize database handler
        dbHelper = new DBHelper(UpdateVitalsPage.this);

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


        updateVitalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.updateHealthHistory(vsDate, vitalsDate.getText().toString(), bloodPressure.getText().toString(),
                        heartRate.getText().toString(), otherSymptoms.getText().toString());
                Toast.makeText(UpdateVitalsPage.this, "Vitals Updated", Toast.LENGTH_SHORT);
                Intent i = new Intent(UpdateVitalsPage.this, VitalsPage.class);
                startActivity(i);
            }
        });

    }
}