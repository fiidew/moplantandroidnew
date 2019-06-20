package com.example.nutplant;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.selectedPlant)
    TextView selectedPlant;
    @BindView(R.id.selectedSpecies)
    TextView selectedSpecies;
    @BindView(R.id.selectedAge)
    TextView selectedAge;
    @BindView(R.id.selectedArea)
    TextView selectedArea;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.textView8)
    TextView textView8;
    @BindView(R.id.planticon)
    ImageView planticon;
    @BindView(R.id.selectedLocation)
    TextView selectedLocation;
    @BindView(R.id.imageView5)
    ImageView imageView5;
    @BindView(R.id.textView7)
    TextView textView7;
    @BindView(R.id.imageView6)
    ImageView imageView6;
    @BindView(R.id.textView11)
    TextView textView11;
    @BindView(R.id.textView10)
    TextView textView10;
    @BindView(R.id.imageView12)
    ImageView imageView12;
    @BindView(R.id.textView13)
    TextView textView13;
    @BindView(R.id.textView14)
    TextView textView14;
    @BindView(R.id.textView15)
    TextView textView15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
    }
}
