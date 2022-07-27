package com.example.computerbbdd;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button botonRegister = findViewById(R.id.b_b_register);
        EditText marca = findViewById(R.id.et_marca);
        EditText cpu = findViewById(R.id.et_cpu);
        EditText os = findViewById(R.id.et_os);
        EditText precio = findViewById(R.id.et_precio);

        botonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor mCursor;
                DBManager dbManager = new DBManager(RegisterActivity.this).open();
                dbManager.insert(marca.getText().toString(), cpu.getText().toString(), os.getText().toString(), precio.getText().toString());
                Cursor cursor = dbManager.fetch();


                while (cursor.moveToNext()) {

                    String data3 = cursor.getString((cursor.getColumnIndex(DatabaseHelper.MARCA)));
                    String data4 = cursor.getString((cursor.getColumnIndex(DatabaseHelper.CPU)));
                    String data5 = cursor.getString((cursor.getColumnIndex(DatabaseHelper.OS)));
                    String data6 = cursor.getString((cursor.getColumnIndex(DatabaseHelper.PRECIO)));
                    Log.e("Resultado: NOMBRE: ", data3 + " password: " + data4 + " Email: " + data5+"os: " + data6+"precio");
                }
                Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(i);

                Toast.makeText(RegisterActivity.this,"Ordenador registrado", Toast.LENGTH_LONG).show();

            }
        });
    }
}