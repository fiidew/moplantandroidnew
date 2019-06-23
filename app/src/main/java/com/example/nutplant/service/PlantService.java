package com.example.nutplant.service;

import com.example.nutplant.model.Plant;
import com.example.nutplant.model.ResponseAddplant;
import com.example.nutplant.model.ResponseShowplant;
import com.example.nutplant.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface PlantService {
    //@FormUrlEncoded BUAT POST
    @GET(ApiURL.GETPLANTS)
    Call<ResponseShowplant> readplants (@Header("Authorization") String token);

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
}
