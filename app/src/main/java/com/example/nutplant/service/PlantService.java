package com.example.nutplant.service;

import com.example.nutplant.model.Plant;
import com.example.nutplant.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PlantService {
    //@FormUrlEncoded BUAT POST
    @GET(ApiURL.GETPLANTS)
    Call<ArrayList<Plant>> readplants ();

    @FormUrlEncoded
    @POST(ApiURL.CREATE)
    Call<Plant> createplants(
            @Field("nama") String nama,
            @Field("species") String species,
            @Field("date") String date,
            @Field("area") Float area
    );
}