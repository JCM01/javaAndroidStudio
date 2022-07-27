package com.example.computerbbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String marca, String cpu, String os, String precio) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.MARCA, marca);
        contentValue.put(DatabaseHelper.CPU, cpu);
        contentValue.put(DatabaseHelper.OS, os);
        contentValue.put(DatabaseHelper.PRECIO, precio);

        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);

    }

    public Cursor fetch() {
        String[] columns = new String[]{DatabaseHelper._ID, DatabaseHelper.MARCA, DatabaseHelper.CPU, DatabaseHelper.OS, DatabaseHelper.PRECIO};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }

    public Computer findComputerById(long _id,String marca, String cpu, String os, String precio) {

        String[] returnValues = {DatabaseHelper._ID, DatabaseHelper.MARCA, DatabaseHelper.CPU, DatabaseHelper.OS, DatabaseHelper.PRECIO};
        Cursor c = database.query(DatabaseHelper.TABLE_NAME, returnValues, DatabaseHelper._ID + " = '" + _id + "'",
                null, null, null, null, null);
        if (c != null)
            c.moveToFirst();
        Computer computer = null;
        try {
            computer = new Computer(c.getInt(0), c.getString(1),
                    c.getString(2), c.getString(3),c.getFloat(4));
        } catch (CursorIndexOutOfBoundsException e) {
            Log.d("Resultado", "No se encuentra el ordenador en la base de datos");

        }
        c.close();
        return computer;
    }


    public int update(long _id, String marca, String cpu, String os,String precio) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.MARCA, marca);
        contentValues.put(DatabaseHelper.CPU, cpu);
        contentValues.put(DatabaseHelper.PRECIO, precio);
        database.acquireReference();
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }

}
