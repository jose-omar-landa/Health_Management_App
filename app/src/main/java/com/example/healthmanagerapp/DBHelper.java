package com.example.healthmanagerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "HealthManagerDatabase";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "HealthHistory";
    private static final String ID_COL = "id";
    private static final String PROB_NAME_COL = "probName";
    private static final String DIAG_DATE_COL = "diagDate";
    private static final String DIAG_BY_COL = "diagnosedBy";
    private static final String OTHER_INFO_COL = "otherInfo";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PROB_NAME_COL + " TEXT,"
                + DIAG_DATE_COL + " TEXT,"
                + DIAG_BY_COL + " TEXT,"
                + OTHER_INFO_COL + " TEXT)";

        sqLiteDatabase.execSQL(query);
    }

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

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }



}
