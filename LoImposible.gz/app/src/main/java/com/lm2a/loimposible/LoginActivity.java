package com.lm2a.loimposible;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    public static final String NAME = "nombre";
    public static final String PWD = "pwd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences prefs = getSharedPreferences(
                "com.lm2a.loimposible", Context.MODE_PRIVATE);
        String name = prefs.getString(NAME, "");

        EditText nombre = findViewById(R.id.et_name);
        nombre.setText(name);

        EditText pwd = findViewById(R.id.et_pwd);
        Button enviar = findViewById(R.id.b_enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = nombre.getText().toString();
                String p = pwd.getText().toString();

                Intent i = new Intent(LoginActivity.this, AuthActivity.class);
                Bundle b = new Bundle();
                b.putString(NAME, n);
                b.putString(PWD, p);

                i.putExtras(b);

                startActivity(i);
            }
        });
    }
}