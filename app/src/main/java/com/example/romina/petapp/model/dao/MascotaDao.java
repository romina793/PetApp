package com.example.romina.petapp.model.dao;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.romina.petapp.model.pojo.ContainerMascota;
import com.example.romina.petapp.utils.ResultListener;
import com.example.romina.petapp.view.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;


public class MascotaDao extends MascotaRetrofit{



    //Defino la urlBase
    private static final String BASE_URL = "http://petstore.swagger.io/v2/";
    //Atributo Service, que me va a permitir hacer las llamadas definidas
    private MascotaService mascotaService;
    private ProgressBar progressBar;

    public MascotaDao() {
        super(BASE_URL);
        mascotaService = retrofit.create(MascotaService.class);
    }


    public void traerMascotas(final ResultListener<ContainerMascota> listenerDelControler){
        mascotaService.getMascotas("available").enqueue(new Callback<ContainerMascota>() {
            @Override
            public void onResponse(Call<ContainerMascota> call, Response<ContainerMascota> response) {
                listenerDelControler.finish(response.body());
                System.out.println("Se muestra la lista correctamente");
            }

            @Override
            public void onFailure(Call<ContainerMascota> call, Throwable t) {
                System.out.println("Ha ocurrido un error AL TRAER LAS MASCOTAS");
            }
        });


    }
}
