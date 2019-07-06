package com.example.nutplant.model.weatherModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataWeatherForecast {
    @SerializedName("forecastday")
    @Expose
    private List<DataWeatherForecastDay> forecastday = null;
    public List<DataWeatherForecastDay> getForecastday() {
        return forecastday;
    }
    public void setForecastday(List<DataWeatherForecastDay> forecastday) {
        this. forecastday = forecastday;
    }
}
