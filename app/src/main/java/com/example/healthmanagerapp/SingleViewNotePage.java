package com.example.healthmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SingleViewNotePage extends AppCompatActivity {

    TextView noteName, noteDate, noteContent;
    Button updateNoteBtn, deleteNoteBtn;

    String nameOfNote,  dateOfNote, contentOfNote;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view_note_page);

        noteName = findViewById(R.id.TV_note_name);
        noteDate = findViewById(R.id.TV_note_date);
        noteContent = findViewById(R.id.TV_note_content);

        updateNoteBtn = findViewById(R.id.updateNoteButton);
        deleteNoteBtn = findViewById(R.id.deleteNoteButton);

        dbHelper = new DBHelper(SingleViewNotePage.this);

        //Get data passed from adapter class
        nameOfNote = getIntent().getStringExtra("name");
        dateOfNote = getIntent().getStringExtra("date");
        contentOfNote = getIntent().getStringExtra("content");

        //Set data to EditText fields
        noteName.setText(nameOfNote);
        noteDate.setText(dateOfNote);
        noteContent.setText(contentOfNote);

        updateNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SingleViewNotePage.this, UpdateNotePage.class);
                startActivity(i);
            }
        });

        deleteNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteNote(nameOfNote);
                Toast.makeText(SingleViewNotePage.this, "Note Deleted", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(SingleViewNotePage.this, NotesPage.class);
                startActivity(i);
            }
        });

    }
}