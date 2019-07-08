package com.example.nutplant.feature.manage.detailBintang;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.nutplant.feature.manage.history.HistoryActivity;
import com.example.nutplant.model.DataPlant;
import com.example.nutplant.model.ResponseShowDetailPlant;
import com.example.nutplant.model.weatherModel.ResponseWeather;
import com.example.nutplant.utils.SessionManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutplant.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailBintangActivity extends AppCompatActivity implements DetailBintangContract.View{

    @BindView(R.id.selectPlant2)
    TextView selectedPlant2;
    @BindView(R.id.selectedSpecies2)
    TextView selectedSpecies2;
    @BindView(R.id.selectedLocation2)
    TextView selectedLocation2;
    @BindView(R.id.selectedArea2)
    TextView selectedArea2;
    @BindView(R.id.selectedAge)
    TextView selectedAge;
    @BindView(R.id.weatherLastUpdate2)
    TextView weatherLastUpdate2;
    @BindView(R.id.weatherHumidity)
    TextView weatherHumidity;
    @BindView(R.id.weatherPressure)
    TextView weatherPressure;
    @BindView(R.id.weatherWind)
    TextView weatherWind;
    @BindView(R.id.weatherFeelsLike)
    TextView weatherFeelsLike;
    @BindView(R.id.weatherVis)
    TextView weatherVis;
    @BindView(R.id.weatherUv)
    TextView weatherUv;
    @BindView(R.id.weatherPrec)
    TextView weatherPrec;
    @BindView(R.id.weatherImg2)
    ImageView weatherImg2;
    @BindView(R.id.weatherLocation2)
    TextView weatherLocation2;
    @BindView(R.id.weatherCondition2)
    TextView weatherCondition2;
    @BindView(R.id.currentSoilMoisture2)
    TextView currentSoilMoisture2;
    @BindView(R.id.currentTemperature2)
    TextView currentTemperature2;
    @BindView(R.id.currentHumidity2)
    TextView currentHumidity2;
    @BindView(R.id.volume2)
    TextView volume2;
    DetailBintangContract.Presenter presenter;
    ProgressDialog dialog;
    SessionManager sessionManager;

    DataPlant plant;
    String umur;

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getDetailPlants(sessionManager.getToken(), plant.getId());
        presenter.getWeatherForecast(sessionManager.getToken(), plant.getLokasiLahan());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_bintang);
        ButterKnife.bind(this);

        plant = getIntent().getParcelableExtra("plant");
        umur = getIntent().getStringExtra("umur");

        presenter = new DetailBintangPresenter(this);
        sessionManager = new SessionManager(this);

//        Date date = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE-dd-MMMM-yyyy");
//        String[] tanggal = dateFormat.format(date).split("-");
//
//        textView2.setText(tanggal[1]);
//        textView4.setText(tanggal[2]);
//        textView.setText(tanggal[0]);
//        txtTahun.setText(tanggal[3]);
//
//        selectedArea.setText("Area of field "+(String.valueOf(plant.getLuasLahan()))+ "m x m");
//        selectedPlant.setText(plant.getNamaTanaman());
//        selectedSpecies.setText("Species "+ plant.getSpesies());
//        selectedAge.setText("Plant Age "+umur+ " Days");

    }


    @Override
    public void showLoading(boolean show) {
//        if (show) dialog.show();
//        else dialog.cancel(); //or u can use dismiss
    }

    @Override
    public void getdetailplant(ResponseShowDetailPlant plants, String message) {
        selectedPlant2.setText(plant.getNamaTanaman());
        selectedSpecies2.setText(": "+ plants.getData().getSpesies());
        selectedArea2.setText(": "+ String.valueOf(plants.getData().getLuasLahan())+" m2");
        selectedLocation2.setText(": " + plants.getData().getLokasiLahan());
        selectedAge.setText(": "+ umur + " Days");
        int position = plants.getData().getPerangkat().getData().size() - 1;
        currentSoilMoisture2.setText(String.valueOf(plants.getData().getPerangkat().getData().get(position).getKelembabanTanah()) + "%RH");
        currentTemperature2.setText(String.valueOf(plants.getData().getPerangkat().getData().get(position).getSuhuUdara())+"C");
        currentHumidity2.setText(String.valueOf(plants.getData().getPerangkat().getData().get(position).getKelembabanUdara())+"%RH");
        volume2.setText(String.valueOf(plants.getData().getPerangkat().getData().get(position).getKondisi())+" ml");
    }

    @Override
    public void getweatherforecast(ResponseWeather weatherforecast, String message) {
        if (weatherforecast!=null) {
            weatherLastUpdate2.setText("Last Updated "+weatherforecast.getData().getCurrent().getLastUpdated());
            weatherLocation2.setText(plant.getLokasiLahan() + "," + weatherforecast.getData().getLocation().getCountry());
            weatherCondition2.setText(weatherforecast.getData().getCurrent().getCondition().getText());
            weatherHumidity.setText(": " + String.valueOf(weatherforecast.getData().getCurrent().getHumidity()) + " C");
            weatherPressure.setText(": " + String.valueOf(weatherforecast.getData().getCurrent().getPressureMb())+ " mBar");
            weatherWind.setText(": "+ String.valueOf(weatherforecast.getData().getCurrent().getWindMph())+ " Km/h");
            weatherFeelsLike.setText(": " + String.valueOf(weatherforecast.getData().getCurrent().getFeelslikeC()) +" C");
            weatherVis.setText(": " + String.valueOf(weatherforecast.getData().getCurrent().getVisKm()) + " Km");
            weatherUv.setText(": "+ String.valueOf(weatherforecast.getData().getCurrent().getUv()));
            weatherPrec.setText(String.valueOf(": " + weatherforecast.getData().getForecast().getForecastday().get(0).getDay().getTotalprecipMm()) +" mm");
        }else Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @OnClick(R.id.imageView6)
    public void onViewClicked() {
        Intent intent = new Intent(this, HistoryActivity.class);
        intent.putExtra("plant", plant);
        startActivity(intent);
    }


}
