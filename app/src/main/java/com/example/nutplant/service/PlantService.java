package com.example.nutplant.service;

import com.example.nutplant.model.Plant;
import com.example.nutplant.model.ResponseAddplant;
import com.example.nutplant.model.ResponseHistory;
import com.example.nutplant.model.ResponseNotification;
import com.example.nutplant.model.ResponseShowDetailPlant;
import com.example.nutplant.model.ResponseShowplant;
import com.example.nutplant.model.ResponseTipe;
import com.example.nutplant.model.ResponseTipes;
import com.example.nutplant.model.ResponseUpdate;
import com.example.nutplant.model.User;
import com.example.nutplant.model.weatherModel.ResponseWeather;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PlantService {
    //@FormUrlEncoded BUAT POST
    @GET(ApiURL.GETPLANTS)
    Call<ResponseShowplant> readplants (@Header("Authorization") String token);

    @GET(ApiURL.GETDETAILPLANTS)
    Call<ResponseShowDetailPlant> getdetailplants (@Header("Authorization") String token,
                                                   @Path("id") String id);

    @GET(ApiURL.GETWEATHERFORECAST)
    Call<ResponseWeather> getweatherforecast (@Header("Authorization") String token,
                                              @Path("city") String city);

    @POST(ApiURL.GETDETAILHISTORY)
    Call<ResponseHistory> getdetailhistory (@Header("Authorization") String token,
                                            @Field("idTanaman") String idTanaman,
                                            @Field("start") String start,
                                            @Field("end") String end);

    @GET(ApiURL.GETNOTIFICATION)
    Call<ResponseNotification> getNotifications (@Header("Authorization") String token);

    @FormUrlEncoded
    @POST(ApiURL.UPDATENOTIFICATION)
    Call<ResponseUpdate> updateNotification(@Header("Authorization") String token,
                                            @Field("id") String idTanaman,
                                            @Field("status") Integer status);


    //kalo methodnya post trus ada field
    @FormUrlEncoded
    @POST(ApiURL.CREATE)
    Call<ResponseAddplant> createplants(
            @Header("Authorization") String token,
            @Field("namaTanaman") String namaTanaman,
            @Field("luasLahan") Double luasLahan,
            @Field("lokasiLahan") String lokasiLahan,
            @Field("spesies") String spesies,
            @Field("tanggal") String tanggal
    );

    @FormUrlEncoded
    @POST(ApiURL.CREATETIPE)
    Call<ResponseTipe> createtype(
            @Header("Authorization") String token,
            @Field("tipe") String tipe,
            @Field("nitrogen") Integer nitrogen,
            @Field("phosporusVL") Integer phosporusVL,
            @Field("phosporusL") Integer phosporusL,
            @Field("phosporusM") Integer phosporusM,
            @Field("potassiumVL") Integer potassiumVL,
            @Field("potassiumL") Integer potassiumL,
            @Field("potassiumM") Integer potassiumM
    );

    @GET(ApiURL.GETALLTYPE)
    Call<ResponseTipes> getalltype(
            @Header("Authorization") String token
    );

    @GET(ApiURL.GETTYPE)
    Call<ResponseTipes> gettype(
            @Header("Authorization") String token,
            @Path("id") String id
    );
}
