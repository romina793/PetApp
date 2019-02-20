package com.example.romina.petapp.view;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.JsonReader;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.romina.petapp.R;
import com.example.romina.petapp.controller.MascotaController;
import com.example.romina.petapp.model.dao.MascotaDao;
import com.example.romina.petapp.model.dao.MascotaService;
import com.example.romina.petapp.model.pojo.ContainerMascota;
import com.example.romina.petapp.model.pojo.Mascota;
import com.example.romina.petapp.utils.ResultListener;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements FragmenteDelDetalle.ListenerFragmentMascota, AdapterMascota.ListenerAdapterMascota{

    private RecyclerView recyclerView;
    private AdapterMascota adapter;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO configurar el progress bar

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(10);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(0);
        recyclerView = findViewById(R.id.recyclerMascota);

        adapter = new AdapterMascota();

        MascotaController mascotaController = new MascotaController();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        mascotaController.traerMascotas(new ResultListener<ContainerMascota>() {
            @Override
            public void finish(ContainerMascota containerMascota) {
                adapter.setListaDeMascotas(containerMascota.getResults());
            }
        });

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Esto se ejecuta cada vez que se realiza el gesto
                adapter = new AdapterMascota();

                MascotaController mascotaController = new MascotaController();

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));

                try {
                mascotaController.traerMascotas(new ResultListener<ContainerMascota>() {
                    @Override
                    public void finish( ContainerMascota containerMascota ) {
                        adapter.setListaDeMascotas(containerMascota.getResults());
                    }
                });
                Toast.makeText(MainActivity.this, "La lista se muestra correctamente", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                }
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    @Override
    public void informarSeleccion(Mascota mascota) {
        Intent unIntent = new Intent(this, DetalleActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("unaMascota", mascota);
        unIntent.putExtras(bundle);
        startActivity(unIntent);
    }


    @Override
    public void notificar(Mascota mascota) {

    }

}
