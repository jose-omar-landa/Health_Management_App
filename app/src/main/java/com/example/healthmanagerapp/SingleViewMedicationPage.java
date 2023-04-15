package com.example.healthmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SingleViewMedicationPage extends AppCompatActivity {

    TextView medName, medDose, timeTaken, prescribedBy;
    Button updateMedBtn, deleteMedBtn;

    String medicationName,  medicationDose, medTimeTaken, medPrescriber;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view_medication_page);

        medName = findViewById(R.id.TV_med_name);
        medDose = findViewById(R.id.TV_med_dose);
        timeTaken = findViewById(R.id.TV_time_taken);
        prescribedBy = findViewById(R.id.TV_prescribed_by);

        updateMedBtn = findViewById(R.id.updateMedButton);
        deleteMedBtn = findViewById(R.id.deleteMedButton);

        dbHelper = new DBHelper(SingleViewMedicationPage.this);

        //Get data passed from adapter class
        medicationName = getIntent().getStringExtra("name");
        medicationDose = getIntent().getStringExtra("dosage");
        medTimeTaken = getIntent().getStringExtra("time");
        medPrescriber = getIntent().getStringExtra("prescribedBy");

        //Set data to EditText fields
        medName.setText(medicationName);
        medDose.setText(medicationDose);
        timeTaken.setText(medTimeTaken);
        prescribedBy.setText(medPrescriber);


        updateMedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SingleViewMedicationPage.this, UpdateMedicationPage.class);
                startActivity(i);
            }
        });

        deleteMedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteMedication(medicationName);
                Toast.makeText(SingleViewMedicationPage.this, "Medication Deleted", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(SingleViewMedicationPage.this, MedicationsPage.class);
                startActivity(i);
            }
        });
    }
}