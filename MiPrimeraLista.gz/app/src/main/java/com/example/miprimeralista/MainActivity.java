package com.example.miprimeralista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> lista;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ejemplo
        lista = new ArrayList<>();
        lista.add("Ford");
        lista.add("Toyota");
        lista.add("Hyundai");
        lista.add("Citroen");
        lista.add("Daewoo");
        lista.add("Mercedes");
        lista.add("Tesla");
        lista.add("Peugeot");
        lista.add("Range Rover");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);

        ListView listView = findViewById(R.id.listado);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Has pulsado sobre " + lista.get(i) + " long: " + l + " el i: " + i, Toast.LENGTH_LONG).show();
            }
        });
    }
}