package com.example.dia0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Intent i = getIntent();
        Bundle b= i.getExtras();
        String nombre=b.getString("nombre");
        String email=b.getString("email");
    }
}