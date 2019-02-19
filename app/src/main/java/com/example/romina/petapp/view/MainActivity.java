package com.example.romina.petapp.view;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.romina.petapp.R;
import com.example.romina.petapp.controller.MascotaController;
import com.example.romina.petapp.model.pojo.ContainerMascota;
import com.example.romina.petapp.model.pojo.Mascota;
import com.example.romina.petapp.utils.ResultListener;

public class MainActivity extends AppCompatActivity implements AdapterMascota.ListenerAdapterMascota{

    private RecyclerView recyclerView;
    private AdapterMascota adapter;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;

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
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
                mascotaController.traerMascotas(new ResultListener<ContainerMascota>() {
                    @Override
                    public void finish(ContainerMascota containerMascota) {
                        adapter.setListaDeMascotas(containerMascota.getResults());
                    }
                });
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
}
