package com.example.nutplant.feature.manage;

import com.example.nutplant.feature.auth.register.RegisterContract;
import com.example.nutplant.model.DataPlant;
import com.example.nutplant.model.Plant;
import com.example.nutplant.model.ResponseShowplant;
import com.example.nutplant.model.User;
import com.example.nutplant.service.ApiClient;
import com.example.nutplant.service.AuthService;
import com.example.nutplant.service.PlantService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManagePresenter implements ManageContract.Presenter {
    private PlantService service;
    private ManageContract.View view;

    public ManagePresenter(ManageContract.View view) {
        this.view = view;
        service = ApiClient.getClient().create(PlantService.class);
    }

    @Override
    public void getPlants(String token) {
        view.showLoading(true);
        Call<ResponseShowplant> readplants = service.readplants (token);
        readplants.enqueue(new Callback<ResponseShowplant>() {
            @Override
            public void onResponse(Call<ResponseShowplant> call, Response<ResponseShowplant> response) {
                view.showLoading(false);
                if (response.code() == 200){
                    if(response.body().getStatus())
                        view.read (response.body().getData(),"");
                    else
                        view.read (null, response.body().getMessage());//samain kayak fungsi dicontract
                }else {
                    view.read(null, response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseShowplant> call, Throwable t) {
                view.showLoading(false);
                view.read(null, t.getMessage());
                call.cancel();
                t.printStackTrace();
            }
        });
    }
}
