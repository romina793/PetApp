package com.example.romina.petapp.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContainerMascota {

   private List<Mascota> results;


    public List<Mascota> getResults() {
        return results;
    }

    public void setResults(List<Mascota> results) {
        this.results = results;
    }
}
