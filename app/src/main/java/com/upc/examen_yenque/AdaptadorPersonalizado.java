package com.upc.examen_yenque;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.upc.examen_yenque.entidades.Letra;
import com.upc.examen_yenque.modelo.DAOLetra;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorPersonalizado extends RecyclerView.Adapter<AdaptadorPersonalizado.MiHolder> {

    private Context context;
    private List<Letra> listaLetras = new ArrayList<>();


    public AdaptadorPersonalizado(Context context,List<Letra> listaLetras) {
        this.context = context;
        this.listaLetras = listaLetras;
    }

    @NonNull
    @Override
    public AdaptadorPersonalizado.MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vista = inflater.inflate(R.layout.fila, parent,false);
        return new MiHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizado.MiHolder holder, int position) {
        holder.tvSerieLetra.setText(listaLetras.get(position).getSerie()+"");
        holder.tvCorrelativoLetra.setText(listaLetras.get(position).getCorrelativo()+"");
        holder.tvrazonSocialLetra.setText(listaLetras.get(position).getRazonSocial()+"");
        holder.tvnumUnicoLetra.setText(listaLetras.get(position).getNumUnico()+"");
        holder.tvfecEmisionLetra.setText(listaLetras.get(position).getFecEmision()+"");
        holder.tvfecVencimientoLetra.setText(listaLetras.get(position).getFecVencimiento()+"");

        holder.btnEditar.setOnClickListener(v -> {
            Intent intent = new Intent(context,MainActivity.class);
            intent.putExtra("id",listaLetras.get(position).getId()+"");
            intent.putExtra("serie",listaLetras.get(position).getSerie()+"");
            intent.putExtra("correlativo",listaLetras.get(position).getCorrelativo()+"");
            intent.putExtra("ruc",listaLetras.get(position).getRuc()+"");
            intent.putExtra("razonSocial",listaLetras.get(position).getRazonSocial()+"");
            intent.putExtra("numUnico",listaLetras.get(position).getNumUnico()+"");
            intent.putExtra("fecEmision",listaLetras.get(position).getFecEmision()+"");
            intent.putExtra("fecVencimiento",listaLetras.get(position).getFecVencimiento()+"");
            intent.putExtra("comentario",listaLetras.get(position).getComentario()+"");
            context.startActivity(intent);
        });

        holder.btnEliminar.setOnClickListener(v->{
            AlertDialog.Builder ventana = new AlertDialog.Builder(context);
            ventana.setTitle("Confirmar");
            ventana.setMessage("¿Desea eliminar la Letra?");
            ventana.setNegativeButton("Cancelar",null);

            ventana.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    DAOLetra daoLetra = new DAOLetra(context);
                    daoLetra.abrirBD();
                    String respuesta = daoLetra.eliminarLetra(listaLetras.get(position).getId());

                    AlertDialog.Builder ventana_delete = new AlertDialog.Builder(context);
                    ventana_delete.setTitle("Eliminar Letra");
                    ventana_delete.setMessage(respuesta);
                    ventana_delete.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(context, MenuActivity.class);
                            context.startActivity(intent);
                        }
                    });
                    ventana_delete.create().show();

                }
            });
            ventana.create().show();


        });




    }

    @Override
    public int getItemCount() {
        return listaLetras.size();
    }

    public class MiHolder extends RecyclerView.ViewHolder {

        TextView tvSerieLetra, tvCorrelativoLetra,tvrazonSocialLetra,tvnumUnicoLetra;
        TextView tvfecEmisionLetra,tvfecVencimientoLetra;
        ImageButton btnEditar,btnEliminar;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            tvSerieLetra =itemView.findViewById(R.id.tvSerieLetra);
            tvCorrelativoLetra =itemView.findViewById(R.id.tvCorrelativoLetra);
            tvrazonSocialLetra =itemView.findViewById(R.id.tvrazonSocialLetra);
            tvnumUnicoLetra =itemView.findViewById(R.id.tvnumUnicoLetra);
            tvfecEmisionLetra =itemView.findViewById(R.id.tvfecEmisionLetra);
            tvfecVencimientoLetra =itemView.findViewById(R.id.tvfecVencimientoLetra);
            btnEditar =itemView.findViewById(R.id.btnEditar);
            btnEliminar =itemView.findViewById(R.id.btnEliminar);

        }
    }


}
