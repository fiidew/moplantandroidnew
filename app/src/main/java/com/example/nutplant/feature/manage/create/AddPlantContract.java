package com.example.nutplant.feature.manage.create;

public class AddPlantContract {
    interface View{
        void create (boolean isSucces, String message);
        void showLoading(boolean show);
    }

    interface Presenter{
        void create(String token, String namaTanaman, Double luasLahan, String lokasiLahan, String spesies, String tanggal);
    }
}

