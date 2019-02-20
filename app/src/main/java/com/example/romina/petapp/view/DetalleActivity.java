package com.example.romina.petapp.view;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.romina.petapp.R;
import com.example.romina.petapp.model.pojo.Mascota;

public class DetalleActivity extends AppCompatActivity implements FragmenteDelDetalle.ListenerFragmentMascota {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);


        //Recibo el intent
        Intent unIntent = getIntent();
        //Recibo el bundle
        Bundle unBundle = unIntent.getExtras();

        FragmenteDelDetalle fragmenteDelDetalle = new FragmenteDelDetalle();

        //Seteo al fragment el bundle
        fragmenteDelDetalle.setArguments(unBundle);

        setearFragment(fragmenteDelDetalle);

    }


    public void setearFragment(Fragment fragmentDetalle) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedor_detalle, fragmentDetalle).commit();
    }

    @Override
    public void notificar(Mascota mascota) {

    }
}
