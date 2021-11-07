package com.upc.examen_yenque;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorPersonalizado extends RecyclerView.Adapter<AdaptadorPersonalizado.MiHolder> {
    @NonNull
    @Override
    public AdaptadorPersonalizado.MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizado.MiHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MiHolder extends RecyclerView.ViewHolder {
        public MiHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
