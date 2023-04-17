package com.example.healthmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class NotesPage extends AppCompatActivity {

    ImageButton addNoteImageButton, backButton;
    private ArrayList<NotesModal> notesModalArrayList;
    private DBHelper dbHelper;
    private NotesViewAdapter notesViewAdapter;
    private RecyclerView notesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_page);

        addNoteImageButton = findViewById(R.id.addNotesButton);
        backButton = findViewById(R.id.notesPageBackButton);

        notesModalArrayList = new ArrayList<>();
        dbHelper = new DBHelper(NotesPage.this);

        notesModalArrayList = dbHelper.readNotes();

        notesViewAdapter = new NotesViewAdapter(notesModalArrayList, NotesPage.this);
        notesRV = findViewById(R.id.idRVnotes);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NotesPage.this, RecyclerView.VERTICAL, false);
        notesRV.setLayoutManager(linearLayoutManager);

        notesRV.setAdapter(notesViewAdapter);

        addNoteImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NotesPage.this, AddNotePage.class);
                startActivity(i);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NotesPage.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}