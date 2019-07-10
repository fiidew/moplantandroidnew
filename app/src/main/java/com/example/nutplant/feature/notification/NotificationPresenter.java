package com.example.nutplant.feature.notification;

import android.widget.Toast;

import com.example.nutplant.model.ResponseUpdate;
import com.example.nutplant.service.ApiClient;
import com.example.nutplant.service.PlantService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationPresenter implements NotificationContract.Presenter {

    NotificationContract.View view;
    PlantService service;

    public NotificationPresenter(NotificationContract.View view) {
        this.view = view;
        service = ApiClient.getClient().create(PlantService.class);
    }

    @Override
    public void updateNotification(String token, String id, Integer status) {
        view.showDialog(true);
        Call<ResponseUpdate> updateNotification = service.updateNotification(token, id, status);
        updateNotification.enqueue(new Callback<ResponseUpdate>() {
            @Override
            public void onResponse(Call<ResponseUpdate> call, Response<ResponseUpdate> response) {
                view.showDialog(false);
                if (response.code()==200){
                    view.isUpdateNotification(true, "Berhasil Update Status");
                }else view.isUpdateNotification(false, response.message());
            }

            @Override
            public void onFailure(Call<ResponseUpdate> call, Throwable t) {
                view.showDialog(false);
                t.printStackTrace();
                call.cancel();
                view.isUpdateNotification(false,t.getMessage());
            }
        });
    }
}
