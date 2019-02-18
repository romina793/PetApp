package com.example.romina.petapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.romina.petapp.R;
import com.example.romina.petapp.controller.MascotaController;
import com.example.romina.petapp.model.pojo.ConteinerMascota;
import com.example.romina.petapp.utils.ResultListener;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterMascota adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerMascota);
        adapter = new AdapterMascota();

        MascotaController mascotaController = new MascotaController();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mascotaController.traerMascotas(new ResultListener<ConteinerMascota>() {
            @Override
            public void finish(ConteinerMascota conteinerMascota) {
                adapter.setListaDeMascotas(conteinerMascota.getResults());
            }
        });
    }
}
