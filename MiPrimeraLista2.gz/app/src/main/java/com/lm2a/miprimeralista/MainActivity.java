package com.lm2a.miprimeralista;

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
        //getSupportActionBar().hide();
        lista = new ArrayList<>();
        lista.add("Manzana");
        lista.add("Limon");
        lista.add("Anana");
        lista.add("Durazno");
        lista.add("Kiwi");
        lista.add("Naranja");
        lista.add("Banana");
        lista.add("Pera");
        lista.add("Tomate");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);

        ListView listView = findViewById(R.id.listado);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Has pulsado sobre "+lista.get(i)+" long: "+l+" el i: "+i, Toast.LENGTH_LONG).show();
            }
        });

    }
}