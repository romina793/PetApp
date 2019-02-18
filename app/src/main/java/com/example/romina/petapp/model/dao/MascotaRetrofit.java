package com.example.romina.petapp.model.dao;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MascotaRetrofit {

    //Atributo de tipo Retrofit donde se va a almacenar la configuración
    protected Retrofit retrofit;



    //Constructor que recibe la urlBase
    public MascotaRetrofit(String baseUrl) {
        //Cliente HTTP que va a manejar las conexiones a internet
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        //Builder de Retrofit
        Retrofit.Builder builder = new Retrofit.Builder()
                //método para configurar la url base
                .baseUrl(baseUrl)
                //método para configurar la librería para parseo JSON (GSON)
                .addConverterFactory(GsonConverterFactory.create());

        //Construyo el retrofit con la información del builder y el cliente HTTP
        retrofit = builder.client(okHttpClient.build()).build();
    }

}