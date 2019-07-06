package com.example.nutplant.model.weatherModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataWeatherForecastDay {
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("date_epoch")
    @Expose
    private Integer dateEpoch;
    @SerializedName("day")
    @Expose
    private DataWeatherDay day;
    @SerializedName("astro")
    @Expose
    private DataWeatherAstro astro;
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this. date = date;
    }
    public Integer getDateEpoch() {
        return dateEpoch;
    }
    public void setDateEpoch(Integer dateEpoch) {
        this. dateEpoch = dateEpoch;
    }
    public DataWeatherDay getDay() {
        return day;
    }
    public void setDay(DataWeatherDay day) {
        this. day = day;
    }
    public DataWeatherAstro getAstro() {
        return astro;
    }
    public void setAstro(DataWeatherAstro astro) {
        this. astro = astro;
    }
}
