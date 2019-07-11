package com.example.nutplant.feature.manage.detailplant;

import com.example.nutplant.model.ResponseShowDetailPlant;
import com.example.nutplant.model.weatherModel.ResponseWeather;

public class DetailPlantContract {
    interface View{
        void showLoading(boolean show);
        void getdetailplant (ResponseShowDetailPlant plants, String message);
        void getweatherforecast(ResponseWeather weatherforecast, String message);
        void isSuccessUpdateToken (boolean isSuccess, String meessages);
    }

    interface Presenter{
        void getDetailPlants(String token, String id);
        void getWeatherForecast(String token, String city);
        void updateToken(String token, String id, String fcmtoken);
    }
}
