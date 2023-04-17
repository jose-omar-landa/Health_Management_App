package com.example.healthmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNotePage extends AppCompatActivity {

    private EditText enteredNoteName, enteredNoteDate, enteredNoteContent;
    private Button saveNoteButton;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note_page);

        enteredNoteName = findViewById(R.id.enterNoteName);
        enteredNoteDate = findViewById(R.id.enterNoteDate);
        enteredNoteContent = findViewById(R.id.enterNoteContent);

        saveNoteButton = findViewById(R.id.enterNoteSaveButton);

        dbHelper = new DBHelper(AddNotePage.this);

        saveNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noteName = enteredNoteName.getText().toString();
                String noteDate = enteredNoteDate.getText().toString();
                String noteContent = enteredNoteContent.getText().toString();

                if (noteName.isEmpty() || noteDate.isEmpty() || noteContent.isEmpty()) {
                    Toast.makeText(AddNotePage.this, "Please complete all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHelper.addNote(noteName, noteDate, noteContent);

                Toast.makeText(AddNotePage.this, "Successfully added to notes", Toast.LENGTH_SHORT).show();
                enteredNoteName.setText("");
                enteredNoteDate.setText("");
                enteredNoteContent.setText("");

                Intent i = new Intent(AddNotePage.this, NotesPage.class);
                startActivity(i);
            }
        });

    }
}