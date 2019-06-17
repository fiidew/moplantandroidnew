package com.example.nutplant.feature.auth.register;

import com.example.nutplant.model.User;
import com.example.nutplant.service.ApiClient;
import com.example.nutplant.service.AuthService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements RegisterContract.Presenter{
    private AuthService service;
    private RegisterContract.View view;

    public RegisterPresenter(RegisterContract.View view){
        this.view = view;
        service = ApiClient.getClient().create(AuthService.class);
    }

    @Override
    public void register(String nama, String email, String password) {
        view.showLoading(true);
        Call<User> register = service.register (nama, email, password);
        register.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                view.showLoading(false);
                if (response.code() == 200){
                    view.register(true, "Register success");
                }else {
                    view.register(false, "Register failed" +response.message());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                view.showLoading(false);
                view.register(false, t.getMessage());
                call.cancel();
                t.printStackTrace();
            }
        });

    }
}
