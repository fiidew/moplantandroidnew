package com.example.nutplant.service;

import android.database.Observable;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserInterface {

    @POST("login")
    @FormUrlEncoded
    Call<String> loginUser(@Field("email") String email,
                         @Field("password") String password);
}
