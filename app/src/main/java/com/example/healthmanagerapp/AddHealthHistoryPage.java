package com.example.healthmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddHealthHistoryPage extends AppCompatActivity {

    private EditText enteredHealthProblem, enteredDiagnosedDate, enteredDiagnosedBy, enteredOtherInfo;
    private Button saveButton;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_health_history_page);

        enteredHealthProblem = findViewById(R.id.enterDiagnosis);
        enteredDiagnosedDate = findViewById(R.id.enterDateDiagnosed);
        enteredDiagnosedBy = findViewById(R.id.enterDiagnosedBy);
        enteredOtherInfo = findViewById(R.id.enteredImportantInfo);
        saveButton = findViewById(R.id.enterHealthHistorySaveButton);

        dbHelper = new DBHelper(AddHealthHistoryPage.this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String diagnosisName = enteredHealthProblem.getText().toString();
                String dateDiagnosed = enteredDiagnosedDate.getText().toString();
                String diagnosedBy = enteredDiagnosedBy.getText().toString();
                String otherInfo = enteredOtherInfo.getText().toString();

                if (diagnosisName.isEmpty() || dateDiagnosed.isEmpty() || diagnosedBy.isEmpty() || otherInfo.isEmpty()) {
                    Toast.makeText(AddHealthHistoryPage.this, "Please complete all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHelper.addHealthProblem(diagnosisName, dateDiagnosed, diagnosedBy, otherInfo);

                Toast.makeText(AddHealthHistoryPage.this, "Successfully added to health history", Toast.LENGTH_SHORT).show();
                enteredHealthProblem.setText("");
                enteredDiagnosedDate.setText("");
                enteredDiagnosedBy.setText("");
                enteredOtherInfo.setText("");
            }
        });

    }
}