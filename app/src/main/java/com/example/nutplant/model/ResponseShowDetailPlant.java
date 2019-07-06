package com.example.nutplant.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseShowDetailPlant {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private DataPlant data;
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
    public DataPlant getData() {
        return data;
    }
    public void setData(DataPlant data) {
        this. data = data;
    }
}
