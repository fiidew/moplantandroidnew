package com.example.nutplant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nutplant.feature.nutrisi.NutritionActivity;
import com.example.nutplant.model.DataPlant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.pupukpage)
    CardView pupukpage;
    private ArrayList<DataPlant> plants;

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
    @BindView(R.id.txtTahun)
    TextView txtTahun;

    DataPlant plant;
    String umur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        plant = getIntent().getParcelableExtra("plant");
        umur = getIntent().getStringExtra("umur");

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE-dd-MMMM-yyyy");
        String[] tanggal = dateFormat.format(date).split("-");

        textView2.setText(tanggal[1]);
        textView4.setText(tanggal[2]);
        textView.setText(tanggal[0]);
        txtTahun.setText(tanggal[3]);

        selectedArea.setText("Area of field " + (String.valueOf(plant.getLuasLahan())) + "m x m");
        selectedPlant.setText(plant.getNamaTanaman());
        selectedSpecies.setText("Species " + plant.getSpesies());
        selectedAge.setText("Plant Age " + umur + " Days");

    }

    @OnClick(R.id.pupukpage)
    public void onViewClicked() {
        startActivity(new Intent(this, NutritionActivity.class));
    }
}
