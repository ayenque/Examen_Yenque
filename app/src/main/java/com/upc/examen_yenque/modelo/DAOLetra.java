package com.upc.examen_yenque.modelo;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.upc.examen_yenque.entidades.Letra;
import com.upc.examen_yenque.util.Constantes;
import com.upc.examen_yenque.util.LetraBD;

import java.util.ArrayList;
import java.util.List;

public class DAOLetra {

    private LetraBD letraBD;
    private SQLiteDatabase db;
    private final Context context;

    public DAOLetra(@Nullable Context context) {
        this.letraBD = new LetraBD(context);
        this.context = context;
    }

    public void abrirBD()

    {

        db= letraBD.getWritableDatabase();
    }

    public  String registrarLetra(Letra letra){

        String mensaje = "";

        try{
            ContentValues valores = new ContentValues();
            valores.put("serie", letra.getSerie());
            valores.put("correlativo", letra.getCorrelativo());
            valores.put("ruc", letra.getRuc());
            valores.put("razonSocial",letra.getRazonSocial());
            valores.put("numUnico",letra.getNumUnico());
            valores.put("fecEmision",letra.getFecEmision());
            valores.put("fecVencimiento",letra.getFecVencimiento());
            valores.put("comentario",letra.getComentario());

            long resultado = db.insert(Constantes.NOMBRE_TABLA,null, valores);

            if (resultado == -1) {
                mensaje = "Error al insertar";
            }
            else {
                mensaje =  "Se registró correctamente";
            }

        }catch (Exception e){
            Log.d("==>", e.getMessage());
            mensaje = "Error al insertar";
        }
        return  mensaje;
    }

    public List<Letra> listarLetras()
    {
        List<Letra> listaLetras = new ArrayList<>();  //creamos un array de libros

        try{
            @SuppressLint("Recycle") Cursor c =  db.rawQuery("SELECT * FROM "+ Constantes.NOMBRE_TABLA, null);

            while (c.moveToNext()){
                listaLetras.add(new Letra(
                        c.getInt(0),
                        c.getString(1),
                        c.getInt(2),
                        c.getInt(3),
                        c.getString(4),
                        c.getString(5),
                        c.getString(6),
                        c.getString(7),
                        c.getString(8)
                ));
            }


        }catch (Exception e){
            Log.d("==>", e.getMessage());
        }

        return  listaLetras;
    }

}
