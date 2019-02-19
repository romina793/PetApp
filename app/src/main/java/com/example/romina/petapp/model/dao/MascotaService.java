package com.example.romina.petapp.model.dao;

import com.example.romina.petapp.model.pojo.ContainerMascota;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MascotaService {


    @GET("pokemon")
        //Cada Call va a recibir un resultado del tipo especificado entre <>
    Call<ContainerMascota> getMascotas();

}
