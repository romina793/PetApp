package com.example.romina.petapp.controller;

import com.example.romina.petapp.model.dao.MascotaDao;
import com.example.romina.petapp.model.pojo.ConteinerMascota;
import com.example.romina.petapp.utils.ResultListener;

public class MascotaController {

    public void traerMascotas(final ResultListener<ConteinerMascota> listenerDelView) {
        MascotaDao mascotaDao = new MascotaDao();
        mascotaDao.traerMascotas(new ResultListener<ConteinerMascota>() {
            @Override
            public void finish(ConteinerMascota result) {
                listenerDelView.finish(result);
            }
        });
    }
}
