package com.example.nutplant.model.weatherModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataWeather {
    @SerializedName("location")
    @Expose
    private DataWeatherLocation location;
    @SerializedName("current")
    @Expose
    private DataWeatherCurrent current;
    @SerializedName("forecast")
    @Expose
    private DataWeatherForecast forecast;
    public DataWeatherLocation getLocation() {
        return location;
    }
    public void setLocation(DataWeatherLocation location) {
        this. location = location;
    }
    public DataWeatherCurrent getCurrent() {
        return current;
    }
    public void setCurrent(DataWeatherCurrent current) {
        this. current = current;
    }
    public DataWeatherForecast getForecast() {
        return forecast;
    }
    public void setForecast(DataWeatherForecast forecast) {
        this. forecast = forecast;
    }
}
