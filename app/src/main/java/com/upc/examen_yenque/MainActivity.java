package com.upc.examen_yenque;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

import com.upc.examen_yenque.entidades.Letra;
import com.upc.examen_yenque.modelo.DAOLetra;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText txtSerie, nCorrelativo, nRUC, txtRazonSocial, txtNumeroUnico;
    EditText dateFecEmision, dateFecVencimiento, txtComentario;
    Button btnBoton;

    Letra letra;
    DAOLetra daoLetra = new DAOLetra(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asignarReferencias();
    }

    private void asignarReferencias() {
        txtSerie = findViewById(R.id.txtSerie);
        nCorrelativo = findViewById(R.id.nCorrelativo);
        nRUC = findViewById(R.id.nRUC);
        txtRazonSocial = findViewById(R.id.txtRazonSocial);
        txtNumeroUnico = findViewById(R.id.txtNumeroUnico);
        dateFecEmision = findViewById(R.id.dateFecEmision);
        dateFecVencimiento = findViewById(R.id.dateFecVencimiento);
        txtComentario = findViewById(R.id.txtComentario);
        btnBoton = findViewById(R.id.btnBoton);

        btnBoton.setOnClickListener(v->{
            capturarDatos();
            daoLetra.abrirBD();
            String respuesta = "";
            respuesta = daoLetra.registrarLetra(letra);
            mostrarMensaje(respuesta);

        });
    }


    private void capturarDatos(){
        String serie = txtSerie.getText().toString();
        int correlativo = Integer.parseInt(nCorrelativo.getText().toString());
        int ruc = Integer.parseInt(nRUC.getText().toString());
        String razonSocial = txtRazonSocial.getText().toString();
        String numUnico = txtNumeroUnico.getText().toString();
        String fecEmision = dateFecEmision.getText().toString();
        String fecVencimiento = dateFecVencimiento.getText().toString();
        String comentario = txtComentario.getText().toString();

        letra = new Letra(serie,correlativo,ruc,razonSocial,numUnico,fecEmision,fecVencimiento,comentario);
    }

    private void mostrarMensaje(String mensaje){
        AlertDialog.Builder ventana = new AlertDialog.Builder(MainActivity.this);
        ventana.setTitle("Mensaje informativo");
        ventana.setMessage(mensaje);
        ventana.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
        ventana.create().show();
    }
}