package com.example.nutplant.feature.auth.nutrisi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nutplant.feature.history.HistoryActivity;
import com.example.nutplant.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NutritionActivity extends AppCompatActivity {

    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.textView9)
    TextView textView9;
    @BindView(R.id.textView7)
    TextView textView7;
    @BindView(R.id.historylink)
    TextView historylink;
    @BindView(R.id.textView196)
    TextView textView196;
    @BindView(R.id.nitrogen)
    TextView nitrogen;
    @BindView(R.id.phosporus)
    TextView phosporus;
    @BindView(R.id.potassium)
    TextView potassium;
    @BindView(R.id.sulphur)
    TextView sulphur;
    @BindView(R.id.calcium)
    TextView calcium;
    @BindView(R.id.magnesium)
    TextView magnesium;
    @BindView(R.id.magnesium2)
    TextView magnesium2;
    @BindView(R.id.magnesium3)
    TextView magnesium3;
    @BindView(R.id.magnesium4)
    TextView magnesium4;
    @BindView(R.id.statusNitrogen)
    TextView statusNitrogen;
    @BindView(R.id.statusNitrogen3)
    TextView statusNitrogen3;
    @BindView(R.id.statusNitrogen4)
    TextView statusNitrogen4;
    @BindView(R.id.statusNitrogen5)
    TextView statusNitrogen5;
    @BindView(R.id.statusNitrogen6)
    TextView statusNitrogen6;
    @BindView(R.id.statusPhosporus)
    TextView statusPhosporus;
    @BindView(R.id.statusSulphur)
    TextView statusSulphur;
    @BindView(R.id.statusCalcium)
    TextView statusCalcium;
    @BindView(R.id.statusCalcium2)
    TextView statusCalcium2;
    @BindView(R.id.statusPotassium)
    TextView statusPotassium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.historylink)
    public void onViewClicked() {
        startActivity(new Intent(this, HistoryActivity.class));
    }
}
