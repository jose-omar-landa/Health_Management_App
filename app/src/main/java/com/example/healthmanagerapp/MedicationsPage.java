package com.example.healthmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MedicationsPage extends AppCompatActivity {

    ImageButton addMedication, backButton;
    private ArrayList<MedicationsModal> medicationsModalArrayList;
    private DBHelper dbHelper;
    private MedicationViewAdapter medicationViewAdapter;
    private RecyclerView medicationRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medications_page);


        addMedication = findViewById(R.id.addMedicationsButton);
        backButton = findViewById(R.id.medsPageBackButton);

        medicationsModalArrayList = new ArrayList<>();
        dbHelper = new DBHelper(MedicationsPage.this);

        medicationsModalArrayList = dbHelper.readMedications();

        medicationViewAdapter = new MedicationViewAdapter(medicationsModalArrayList, MedicationsPage.this);
        medicationRV = findViewById(R.id.idRVmedications);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MedicationsPage.this, RecyclerView.VERTICAL, false);
        medicationRV.setLayoutManager(linearLayoutManager);

        medicationRV.setAdapter(medicationViewAdapter);

        addMedication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MedicationsPage.this, AddMedicationPage.class);
                startActivity(i);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MedicationsPage.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}