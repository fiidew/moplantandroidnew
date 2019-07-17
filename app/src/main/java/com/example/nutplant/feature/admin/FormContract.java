package com.example.nutplant.feature.admin;

public class FormContract {

    interface View{
        void addTipe (boolean isSucces, String message);
        void showLoading(boolean show);
    }

    //disamain kayak postman
    interface Presenter{
        void addTipe(String token, String tipe, Integer nitrogen, Integer phosporusVL, Integer phosporusL, Integer phosporusM, Integer potassiumVL, Integer potassiumL, Integer potassiumM);
    }
}
