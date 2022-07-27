package com.lm2a.listitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Juan Perez","juan@perez.es"));
        usuarios.add(new Usuario("Juan Perez1","juan1@perez.es"));
        usuarios.add(new Usuario("Juan Perez2","juan2@perez.es"));
        usuarios.add(new Usuario("Juan Perez3","juan3@perez.es"));
        usuarios.add(new Usuario("Juan Perez4","juan4@perez.es"));
        usuarios.add(new Usuario("Juan Perez5","juan5@perez.es"));
        usuarios.add(new Usuario("Juan Perez6","juan6@perez.es"));
        usuarios.add(new Usuario("Juan Perez7","juan7@perez.es"));

        ListView listador = findViewById(R.id.listador);

        UserAdapter userAdapter = new UserAdapter(this, R.layout.list_item, usuarios);

        listador.setAdapter(userAdapter);
        listador.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CustomActivity.this, "tu edad: " + usuarios.get(i), Toast.LENGTH_SHORT).show();
            }
        });


    }
}