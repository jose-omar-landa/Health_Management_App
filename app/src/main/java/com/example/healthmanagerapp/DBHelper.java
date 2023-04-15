package com.example.healthmanagerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    //Main Database Variables and Version

    private static final String DATABASE_NAME = "HealthManagerDatabase";
    private static final int DATABASE_VERSION = 4;

    //Health History Table
    private static final String TABLE_NAME = "HealthHistory";
    private static final String ID_COL = "id";
    private static final String PROB_NAME_COL = "probName";
    private static final String DIAG_DATE_COL = "diagDate";
    private static final String DIAG_BY_COL = "diagnosedBy";
    private static final String OTHER_INFO_COL = "otherInfo";

    //Vitals Table
    private static final String VITALS_TABLE_NAME = "VitalSigns";
    private static final String VITALS_ID_COL = "id";
    private static final String VITALS_DATE_COL = "date";
    private static final String VITALS_BP_COL = "bloodPressure";
    private static final String VITALS_HR_COL = "heartRate";
    private static final String VITALS_OTHER_COL = "otherSymptoms";

    //Medications Table
    private static final String MEDS_TABLE_NAME = "Medications";
    private static final String MEDS_ID_COL = "id";
    private static final String MEDS_NAME_COL = "name";
    private static final String MEDS_DOSE_COL = "dosage";
    private static final String MEDS_TIME_TAKEN_COL = "time";
    private static final String MEDS_PRESCRIBED_BY_COL = "prescribedBy";

    //Notes Table
    private static final String NOTES_TABLE_NAME = "UserNotes";
    private static final String NOTES_ID_COL = "id";
    private static final String NOTES_NAME_COL = "name";
    private static final String NOTES_DATE_COL = "date";
    private static final String NOTES_CONTENT_COL = "content";



    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Health History Table
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PROB_NAME_COL + " TEXT,"
                + DIAG_DATE_COL + " TEXT,"
                + DIAG_BY_COL + " TEXT,"
                + OTHER_INFO_COL + " TEXT)";

        sqLiteDatabase.execSQL(query);

        //Vital Signs Table
        String vitalsQuery = "CREATE TABLE " + VITALS_TABLE_NAME + " ("
                + VITALS_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + VITALS_DATE_COL + " TEXT,"
                + VITALS_BP_COL + " TEXT,"
                + VITALS_HR_COL + " TEXT,"
                + VITALS_OTHER_COL + " TEXT)";

        sqLiteDatabase.execSQL(vitalsQuery);

        //Medications Table
        String medsQuery = "CREATE TABLE " + MEDS_TABLE_NAME + " ("
                + MEDS_ID_COL + "  INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MEDS_NAME_COL + " TEXT,"
                + MEDS_DOSE_COL + " TEXT,"
                + MEDS_TIME_TAKEN_COL + " TEXT,"
                + MEDS_PRESCRIBED_BY_COL + " TEXT)";

        sqLiteDatabase.execSQL(medsQuery);

        //Notes Table
        String notesQuery = "CREATE TABLE " + NOTES_TABLE_NAME + " ("
                + NOTES_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NOTES_NAME_COL + " TEXT,"
                + NOTES_DATE_COL + " TEXT,"
                + NOTES_CONTENT_COL + " TEXT)";

        sqLiteDatabase.execSQL(notesQuery);
    }

    //Health History Database Functions:
    public void addHealthProblem(String problemName, String dateDiagnosed, String whoDiagnosed, String additionalInfo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PROB_NAME_COL, problemName);
        values.put(DIAG_DATE_COL, dateDiagnosed);
        values.put(DIAG_BY_COL, whoDiagnosed);
        values.put(OTHER_INFO_COL, additionalInfo);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<HealthHistoryModal> readHealthHistory() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<HealthHistoryModal> healthHistoryModalArrayList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                healthHistoryModalArrayList.add(new HealthHistoryModal(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return healthHistoryModalArrayList;
    }


    public void deleteHealthHistory(String problemName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "probName=?", new String[]{problemName});
        db.close();
    }

    public void updateHealthHistory(String originalName, String problemName, String diagDate, String diagBy, String otherInfo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(PROB_NAME_COL, problemName);
        values.put(DIAG_DATE_COL, diagDate);
        values.put(DIAG_BY_COL, diagBy);
        values.put(OTHER_INFO_COL, otherInfo);

        db.update(TABLE_NAME, values, "probName=?", new String[]{originalName});
        db.close();
    }

    //Vitals Database Functions:
    public void addVitals(String vitalsDate, String bloodPressure, String heartRate, String additionalSymptoms) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(VITALS_DATE_COL, vitalsDate);
        values.put(VITALS_BP_COL, bloodPressure);
        values.put(VITALS_HR_COL, heartRate);
        values.put(VITALS_OTHER_COL, additionalSymptoms);

        db.insert(VITALS_TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<VitalsModal> readVitals() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + VITALS_TABLE_NAME, null);

        ArrayList<VitalsModal> vitalsModalArrayList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                vitalsModalArrayList.add(new VitalsModal(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return vitalsModalArrayList;
    }

    public void deleteVitals(String vitalsDate) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VITALS_TABLE_NAME, "date=?", new String[]{vitalsDate});
        db.close();
    }

    public void updateVitals(String originalDate, String vitalsDate, String vitalsBloodPressure, String vitalsHeartRate, String vitalsOtherSymptoms) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(VITALS_DATE_COL, vitalsDate);
        values.put(VITALS_BP_COL, vitalsBloodPressure);
        values.put(VITALS_HR_COL, vitalsHeartRate);
        values.put(VITALS_OTHER_COL, vitalsOtherSymptoms);

        db.update(VITALS_TABLE_NAME, values, "date=?", new String[]{originalDate});
        db.close();
    }


    //Medications Database Functions:
    public void addMedication(String medName, String medDose, String medTime, String medPrescribedBy) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MEDS_NAME_COL, medName);
        values.put(MEDS_DOSE_COL, medDose);
        values.put(MEDS_TIME_TAKEN_COL, medTime);
        values.put(MEDS_PRESCRIBED_BY_COL, medPrescribedBy);

        db.insert(MEDS_TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<MedicationsModal> readMedications() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + MEDS_TABLE_NAME, null);

        ArrayList<MedicationsModal> medicationsModalArrayList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                medicationsModalArrayList.add(new MedicationsModal(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return medicationsModalArrayList;
    }

    public void deleteMedication(String medName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(MEDS_TABLE_NAME, "name=?", new String[]{medName});
        db.close();
    }

    public void updateMedication(String originalName, String medName, String medDose, String medTime, String medPrescribedBy) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(MEDS_NAME_COL, medName);
        values.put(MEDS_DOSE_COL, medDose);
        values.put(MEDS_TIME_TAKEN_COL, medTime);
        values.put(MEDS_PRESCRIBED_BY_COL, medPrescribedBy);

        db.update(MEDS_TABLE_NAME, values, "name=?", new String[]{originalName});
        db.close();
    }


    //Notes Database Functions:
    public void addNote(String noteName, String noteDate, String noteContent) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NOTES_NAME_COL, noteName);
        values.put(NOTES_DATE_COL, noteDate);
        values.put(NOTES_CONTENT_COL, noteContent);

        db.insert(NOTES_TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<NotesModal> readNotes() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + NOTES_TABLE_NAME, null);

        ArrayList<NotesModal> notesModalArrayList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                notesModalArrayList.add(new NotesModal(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return notesModalArrayList;
    }

    public void deleteNote(String noteName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(NOTES_TABLE_NAME, "name=?", new String[]{noteName});
        db.close();
    }

    public void updateNote(String originalName, String noteName, String noteDate, String noteContent) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NOTES_NAME_COL, noteName);
        values.put(NOTES_DATE_COL, noteDate);
        values.put(NOTES_CONTENT_COL, noteContent);

        db.update(NOTES_TABLE_NAME, values, "name=?", new String[]{originalName});
        db.close();
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


}
