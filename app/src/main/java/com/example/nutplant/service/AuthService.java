package com.example.nutplant.service;
import com.example.nutplant.model.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthService {
    @FormUrlEncoded
    @POST(ApiURL.LOGIN)
    Call<User> login (
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST(ApiURL.REGISTER)
    Call<User> register(
            @Field("nama") String name,
            @Field("email") String email,
            @Field("password") String password
    );
}

