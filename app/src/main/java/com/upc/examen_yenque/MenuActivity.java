package com.upc.examen_yenque;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.upc.examen_yenque.entidades.Letra;
import com.upc.examen_yenque.modelo.DAOLetra;

import java.time.Instant;
import java.util.Date;

public class MenuActivity extends AppCompatActivity {


    FloatingActionButton btnAgregar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(v->{
            Intent intent = new Intent(MenuActivity.this,MainActivity.class);
            startActivity(intent);
        });
        

    }




}