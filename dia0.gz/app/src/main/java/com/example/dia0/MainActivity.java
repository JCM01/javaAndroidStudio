package com.example.dia0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.b_button);
        TextView textView = findViewById(R.id.tv_label);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText nombre = findViewById(R.id.et_nombre);
                EditText email = findViewById(R.id.et_email);
                Log.d("El nombre es: ", nombre.getText().toString());
                Log.d("El email es: ", email.getText().toString());
                Intent i = new Intent(MainActivity.this, SegundaActivity.class);
                startActivity(i);
 /*               textView.setText("Hola mundo cruel!");
                textView.setTextColor(getResources().getColor(R.color.design_default_color_primary));
*/            }

        });
    }
}