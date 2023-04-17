package com.example.healthmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateNotePage extends AppCompatActivity {

    private EditText noteName, noteDate, noteContent;
    private Button updateNoteBtn;
    private DBHelper dbHelper;
    String nameOfNote,  dateOfNote, contentOfNote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_note_page);

        //initialize EditTexts
        noteName = findViewById(R.id.updateNoteName);
        noteDate = findViewById(R.id.updateNoteDate);
        noteContent = findViewById(R.id.updateNoteContent);


        //Initialize Button
        updateNoteBtn = findViewById(R.id.updateNoteSaveButton);

        //Initialize database handler
        dbHelper = new DBHelper(UpdateNotePage.this);

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
                dbHelper.updateNote(nameOfNote, noteName.getText().toString(), noteDate.getText().toString(),
                        noteContent.getText().toString());
                Toast.makeText(UpdateNotePage.this, "Note Updated", Toast.LENGTH_SHORT);
                Intent i = new Intent(UpdateNotePage.this, NotesPage.class);
                startActivity(i);
            }
        });
    }
}