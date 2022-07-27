package com.lm2a.loimposible;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        String n = b.getString(LoginActivity.NAME);
        String p = b.getString(LoginActivity.PWD);

        TextView tvMensaje = findViewById(R.id.tv_mensaje);
        Button bVolver = findViewById(R.id.b_volver);

        if(checkLogin(n, p)){
            persistUser(n);
            tvMensaje.setText("Login OK");
        }else{
            tvMensaje.setText("Login KO");
        }

        bVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AuthActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

    }

    private boolean checkLogin(String n, String p){
        if(n.equals("lm2a")&&(p.equals("clave"))){
            return true;
        }else{
            return false;
        }
    }

    private void persistUser(String user){
        SharedPreferences prefs = getSharedPreferences(
                "com.lm2a.loimposible", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(LoginActivity.NAME, user);
        editor.commit();
    }
}