package com.example.nutplant.feature.manage;

import com.example.nutplant.feature.auth.register.RegisterContract;
import com.example.nutplant.model.Plant;
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
    public void getPlants() {
        view.showLoading(true);
        Call<ArrayList<Plant>> readplants = service.readplants ();
        readplants.enqueue(new Callback<ArrayList<Plant>>() {
            @Override
            public void onResponse(Call<ArrayList<Plant>> call, Response<ArrayList<Plant>> response) {
                view.showLoading(false);
                if (response.code() == 200){
                    view.read(response.body());//samain kayak fungsi dicontract
                }else {
                    view.read(null);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Plant>> call, Throwable t) {
                view.showLoading(false);
                view.read(null);
                call.cancel();
                t.printStackTrace();
            }
        });
    }
}
