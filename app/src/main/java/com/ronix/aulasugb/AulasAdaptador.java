package com.ronix.aulasugb;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AulasAdaptador extends RecyclerView.Adapter<AulasAdaptador.AulasViewHolder> {
    private List<Aulas> items;

    public static class AulasViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView descripcion;

        public AulasViewHolder(View v) {
            super(v);
            imagen = v.findViewById(R.id.imagen);
            nombre = v.findViewById(R.id.nombre);
            descripcion = v.findViewById(R.id.visitas);
        }
    }

    public AulasAdaptador(List<Aulas> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public AulasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_aulas, viewGroup, false);
        return new AulasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AulasViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.descripcion.setText(items.get(i).getDescripcion());
    }
}