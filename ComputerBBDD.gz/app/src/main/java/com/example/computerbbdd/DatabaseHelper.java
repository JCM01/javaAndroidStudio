package com.example.computerbbdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "COMPUTERS";

    // Table columns
    public static final String _ID = "_id";
    public static final String MARCA = "marca";
    public static final String CPU = "cpu";
    public static final String OS = "os";
    public static final String PRECIO = "precio";


    // Database Information
    static final String DB_NAME = "COMPUTERS.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( " + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MARCA + " TEXT NOT NULL, " + CPU + " TEXT, " + OS + " TEXT,  " + PRECIO + " FLOAT );";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
