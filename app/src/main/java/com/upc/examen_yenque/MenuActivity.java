package com.upc.examen_yenque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MenuActivity extends AppCompatActivity {

    FloatingActionButton btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        
        asignarReferencias();
    }

    private void asignarReferencias() {

        btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(v->{
            Intent intent = new Intent(MenuActivity.this,MainActivity.class);
            startActivity(intent);
        });
    }
}