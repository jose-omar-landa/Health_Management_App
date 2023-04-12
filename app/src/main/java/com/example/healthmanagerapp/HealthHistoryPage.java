package com.example.healthmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class HealthHistoryPage extends AppCompatActivity {

    ImageButton addHealthProblem;
    private ArrayList<HealthHistoryModal> healthHistoryModalArrayList;
    private DBHelper dbHelper;
    private HealthHistoryViewAdapter healthHistoryViewAdapter;
    private RecyclerView healthHistRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_history_page);

        addHealthProblem = findViewById(R.id.addHealthHistButton);

        healthHistoryModalArrayList = new ArrayList<>();
        dbHelper = new DBHelper(HealthHistoryPage.this);

        healthHistoryModalArrayList = dbHelper.readHealthHistory();

        healthHistoryViewAdapter = new HealthHistoryViewAdapter(healthHistoryModalArrayList, HealthHistoryPage.this);
        healthHistRV = findViewById(R.id.idRVhealthHist);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HealthHistoryPage.this, RecyclerView.VERTICAL, false);
        healthHistRV.setLayoutManager(linearLayoutManager);

        healthHistRV.setAdapter(healthHistoryViewAdapter);

        addHealthProblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HealthHistoryPage.this, AddHealthHistoryPage.class);
                startActivity(i);
            }
        });
    }
}