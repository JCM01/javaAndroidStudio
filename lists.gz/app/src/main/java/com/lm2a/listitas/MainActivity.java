package com.lm2a.listitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> frutas = new ArrayList<>();
        frutas.add("Manzana");
        frutas.add("Banana");
        frutas.add("Mandarina");
        frutas.add("Tomate");
        frutas.add("Melon");
        frutas.add("Limon");
        frutas.add("Kiwi");
        frutas.add("Sandia");

        ListView listador = findViewById(R.id.listador);

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, frutas);

        listador.setAdapter(adaptador);
    }
}