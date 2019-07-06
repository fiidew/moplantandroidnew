package com.example.nutplant.feature.manage.detailBintang;

import android.util.Log;

import com.example.nutplant.feature.manage.detailplant.DetailPlantContract;
import com.example.nutplant.model.ResponseShowDetailPlant;
import com.example.nutplant.model.weatherModel.ResponseWeather;
import com.example.nutplant.service.ApiClient;
import com.example.nutplant.service.PlantService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailBintangPresenter implements DetailBintangContract.Presenter {
    private PlantService service;
    private DetailBintangContract.View view;

    public DetailBintangPresenter(DetailBintangContract.View view) {
        this.view = view;
        service = ApiClient.getClient().create(PlantService.class);
    }

    @Override
    public void getDetailPlants(String token, String id) {
        view.showLoading(true);
        Call<ResponseShowDetailPlant> readdetailplants = service.getdetailplants (token,id);
        readdetailplants.enqueue(new Callback<ResponseShowDetailPlant>() {
            @Override
            public void onResponse(Call<ResponseShowDetailPlant> call, Response<ResponseShowDetailPlant> response) {
                view.showLoading(false);
                if (response.code() == 200){
                    if(response.body().getStatus())
                        view.getdetailplant(response.body(),"Succes");
                    else
                        view.getdetailplant (null, response.body().getMessage());//samain kayak fungsi dicontract
                }else {
                    view.getdetailplant(null, response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseShowDetailPlant> call, Throwable t) {
                view.showLoading(false);
                view.getdetailplant(null, t.getMessage());
                call.cancel();
                t.printStackTrace();
            }
        });
    }

    @Override
    public void getWeatherForecast(String token, String city) {
        view.showLoading(true);
        Call<ResponseWeather> readweather = service.getweatherforecast (token,city);
        readweather.enqueue(new Callback<ResponseWeather>() {
            @Override
            public void onResponse(Call<ResponseWeather> call, Response<ResponseWeather> response) {
                view.showLoading(false);
                if (response.code() == 200){
                    if(response.body().getStatus()){
                        view.getweatherforecast(response.body(),"");
                        Log.e("detail", "onResponse: " + response.message());
                    }
                    else
                        view.getweatherforecast (null, response.body().getMessage());//samain kayak fungsi dicontract
                }else {
                    Log.e("detail", "onResponse: " + response.message());
                    view.getweatherforecast(null, response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseWeather> call, Throwable t) {
                view.showLoading(false);
                Log.e("error", "onFailure: " + t.getMessage(), t);
//                view.getweatherforecast(null, t.getMessage());
                call.cancel();
                t.printStackTrace();
            }
        });
    }
}
