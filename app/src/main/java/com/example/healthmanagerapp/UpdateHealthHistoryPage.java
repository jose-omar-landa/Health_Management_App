package com.example.healthmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateHealthHistoryPage extends AppCompatActivity {
    
    private EditText diagnosisName, diagnosisDate, diagnosisBy, diagnosisMoreInfo;
    private Button updateBtn;
    private DBHelper dbHelper;
    String historyName,  historyDate, diagnosedBy, moreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_health_history_page);
        
        //initialize EditTexts
        diagnosisName = findViewById(R.id.updateDiagnosis);
        diagnosisDate = findViewById(R.id.updateDateDiagnosed);
        diagnosisBy = findViewById(R.id.updateDiagnosedBy);
        diagnosisMoreInfo = findViewById(R.id.updateImportantInfo);
        
        //Initialize Button
        updateBtn = findViewById(R.id.updateHealthHistorySaveButton);
        
        //Initialize database handler
        dbHelper = new DBHelper(UpdateHealthHistoryPage.this);
        
        //Get data passed from adapter class
        historyName = getIntent().getStringExtra("probName");
        historyDate = getIntent().getStringExtra("diagDate");
        diagnosedBy = getIntent().getStringExtra("diagnosedBy");
        moreInfo = getIntent().getStringExtra("otherInfo");

        //Set data to EditText fields
        diagnosisName.setText(historyName);
        diagnosisDate.setText(historyDate);
        diagnosisBy.setText(diagnosedBy);
        diagnosisMoreInfo.setText(moreInfo);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.updateHealthHistory(historyName, diagnosisName.getText().toString(), diagnosisDate.getText().toString(),
                        diagnosisBy.getText().toString(), diagnosisMoreInfo.getText().toString());
                Toast.makeText(UpdateHealthHistoryPage.this, "History Updated", Toast.LENGTH_SHORT);
                Intent i = new Intent(UpdateHealthHistoryPage.this, HealthHistoryPage.class);
                startActivity(i);
            }
        });


    }
}