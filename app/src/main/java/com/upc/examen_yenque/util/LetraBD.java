package com.upc.examen_yenque.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LetraBD extends SQLiteOpenHelper {


    public LetraBD(Context context) {
        super(context, Constantes.NOMBRE_BD, null, Constantes.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + Constantes.NOMBRE_TABLA +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        "serie TEXT NOT NULL,"+
                        "correlativo INTEGER NOT NULL,"+
                        "ruc TEXT NOT NULL,"+
                        "razonSocial TEXT NOT NULL,"+
                        "numUnico TEXT NOT NULL,"+
                        "nimporte DECIMAL NOT NULL,"+
                        "fecEmision TEXT NOT NULL,"+
                        "fecVencimiento TEXT NOT NULL,"+
                        "comentario TEXT NOT NULL);";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
