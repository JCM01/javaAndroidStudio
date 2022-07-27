package com.example.dia1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        String nombre  = b.getString("nombre");
        int edad = b.getInt("edad");

        TextView res = findViewById(R.id.resultado);

        String r = null;

        if(edad > 18){
            r = nombre + " eres mayor de edad";
        }else{
            r = nombre + " eres menor de edad";
        }
        res.setText(r);
        Button boton = findViewById(R.id.b_volver);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}