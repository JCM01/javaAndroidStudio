package com.example.jueves14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mensaje = findViewById(R.id.tv_mensaje);
        Button ver = findViewById(R.id.b_ver);


        Toast toast = Toast.makeText (this, "Buenos dias", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER|Gravity.LEFT, 0, 0);
        toast.show();

        SharedPreferences prefs = getSharedPreferences(
                "com.example.jueves14", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("nombre", "Mario");
        editor.commit();

        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = prefs.getString("nombre", "");
                mensaje.setText(nombre);

            }
        });


    }
}