package com.example.nutplant.feature.history;

import android.widget.Toast;

import com.example.nutplant.model.DataPlant;
import com.example.nutplant.model.ResponseNotification;
import com.example.nutplant.service.ApiClient;
import com.example.nutplant.service.PlantService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryPresenter implements HistoryContract.Presenter{

    PlantService service;
    HistoryContract.View view;

    public HistoryPresenter(HistoryContract.View view) {
        this.view = view;
        service = ApiClient.getClient().create(PlantService.class);
    }

    @Override
    public void getNotifications(String token) {
        view.showLoading(true);
        Call<ResponseNotification> getNotifications = service.getNotifications(token);
        getNotifications.enqueue(new Callback<ResponseNotification>() {
            @Override
            public void onResponse(Call<ResponseNotification> call, Response<ResponseNotification> response) {
                view.showLoading(false);
                if (response.code()==200){
                    view.read(response.body().getData(), response.body().getMessage());
                }else{
                    view.read(null,response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseNotification> call, Throwable t) {
                view.showLoading(false);
                t.printStackTrace();
                call.cancel();
                view.read(null,t.getMessage());
            }
        });
    }
}
