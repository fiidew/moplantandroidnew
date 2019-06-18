package com.example.nutplant.service;

import com.example.nutplant.model.ResponseLogin;
import com.example.nutplant.model.ResponseRegister;
import com.example.nutplant.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthService {
    @FormUrlEncoded
    @POST(ApiURL.LOGIN)
    Call<ResponseLogin> login(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST(ApiURL.REGISTER)
    Call<ResponseRegister> register(@Field("nama") String nama,
                                    @Field("password") String password,
                                    @Field("alamat") String alamat,
                                    @Field("telp") String telfon,
                                    @Field("username") String username,
                                    @Field("role") String role
    );
}

