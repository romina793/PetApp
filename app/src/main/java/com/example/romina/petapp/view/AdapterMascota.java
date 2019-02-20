package com.example.romina.petapp.view;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.romina.petapp.R;
import com.example.romina.petapp.model.pojo.Mascota;

import java.util.ArrayList;
import java.util.List;

public class AdapterMascota extends RecyclerView.Adapter {

    private List<Mascota> listaDeMascotas;
    private ListenerAdapterMascota listenerAdapterMascota;


    public AdapterMascota() {
        listaDeMascotas = new ArrayList<>();
    }

    public void setListaDeMascotas(List<Mascota> listaDeMascotas ) {
        this.listaDeMascotas = listaDeMascotas;
        this.listenerAdapterMascota = listenerAdapterMascota;
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCelda = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda_mascota,parent,false);
        ViewHolderMascota viewHolderMascota = new ViewHolderMascota(viewCelda);
        return viewHolderMascota;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderMascota viewHolderMascota = (ViewHolderMascota) holder;
        viewHolderMascota.loadMascota(listaDeMascotas.get(position));
    }

    @Override
    public int getItemCount() {
        return listaDeMascotas.size();
    }


    private class ViewHolderMascota extends RecyclerView.ViewHolder{

        private TextView textViewNombreMascota;
        private Mascota mascota;

        public ViewHolderMascota( final View itemView) {
            super(itemView);
            textViewNombreMascota = itemView.findViewById(R.id.celda_nombreMascota);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listenerAdapterMascota = (ListenerAdapterMascota) itemView.getContext();
                    listenerAdapterMascota.informarSeleccion(mascota);

                }
            });
        }

        public void loadMascota(Mascota unaMascota){
            this.mascota = unaMascota;
            textViewNombreMascota.setText(mascota.getName());
        }
    }

    public interface ListenerAdapterMascota{
        public void informarSeleccion(Mascota mascota);
    }

}
