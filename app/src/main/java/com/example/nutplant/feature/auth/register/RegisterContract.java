package com.example.nutplant.feature.auth.register;

public class RegisterContract {
    interface View{
        void register (boolean isSucces, String message);
        void showLoading(boolean show);
    }

    interface Presenter{
        void register(String nama, String password, String alamat, String telfon, String username);
    }
}
