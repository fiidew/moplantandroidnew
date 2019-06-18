package com.example.nutplant.feature.auth.register;

import com.example.nutplant.model.ResponseRegister;
import com.example.nutplant.model.User;
import com.example.nutplant.service.ApiClient;
import com.example.nutplant.service.AuthService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements RegisterContract.Presenter {
    private AuthService service;
    private RegisterContract.View view;

    public RegisterPresenter(RegisterContract.View view) {
        this.view = view;
        service = ApiClient.getClient().create(AuthService.class);
    }

    @Override
    public void register(String nama, String password, String alamat, String telfon, String username) {
        view.showLoading(true);
        Call<ResponseRegister> register = service.register(nama, password, alamat, telfon, username, "2");
        register.enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                view.showLoading(false);
                if (response.code() == 200) {
                    if (response.body().getStatus())
                        view.register(true, "Register success");
                    else
                        view.register(false, response.body().getMessage());
                } else {
                    view.register(false, "Register failed" + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                view.showLoading(false);
                view.register(false, t.getMessage());
                call.cancel();
                t.printStackTrace();
            }
        });

    }
}
