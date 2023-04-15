package com.example.healthmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class VitalsPage extends AppCompatActivity {

    ImageButton addVitalSigns;
    private ArrayList<VitalsModal> vitalsModalArrayList;
    private DBHelper dbHelper;
    private VitalsViewAdapter vitalsViewAdapter;
    private RecyclerView vitalsRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitals_page);

        addVitalSigns = findViewById(R.id.addVitalsButton);

        vitalsModalArrayList = new ArrayList<>();
        dbHelper = new DBHelper(VitalsPage.this);

        vitalsModalArrayList = dbHelper.readVitals();

        vitalsViewAdapter = new VitalsViewAdapter(vitalsModalArrayList, VitalsPage.this);
        vitalsRV = findViewById(R.id.idRVVitalSigns);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(VitalsPage.this, RecyclerView.VERTICAL, false);
        vitalsRV.setLayoutManager(linearLayoutManager);

        vitalsRV.setAdapter(vitalsViewAdapter);

        addVitalSigns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VitalsPage.this, AddVitalsPage.class);
                startActivity(i);
            }
        });



    }
}