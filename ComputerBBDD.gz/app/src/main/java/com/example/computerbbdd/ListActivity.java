package com.example.computerbbdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    List<String> listaStr;
    //ArrayAdapter<String> adapter;
    Computer computer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ArrayList<Computer> computers = new ArrayList<>();

        Cursor c = listUser();
        c.moveToFirst();
        for (int i = 0; i < c.getCount(); i++) {
            System.out.println("control" + c.getString(1));
            // listaStr.add("Marca : " + c.getString(1) + "cPU: " + c.getString(2) + "os: " + c.getString(3) + "precio: " + c.getString(4));

            computer = new Computer(i, c.getString(1), c.getString(2), c.getString(3), Float.parseFloat(c.getString(4)));
            //computer.setPrecio(Float.parseFloat(c.getString(4)));
            computers.add(computer);
            c.moveToNext();
        }
        ComputerAdapter computerAdapter = new ComputerAdapter(this, R.layout.list_item, computers);
        ListView listador = findViewById(R.id.listador);
        // adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listaStr);
        listador.setAdapter(computerAdapter);


    }

    public Cursor listUser() {
        DBManager dbManager = new DBManager(this);
        dbManager.open();
        dbManager.fetch();
        return dbManager.fetch();
    }

}