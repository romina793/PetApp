package com.example.romina.petapp.view;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.romina.petapp.R;
import com.example.romina.petapp.model.pojo.Mascota;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmenteDelDetalle extends Fragment implements AdapterMascota.ListenerAdapterMascota{

    private View vistaDelFragment;
    public static final String KEY_NAME = "KEY_NAME";
    private ListenerFragmentMascota listenerFragmentMascota;
    private FloatingActionButton botonMaps;


    public FragmenteDelDetalle() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //Ese context lo trato como ListenerFragmentReceta
        this.listenerFragmentMascota = (ListenerFragmentMascota) context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vistaDelFragment = inflater.inflate(R.layout.fragment_fragmente_del_detalle, container, false);
        Bundle bundle = getArguments();
        Mascota mascota = (Mascota) bundle.getSerializable(KEY_NAME);
        botonMaps = vistaDelFragment.findViewById(R.id.boton_maps);

        botonMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
            }
        });

        //ImageView fragmentDetalle_imageView = vistaDelFragment.findViewById(R.id.fragmentDetalle_imageView);
        //fragmentDetalle_imageView.setImageResource(receta.getImagenReceta());

        return vistaDelFragment;
    }

    @Override
    public void informarSeleccion(Mascota mascota) {
        listenerFragmentMascota.notificar(mascota);

    }


    //Creamos una interface que va a funcionar como listener de este fragment para quien la implemente
    public interface ListenerFragmentMascota{
        //notificar al listener de este fragment y le va a pasar la información
        public void notificar(Mascota mascota);
    }



}
