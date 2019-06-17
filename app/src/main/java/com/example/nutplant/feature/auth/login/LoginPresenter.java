package com.example.nutplant.feature.auth.login;

import com.example.nutplant.model.User;
import com.example.nutplant.service.ApiClient;
import com.example.nutplant.service.AuthService;
import com.example.nutplant.service.UserInterface;
import com.example.nutplant.feature.auth.login.LoginContract.Presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private AuthService service;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        service = ApiClient.getClient().create(AuthService.class);
    }

    @Override
    public void login(String email, String password) {
        view.showLoading(true);
        Call<User> login = service.login(email, password);
        login.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                view.showLoading(false);
                if (response.code() == 200){
                    view.login(true, "Login Success");
                }else{
                    view.login(false, "Login failed : " + response.message());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                view.showLoading(false);
                call.cancel();
            }
        });
    }
}
