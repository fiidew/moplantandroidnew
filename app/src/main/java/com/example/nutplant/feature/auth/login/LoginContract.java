package com.example.nutplant.feature.auth.login;

public class LoginContract {
    interface View{
        void showLoading(boolean show);
        void login(boolean isSuccess, String meessages);
    }

    interface Presenter{
        void login(String email, String password);
    }
}
