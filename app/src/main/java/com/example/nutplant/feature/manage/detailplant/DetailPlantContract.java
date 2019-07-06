package com.example.nutplant.feature.manage.detailplant;

import com.example.nutplant.model.ResponseShowDetailPlant;
import com.example.nutplant.model.weatherModel.ResponseWeather;

public class DetailPlantContract {
    interface View{
        void showLoading(boolean show);
        void getdetailplant (ResponseShowDetailPlant plants, String message);
        void getweatherforecast(ResponseWeather weatherforecast, String message);
    }

    interface Presenter{
        void getDetailPlants(String token, String id);
        void getWeatherForecast(String token, String city);
        //ketika ngambil data tanaman perlu difilter apa
    }
}
