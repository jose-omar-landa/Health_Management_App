package com.example.healthmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateMedicationPage extends AppCompatActivity {

    private EditText medName, medDose, timeTaken, prescribedBy;
    private Button updateMedBtn;
    private DBHelper dbHelper;
    String medicationName,  medicationDose, medicationTimeTaken, medicationPrescribedBy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_medication_page);

        //initialize EditTexts
        medName = findViewById(R.id.updateMedName);
        medDose = findViewById(R.id.updateMedDose);
        timeTaken = findViewById(R.id.updateTimeTaken);
        prescribedBy = findViewById(R.id.updatePrescribedBy);

        //Initialize Button
        updateMedBtn = findViewById(R.id.updateMedicationSaveButton);

        //Initialize database handler
        dbHelper = new DBHelper(UpdateMedicationPage.this);

        //Get data passed from adapter class
        medicationName = getIntent().getStringExtra("name");
        medicationDose = getIntent().getStringExtra("dosage");
        medicationTimeTaken = getIntent().getStringExtra("time");
        medicationPrescribedBy = getIntent().getStringExtra("prescribedBy");

        //Set data to EditText fields
        medName.setText(medicationName);
        medDose.setText(medicationDose);
        timeTaken.setText(medicationTimeTaken);
        prescribedBy.setText(medicationPrescribedBy);

        updateMedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.updateMedication(medicationName, medName.getText().toString(), medDose.getText().toString(),
                        timeTaken.getText().toString(), prescribedBy.getText().toString());
                Toast.makeText(UpdateMedicationPage.this, "Medication Updated", Toast.LENGTH_SHORT);
                Intent i = new Intent(UpdateMedicationPage.this, MedicationsPage.class);
                startActivity(i);
            }
        });



    }
}