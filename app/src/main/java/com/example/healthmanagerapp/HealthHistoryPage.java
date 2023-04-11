package com.example.healthmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HealthHistoryPage extends AppCompatActivity {

    ImageButton addHealthProblem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_history_page);

        addHealthProblem = findViewById(R.id.addHealthHistButton);

        addHealthProblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HealthHistoryPage.this, AddHealthHistoryPage.class);
                startActivity(i);
            }
        });
    }
}