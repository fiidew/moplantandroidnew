package com.example.nutplant.feature.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.nutplant.Main2Activity;
import com.example.nutplant.R;
import com.example.nutplant.feature.auth.login.LoginActivity;
import com.example.nutplant.feature.manage.ManageActivity;
import com.example.nutplant.utils.SessionManager;

public class SplashScreenActivity extends AppCompatActivity {

    private int waktu_loading=4000;
    private SessionManager sessionManager;
    //4000=4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sessionManager = new SessionManager(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sessionManager.isLogin())
                {
                    Intent login = new Intent (SplashScreenActivity.this, ManageActivity.class);
                    startActivity(login);
                }
                else{
                    Intent home=new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(home);
                }

                //setelah loading maka akan langsung berpindah ke home activity
                finish();

            }
        },waktu_loading);
    }
}
