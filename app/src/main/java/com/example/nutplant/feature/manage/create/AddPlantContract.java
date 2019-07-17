package com.example.nutplant.feature.manage.create;

import com.example.nutplant.model.DataTipe;

import java.util.ArrayList;

public class AddPlantContract {
    interface View{
        void create (boolean isSucces, String message);
        void showSpecies(ArrayList<DataTipe> tipes, String message);
        void showLoading(boolean show);
    }

    interface Presenter{
        void getSpecies(String token);
        void create(String token, String namaTanaman, Double luasLahan, String lokasiLahan, String spesies, String tanggal);
    }
}

