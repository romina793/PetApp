package com.example.romina.petapp.model.dao;

        import com.example.romina.petapp.model.pojo.ContainerMascota;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Headers;

public interface MascotaService {


    @GET("pet/findByStatus")
    //Cada Call va a recibir un resultado del tipo especificado entre <>
    @Headers("Content-Type: application/json")
    Call<ContainerMascota> getMascotas();
}
