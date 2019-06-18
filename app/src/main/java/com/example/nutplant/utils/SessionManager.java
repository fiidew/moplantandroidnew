package com.example.nutplant.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.nutplant.feature.auth.login.LoginActivity;

import java.util.HashMap;

public class SessionManager {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    public static final String KEY_TOKEN = "KEY_TOKEN";
    public static final String KEY_ID = "dev.zero.bengkeldoaibu.utils.KEY_ID";

    private static final String is_login = "login";
    private final String SHARE_NAME = "loginsession";
    private Context context;

    public SessionManager(Context context) {
        this.context = context;
        preferences = this.context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void storeLogin(String id,String token){
        editor.putBoolean(is_login,true);
        editor.putString(KEY_ID, id);
        editor.putString(KEY_TOKEN, token);

        editor.commit();
    }

    public String getIdUser(){
        return preferences.getString(KEY_ID, "");
    }

    public boolean isLogin(){
        return preferences.getBoolean(is_login,false);
    }

    public void logout(){
        editor.clear();
        editor.commit();
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
