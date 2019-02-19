package com.example.romina.petapp.controller;

import com.example.romina.petapp.model.dao.MascotaDao;
import com.example.romina.petapp.model.pojo.ContainerMascota;
import com.example.romina.petapp.utils.ResultListener;

public class MascotaController {

    public void traerMascotas(final ResultListener<ContainerMascota> listenerDelView) {
        MascotaDao mascotaDao = new MascotaDao();
        mascotaDao.traerMascotas(new ResultListener<ContainerMascota>() {
            @Override
            public void finish(ContainerMascota result) {
                listenerDelView.finish(result);
            }
        });
    }
}
