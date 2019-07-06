package com.example.nutplant.feature.auth.login;

import android.content.Context;

import com.example.nutplant.model.ResponseLogin;
import com.example.nutplant.model.ResponseUserUpdate;
import com.example.nutplant.service.ApiClient;
import com.example.nutplant.service.AuthService;
import com.example.nutplant.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private AuthService service;
    private SessionManager sessionManager;


    public LoginPresenter(LoginContract.View view, Context context) {
        this.view = view;
        service = ApiClient.getClient().create(AuthService.class);
        sessionManager = new SessionManager(context);
    }

    @Override
    public void login(String username, String password) {
        view.showLoading(true);
        Call<ResponseLogin> login = service.login(username, password);
        login.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                view.showLoading(false);
                if (response.code() == 200){
                    ResponseLogin data = response.body();
                    if (data.getStatus()) {
                        sessionManager.storeLogin(data.getData().getId(), data.getData().getToken());
                        view.login(true, "Login success");
                    }else
                        view.login(false, response.body().getMessage());
                }else{
                    view.login(false, "Login failed : " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                view.showLoading(false);
                call.cancel();
            }
        });
    }


    public void updateToken(String token, String id, String fcmtoken) {
        view.showLoading(true);
        Call<ResponseUserUpdate> login = service.updateUser(token,id,fcmtoken);
        login.enqueue(new Callback<ResponseUserUpdate>() {
            @Override
            public void onResponse(Call<ResponseUserUpdate> call, Response<ResponseUserUpdate> response) {
                view.showLoading(false);
                if (response.code() == 200){
                    ResponseUserUpdate data = response.body();
                    if (data.getStatus()) {
                        view.isSuccessUpdateToken(true, "Login success");
                    }else
                        view.isSuccessUpdateToken(false, response.body().getMessage());
                }else{
                    view.isSuccessUpdateToken(false, "Login failed : " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseUserUpdate> call, Throwable t) {
                view.showLoading(false);
                call.cancel();
                view.isSuccessUpdateToken(false, "Login failed : " + t.getMessage());

            }
        });
    }
}
