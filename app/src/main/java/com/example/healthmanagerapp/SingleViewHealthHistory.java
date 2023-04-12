package com.example.healthmanagerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SingleViewHealthHistory extends AppCompatActivity {

    TextView problemName, dateDiagnosed, diagnosedBy, otherInformation;
    Button updateBtn, deleteBtn;

    String historyName,  historyDate, historyBy, moreInfo;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view_health_history);

        problemName = findViewById(R.id.TV_history_name);
        dateDiagnosed = findViewById(R.id.TV_date_diagnosed);
        diagnosedBy = findViewById(R.id.TV_diagnosed_by);
        otherInformation = findViewById(R.id.TV_other_info);

        updateBtn = findViewById(R.id.updateButton);
        deleteBtn = findViewById(R.id.deleteButton);

        dbHelper = new DBHelper(SingleViewHealthHistory.this);

        //Get data passed from adapter class
        historyName = getIntent().getStringExtra("probName");
        historyDate = getIntent().getStringExtra("diagDate");
        historyBy = getIntent().getStringExtra("diagnosedBy");
        moreInfo = getIntent().getStringExtra("otherInfo");

        //Set data to EditText fields
        problemName.setText(historyName);
        dateDiagnosed.setText(historyDate);
        diagnosedBy.setText(historyBy);
        otherInformation.setText(moreInfo);



        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SingleViewHealthHistory.this, UpdateHealthHistoryPage.class);
                startActivity(i);
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteHealthHistory(historyName);
                Toast.makeText(SingleViewHealthHistory.this, "History Deleted", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(SingleViewHealthHistory.this, HealthHistoryPage.class);
                startActivity(i);
            }
        });


    }

}