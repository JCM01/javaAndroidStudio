package com.example.loimposible02;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String NAME = "nombre";
    public static final String AGE = "edad";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences(
                "com.lm2a.loimposible02", Context.MODE_PRIVATE);
        String name = prefs.getString(NAME, "");

        EditText nombre = findViewById(R.id.et_name);
        nombre.setText(name);

        EditText edad = findViewById(R.id.et_edad);
        Button enviar = findViewById(R.id.b_enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = nombre.getText().toString();
                String p = edad.getText().toString();

                Intent i = new Intent(MainActivity.this, SegundaActivity2.class);
                Bundle b = new Bundle();

                b.putString(NAME, n);
                b.putString(AGE, p);

                i.putExtras(b);

                startActivity(i);
            }
        });
    }
}
