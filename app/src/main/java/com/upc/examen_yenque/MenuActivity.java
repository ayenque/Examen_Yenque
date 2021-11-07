package com.upc.examen_yenque;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.upc.examen_yenque.entidades.Letra;
import com.upc.examen_yenque.modelo.DAOLetra;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuActivity extends AppCompatActivity {


    FloatingActionButton btnAgregar;
    RecyclerView recyclerLetras;

    DAOLetra daoLetra = new DAOLetra(this);
    List<Letra> listaLetras = new ArrayList<>();
    AdaptadorPersonalizado adaptadorPersonalizado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        asignarReferencias();
        mostrarLetras();
        daoLetra.abrirBD();
        mostrarLetras();
        

    }

    private void mostrarLetras() {
        listaLetras = daoLetra.listarLetras();
        adaptadorPersonalizado = new AdaptadorPersonalizado(this,listaLetras);
        recyclerLetras.setAdapter(adaptadorPersonalizado);
        recyclerLetras.setLayoutManager(new LinearLayoutManager(MenuActivity.this));

    }

    private void asignarReferencias() {
        recyclerLetras = findViewById(R.id.recyclerLetras);

        btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(v->{
            Intent intent = new Intent(MenuActivity.this,MainActivity.class);
            startActivity(intent);
        });
    }



}