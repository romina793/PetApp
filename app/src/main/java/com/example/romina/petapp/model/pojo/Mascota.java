package com.example.romina.petapp.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Mascota   {
/*
    @SerializedName("name") private String nombreMascota;
    @SerializedName("photoUrls") private Integer imagenMascota*/;

    private String name;
    private String url;

    public Mascota() {
    }

   /* public Mascota(String nombreMascota, Integer imagenMascota) {
        this.nombreMascota = nombreMascota;
        this.imagenMascota = imagenMascota;

    }*/

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
/*

    public String getNombreMascota() {
        return nombreMascota;
    }

    public Integer getImagenMascota() {
        return imagenMascota;
    }


    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public void setImagenMascota(Integer imagenMascota) {
        this.imagenMascota = imagenMascota;
    }
*/


}
