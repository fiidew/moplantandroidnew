package com.example.nutplant.model.weatherModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseWeather {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private DataWeather data;
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this. status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this. message = message;
    }
    public DataWeather getData() {
        return data;
    }
    public void setData(DataWeather data) {
        this. data = data;
    }
}
