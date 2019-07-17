package com.example.nutplant.feature.admin;

import com.example.nutplant.model.ResponseRegister;
import com.example.nutplant.model.ResponseTipe;
import com.example.nutplant.service.ApiClient;
import com.example.nutplant.service.AuthService;
import com.example.nutplant.service.PlantService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormPresenter implements FormContract.Presenter {
    private PlantService service;
    private FormContract.View view;

    public FormPresenter(FormContract.View view) {
        this.view = view;
        service = ApiClient.getClient().create(PlantService.class);

    }

    @Override
    public void addTipe(String token, String tipe, Integer nitrogen, Integer phosporusVL, Integer phosporusL, Integer phosporusM, Integer potassiumVL, Integer potassiumL, Integer potassiumM) {
        view.showLoading(true);
        Call<ResponseTipe> addTipe = service.createtype(token, tipe, nitrogen, phosporusVL, phosporusL, phosporusM, potassiumVL, potassiumL, potassiumM);
        addTipe.enqueue(new Callback<ResponseTipe>() {
            @Override
            public void onResponse(Call<ResponseTipe> call, Response<ResponseTipe> response) {
                view.showLoading(false);
                if (response.code() == 200) {
                    if (response.body().getStatus())
                        view.addTipe(true, "Add type success");
                    else
                        view.addTipe(false, response.body().getMessage());
                } else {
                    view.addTipe(false, "Add type failed" + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseTipe> call, Throwable t) {
                view.showLoading(false);
                view.addTipe(false, t.getMessage());
                call.cancel();
                t.printStackTrace();
            }
        });

    }
}