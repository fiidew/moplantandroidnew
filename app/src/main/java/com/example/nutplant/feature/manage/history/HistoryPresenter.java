package com.example.nutplant.feature.manage.history;

import android.util.Log;

import com.example.nutplant.model.ResponseHistory;
import com.example.nutplant.service.ApiClient;
import com.example.nutplant.service.PlantService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryPresenter implements HistoryContract.Presenter {

    private PlantService service;
    private HistoryContract.View view;

    public HistoryPresenter(HistoryContract.View view) {
        this.view = view;
        service = ApiClient.getClient().create(PlantService.class);
    }

    @Override
    public void getdetailhistory(String token, String idTanaman, String start, String end) {
        view.showLoading(true);
        Call<ResponseHistory> getHistory = service.getdetailhistory(token,idTanaman,start, end);
        getHistory.enqueue(new Callback<ResponseHistory>() {
            @Override
            public void onResponse(Call<ResponseHistory> call, Response<ResponseHistory> response) {
                view.showLoading(false);
                if (response.code() == 200){
                    if(response.body().getStatus()){
//                        view.getdetailhistory(response.body().getData().get().getPerangkat().getData(),"");
                        Log.e("detail", "onResponse: " + response.message());
                    }
                    else
                        view.getdetailhistory (null, response.body().getMessage());//samain kayak fungsi dicontract
                }else {
                    Log.e("detail", "onResponse: " + response.message());
                    view.getdetailhistory(null, response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseHistory> call, Throwable t) {
                view.showLoading(false);
                Log.e("error", "onFailure: " + t.getMessage(), t);
//                view.getweatherforecast(null, t.getMessage());
                call.cancel();
                t.printStackTrace();
            }
        });
    }

}
