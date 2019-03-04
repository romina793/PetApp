package com.example.romina.petapp.model.dao;

        import com.example.romina.petapp.model.pojo.ContainerMascota;
        import com.example.romina.petapp.model.pojo.Mascota;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Headers;
        import retrofit2.http.Path;
        import retrofit2.http.Query;

public interface MascotaService {


    @GET("pet/findByStatus")
    //Cada Call va a recibir un resultado del tipo especificado entre <>
    @Headers("Content-Type: application/json")
    Call<ContainerMascota> getMascotas( @Query ("available") String status);


    // todo ----> agregar al pedido     @Headers("Content-Type: application/json")
    @GET ("pet/{id]")
    Call <Mascota> getMascotas (String data, @Path("id") String idMascota );



}
