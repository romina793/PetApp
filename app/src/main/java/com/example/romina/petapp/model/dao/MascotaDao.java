package com.example.romina.petapp.model.dao;

import com.example.romina.petapp.model.pojo.ConteinerMascota;
import com.example.romina.petapp.utils.ResultListener;
import com.example.romina.petapp.utils.SwaggerApiKey;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MascotaDao extends MascotaRetrofit{



    //Defino la urlBase
    private static final String BASE_URL = "https://pokeapi.co/api/v2/";
    //Atributo Service, que me va a permitir hacer las llamadas definidas
    private MascotaService mascotaService;

    public MascotaDao() {
        super(BASE_URL);
        mascotaService = retrofit.create(MascotaService.class);
    }


    public void traerMascotas(final ResultListener<ConteinerMascota> listenerDelControler){
        mascotaService.getMascotas().enqueue(new Callback<ConteinerMascota>() {
            @Override
            public void onResponse(Call<ConteinerMascota> call, Response<ConteinerMascota> response) {
                listenerDelControler.finish(response.body());
            }

            @Override
            public void onFailure(Call<ConteinerMascota> call, Throwable t) {
                System.out.println("Ha ocurrido un error AL TRAER LAS MASCOTAS");
            }
        });
    }
}
