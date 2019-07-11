package com.example.nutplant.feature.manage.detailplant;

import android.util.Log;
import android.widget.Toast;

import com.example.nutplant.model.ResponseShowDetailPlant;
import com.example.nutplant.model.ResponseUserUpdate;
import com.example.nutplant.model.weatherModel.ResponseWeather;
import com.example.nutplant.service.ApiClient;
import com.example.nutplant.service.AuthService;
import com.example.nutplant.service.PlantService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPlantPresenter implements DetailPlantContract.Presenter{
    private PlantService service;
    private AuthService authService;
    private DetailPlantContract.View view;

    public DetailPlantPresenter(DetailPlantContract.View view) {
        this.view = view;
        service = ApiClient.getClient().create(PlantService.class);
        authService = ApiClient.getClient().create(AuthService.class);
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
                        view.getdetailplant(response.body(),"");
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
                call.cancel();
                t.printStackTrace();
            }
        });
    }

    @Override
    public void updateToken(String token, String id, String fcmtoken) {
        Call<ResponseUserUpdate> updateToken = authService.updateUser(token,id,fcmtoken);
        updateToken.enqueue(new Callback<ResponseUserUpdate>() {
            @Override
            public void onResponse(Call<ResponseUserUpdate> call, Response<ResponseUserUpdate> response) {
                if (response.code() == 200){
                    ResponseUserUpdate data = response.body();
                    if (data.getStatus()) {
                        view.isSuccessUpdateToken(true, "Update Token");
                    }else
                        view.isSuccessUpdateToken(false, response.body().getMessage());
                }else{
                    view.isSuccessUpdateToken(false, "Update Token Failed : " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseUserUpdate> call, Throwable t) {
                t.printStackTrace();
                call.cancel();
                view.isSuccessUpdateToken(false, "Update Token failed : " + t.getMessage());
            }
        });
    }
}
