package com.example.nutplant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.nutplant.feature.manage.ManageActivity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.planticon)
    ImageView planticon;
    @BindView(R.id.side2)
    LinearLayout side2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.planticon)
    public void onViewClicked() {
        startActivity(new Intent(this, ManageActivity.class));
    }
}
