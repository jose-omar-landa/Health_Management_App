package com.example.healthmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMedicationPage extends AppCompatActivity {

    private EditText enteredMedNAme, enteredMedDose, enteredTimeTaken, enteredPrescribeBy;
    private Button saveMedButton;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medication_page);

        enteredMedNAme = findViewById(R.id.enterMedName);
        enteredMedDose = findViewById(R.id.enterMedDose);
        enteredTimeTaken = findViewById(R.id.enterMedTime);
        enteredPrescribeBy = findViewById(R.id.enterPrescribedBy);
        saveMedButton = findViewById(R.id.enterMedicationSaveButton);

        dbHelper = new DBHelper(AddMedicationPage.this);

        saveMedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String medName = enteredMedNAme.getText().toString();
                String medDose = enteredMedDose.getText().toString();
                String timeTaken = enteredTimeTaken.getText().toString();
                String prescribedBy = enteredPrescribeBy.getText().toString();

                if (medName.isEmpty() || medDose.isEmpty() || timeTaken.isEmpty() || prescribedBy.isEmpty()) {
                    Toast.makeText(AddMedicationPage.this, "Please complete all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHelper.addMedication(medName, medDose, timeTaken, prescribedBy);

                Toast.makeText(AddMedicationPage.this, "Successfully added to medication list", Toast.LENGTH_SHORT).show();
                enteredMedNAme.setText("");
                enteredMedDose.setText("");
                enteredTimeTaken.setText("");
                enteredPrescribeBy.setText("");

                Intent i = new Intent(AddMedicationPage.this, MedicationsPage.class);
                startActivity(i);
            }
        });

    }
}