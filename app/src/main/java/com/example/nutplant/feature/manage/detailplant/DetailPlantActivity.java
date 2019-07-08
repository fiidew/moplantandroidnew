package com.example.nutplant.feature.manage.detailplant;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.nutplant.R;
import com.example.nutplant.feature.manage.detailBintang.DetailBintangActivity;
import com.example.nutplant.feature.nutrisi.NutritionActivity;
import com.example.nutplant.model.DataPerangkat;
import com.example.nutplant.model.DataPlant;
import com.example.nutplant.model.ResponseShowDetailPlant;
import com.example.nutplant.model.weatherModel.ResponseWeather;
import com.example.nutplant.utils.SessionManager;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailPlantActivity extends AppCompatActivity implements DetailPlantContract.View {

    DetailPlantContract.Presenter presenter;
    ProgressDialog dialog;
    DataPerangkat perangkat;
    SessionManager sessionManager;

    DataPlant plant;
    String umur;
    @BindView(R.id.selectedPlant)
    TextView selectedPlant;
    @BindView(R.id.selectedSpecies)
    TextView selectedSpecies;
    @BindView(R.id.selectedArea)
    TextView selectedArea;
    @BindView(R.id.selectedLocation)
    TextView selectedLocation;
    @BindView(R.id.dayCurrent)
    TextView dayCurrent;
    @BindView(R.id.tanggalCurrent)
    TextView tanggalCurrent;
    @BindView(R.id.monthCurrent)
    TextView monthCurrent;
    @BindView(R.id.yearCurrent)
    TextView yearCurrent;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.textView8)
    TextView textView8;
    @BindView(R.id.weatherImg)
    ImageView weatherImg;
    @BindView(R.id.weatherCondition)
    TextView weatherCondition;
    @BindView(R.id.weatherLocation)
    TextView weatherLocation;
    @BindView(R.id.imageView5)
    ImageView imageView5;
    @BindView(R.id.textView7)
    TextView textView7;
    @BindView(R.id.currentSoilMoisture)
    TextView currentSoilMoisture;
    @BindView(R.id.currentPrecipitation)
    TextView currentPrecipitation;
    @BindView(R.id.currentPh)
    TextView currentPh;
    @BindView(R.id.imageView6)
    ImageView imageView6;
    @BindView(R.id.textView11)
    TextView textView11;
    @BindView(R.id.textView10)
    TextView textView10;
    @BindView(R.id.waterPage)
    ConstraintLayout waterPage;
    @BindView(R.id.imageView12)
    ImageView imageView12;
    @BindView(R.id.textView13)
    TextView textView13;
    @BindView(R.id.textView14)
    TextView textView14;
    @BindView(R.id.fertilizerPage)
    ConstraintLayout fertilizerPage;
    @BindView(R.id.textView15)
    TextView textView15;

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getDetailPlants(sessionManager.getToken(), plant.getId());
        presenter.getWeatherForecast(sessionManager.getToken(), plant.getLokasiLahan());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_plant);
        ButterKnife.bind(this);

        plant = getIntent().getParcelableExtra("plant");

        presenter = new DetailPlantPresenter(this);
        sessionManager = new SessionManager(this);

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE-dd-MMMM-yyyy");
        String[] tanggal = dateFormat.format(date).split("-");

        tanggalCurrent.setText(tanggal[1]);
        monthCurrent.setText(tanggal[2]);
        dayCurrent.setText(tanggal[0]);
        yearCurrent.setText(tanggal[3]);

        selectedArea.setText("Area of field " + (String.valueOf(plant.getLuasLahan())) + "m x m");
        selectedPlant.setText(plant.getNamaTanaman());
        selectedSpecies.setText("Species " + plant.getSpesies());
    }


    @Override
    public void showLoading(boolean show) {
//        if (show) dialog.show();
//        else dialog.cancel(); //or u can use dismiss
    }

    @Override
    public void getdetailplant(ResponseShowDetailPlant plants, String message) {
        selectedPlant.setText(plant.getNamaTanaman());
        selectedSpecies.setText("Spesies : " + plants.getData().getSpesies());
        selectedArea.setText("Luas Area : " + String.valueOf(plants.getData().getLuasLahan()) + " m2");
        selectedLocation.setText("Lokasi Lahan : " + plants.getData().getLokasiLahan());
        int position = plants.getData().getPerangkat().getData().size() - 1;
        perangkat = plants.getData().getPerangkat().getData().get(position);
        currentSoilMoisture.setText(String.valueOf(plants.getData().getPerangkat().getData().get(position).getKelembabanTanah()) + "%RH");
        currentPh.setText(String.valueOf(plants.getData().getPerangkat().getData().get(position).getPh()));

        if (String.valueOf(plants.getData().getPerangkat().getData().get(position).getKondisi()) == String.valueOf("700")) {
            textView8.setText("Need Water " + String.valueOf(plants.getData().getPerangkat().getData().get(position).getKondisi()));
        } else
            textView8.setText(" Normal ");
    }

    @Override
    public void getweatherforecast(ResponseWeather weatherforecast, String message) {
//        weatherLastUpdate.setText(weatherforecast.getData().getCurrent().getLastUpdated());
        if (weatherforecast != null) {
            weatherLocation.setText(plant.getLokasiLahan() + "," + weatherforecast.getData().getLocation().getCountry());
            currentPrecipitation.setText(String.valueOf(weatherforecast.getData().getForecast().getForecastday().get(0).getDay().getTotalprecipMm()) + "mm");
            weatherCondition.setText(weatherforecast.getData().getCurrent().getCondition().getText());
        } else
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//        weatherImg.setImageResource(weatherforecast.getData().getCurrent().getCondition().getIcon());
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @OnClick({R.id.waterPage, R.id.fertilizerPage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.waterPage:
                Intent intent = new Intent(this, DetailBintangActivity.class);
                intent.putExtra("plant", plant);
                startActivity(intent);
                break;
            case R.id.fertilizerPage:
                Intent fertilize = new Intent(this, NutritionActivity.class);
                fertilize.putExtra("perangkat", perangkat);
                startActivity(fertilize);
                break;
        }
    }
}
