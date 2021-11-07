package com.upc.examen_yenque;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.upc.examen_yenque.entidades.Letra;
import com.upc.examen_yenque.modelo.DAOLetra;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText txtSerie, nCorrelativo, nRUC, txtRazonSocial, txtNumeroUnico;
    EditText dateFecEmision, dateFecVencimiento, txtComentario;
    Button btnBoton;
    TextView txtTitulo;

    int id;

    Letra letra;
    DAOLetra daoLetra = new DAOLetra(this);

    boolean tipoRegistro = true; //true = Grabar || false = Editar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asignarReferencias();
        verificarActualizar();
    }

    private void verificarActualizar() {
        if(getIntent().hasExtra("id")){
            tipoRegistro = false;
            String serie = getIntent().getStringExtra("serie");
            int correlativo = Integer.parseInt(getIntent().getStringExtra("correlativo"));
            String ruc = getIntent().getStringExtra("ruc");
            String razonSocial = getIntent().getStringExtra("razonSocial");
            String numUnico = getIntent().getStringExtra("numUnico");
            String fecEmision = getIntent().getStringExtra("fecEmision");
            String fecVencimiento = getIntent().getStringExtra("fecVencimiento");
            String comentario = getIntent().getStringExtra("comentario");

            id = Integer.parseInt(getIntent().getStringExtra("id")) ;

            txtSerie.setText(serie);
            nCorrelativo.setText(correlativo + "");
            nRUC.setText(ruc + "");
            txtRazonSocial.setText(razonSocial);
            txtNumeroUnico.setText(numUnico);
            dateFecEmision.setText(fecEmision);
            dateFecVencimiento.setText(fecVencimiento);
            txtComentario.setText(comentario);

            txtTitulo.setText(R.string.editar);
            btnBoton.setText(R.string.btn_editar);


        }

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
        txtTitulo = findViewById(R.id.txtTitulo);

        btnBoton.setOnClickListener(v->{
            if(validarCampos()){
                capturarDatos();
                daoLetra.abrirBD();
                String respuesta = "";
                if(tipoRegistro){
                    respuesta = daoLetra.registrarLetra(letra);
                }
                else{
                    respuesta = daoLetra.modificarLetra(letra);
                }
                mostrarMensaje(tipoRegistro, respuesta);
            }
        });
    }


    private void capturarDatos(){
        String serie = txtSerie.getText().toString();
        int correlativo = Integer.parseInt(nCorrelativo.getText().toString());
        String ruc = nRUC.getText().toString();
        String razonSocial = txtRazonSocial.getText().toString();
        String numUnico = txtNumeroUnico.getText().toString();
        String fecEmision = dateFecEmision.getText().toString();
        String fecVencimiento = dateFecVencimiento.getText().toString();
        String comentario = txtComentario.getText().toString();

       if(tipoRegistro){
           letra = new Letra(serie,correlativo,ruc,razonSocial,numUnico,fecEmision,fecVencimiento,comentario);
       }
       else{
           letra = new Letra(id,serie,correlativo,ruc,razonSocial,numUnico,fecEmision,fecVencimiento,comentario);
       }

    }

    private void mostrarMensaje(boolean tipoRegistro, String mensaje){
        AlertDialog.Builder ventana = new AlertDialog.Builder(MainActivity.this);

        if(tipoRegistro){
            ventana.setTitle(R.string.titulo);
        }
        else{
            ventana.setTitle(R.string.editar);
        }

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

    private boolean validarCampos(){
        boolean flag = true;

        String serie = txtSerie.getText().toString();
        String correlativo = nCorrelativo.getText().toString();
        String ruc = nRUC.getText().toString();
        String razonSocial = txtRazonSocial.getText().toString();
        String numUnico = txtNumeroUnico.getText().toString();
        String fecEmision = dateFecEmision.getText().toString();
        String fecVencimiento = dateFecVencimiento.getText().toString();
        String comentario = txtComentario.getText().toString();

        if (correlativo.equals("")){
            nCorrelativo.setError("Dato Obligatorio");
            flag = false;
        }

        if (ruc.equals("")){
            nRUC.setError("El RUC es obligatorio");
            flag = false;
        }else{
            if (ruc.length()<8){
                nRUC.setError("El RUC debe tener 8 caracteres como mínimo");
                flag = false;
            }
        }

        if (serie.equals("")){
            txtSerie.setError("Ingrese la serie");
            flag = false;
        }
        if (razonSocial.equals("")){
            txtRazonSocial.setError("Ingrese la razón social");
            flag = false;
        }
        if (numUnico.equals("")){
            txtNumeroUnico.setError("Ingrese el Número Único");
            flag = false;
        }
        if (fecEmision.equals("")){
            dateFecEmision.setError("Ingrese la fecha de Emisión");
            flag = false;
        }
        if (fecVencimiento.equals("")){
            dateFecVencimiento.setError("Ingrese la fecha de Vencimiento");
            flag = false;
        }

        return flag;
    }


}