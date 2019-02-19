package com.example.romina.petapp.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.romina.petapp.R;
import com.example.romina.petapp.model.pojo.Mascota;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmenteDelDetalle extends Fragment {

    private View vistaDelFragment;
    public static final String KEY_NAME = "KEY_NAME";
    private ListenerFragmentMascota listenerFragmentMascota;


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

        //ImageView fragmentDetalle_imageView = vistaDelFragment.findViewById(R.id.fragmentDetalle_imageView);
        //fragmentDetalle_imageView.setImageResource(receta.getImagenReceta());

        return vistaDelFragment;
    }


    //Creamos una interface que va a funcionar como listener de este fragment para quien la implemente
    public interface ListenerFragmentMascota{
        //notificar al listener de este fragment y le va a pasar la información
        public void notificar ();
    }



}
