package com.example.dia1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nombre = findViewById(R.id.et_name);
        EditText edad = findViewById(R.id.et_age);
        Button enviar = findViewById(R.id.b_enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                Bundle b = new Bundle();
                b.putString("nombre", nombre.getText().toString());
                b.putInt("edad",Integer.parseInt(edad.getText().toString()));
                i.putExtras(b);

                startActivity(i);
            }
        });


    }
}