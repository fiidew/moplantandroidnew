package com.example.nutplant.feature.nutrisi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.nutplant.R;
import com.example.nutplant.feature.history.HistoryActivity;
import com.example.nutplant.model.DataPerangkat;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NutritionActivity extends AppCompatActivity {


    Integer[] status1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    Integer[] status2 = {0, 0, 0, 0, 0, 0, 2, 1, 1, 1, 0};
    Integer[] status3 = {0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 0};
    Integer[] status4 = {1, 0, 1, 1, 0, 0, 2, 2, 2, 2, 1};
    Integer[] status5 = {2, 1, 2, 2, 1, 1, 2, 2, 2, 2, 1};
    Integer[] status6 = {2, 2, 2, 2, 2, 2, 1, 2, 1, 1, 1};
    Integer[] status7 = {2, 2, 2, 2, 2, 2, 1, 2, 1, 1, 1};
    Integer[] status8 = {2, 1, 2, 2, 1, 2, 1, 1, 0, 2, 1};
    Integer[] status9 = {0, 0, 2, 2, 0, 2, 0, 1, 0, 1, 2};
    Integer[] status10 = {0, 1, 2, 2, 0, 2, 0, 0, 1, 0, 2};
    Integer[] status11 = {0, 2, 2, 2, 0, 1, 0, 0, 2, 0, 2};
    Integer[] status12 = {0, 2, 2, 2, 0, 0, 0, 0, 2, 0, 2};
    Integer[] statusInRange = new Integer[12];
    @BindView(R.id.statusNitrogen)
    TextView statusNitrogen;
    @BindView(R.id.statusPhosporus)
    TextView statusPhosporus;
    @BindView(R.id.statusSulphur)
    TextView statusSulphur;
    @BindView(R.id.statusCalcium)
    TextView statusCalcium;
    @BindView(R.id.statusMagnesium)
    TextView statusMagnesium;
    @BindView(R.id.statusIron)
    TextView statusIron;
    @BindView(R.id.statusManganese)
    TextView statusManganese;
    @BindView(R.id.statusBoron)
    TextView statusBoron;
    @BindView(R.id.statusCopper)
    TextView statusCopper;
    @BindView(R.id.statusPotassium)
    TextView statusPotassium;
    @BindView(R.id.statusMolybdenum)
    TextView statusMolybdenum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);
        ButterKnife.bind(this);

        DataPerangkat perangkat = getIntent().getParcelableExtra("perangkat");
        setPhRange(perangkat.getPh());
        statusNitrogen.setBackgroundColor(statusInRange[0] == 0 ? getResources().getColor(R.color.colorFour) : statusInRange[0] == 1 ? getResources().getColor(R.color.colorOne) : getResources().getColor(R.color.colorPrimary));
        statusPhosporus.setBackgroundColor(statusInRange[1] == 0 ? getResources().getColor(R.color.colorFour) : statusInRange[1] == 1 ? getResources().getColor(R.color.colorOne) : getResources().getColor(R.color.colorPrimary));
        statusSulphur.setBackgroundColor(statusInRange[3] == 0 ? getResources().getColor(R.color.colorFour) : statusInRange[3] == 1 ? getResources().getColor(R.color.colorOne) : getResources().getColor(R.color.colorPrimary));
        statusCalcium.setBackgroundColor(statusInRange[4] == 0 ? getResources().getColor(R.color.colorFour) : statusInRange[4] == 1 ? getResources().getColor(R.color.colorOne) : getResources().getColor(R.color.colorPrimary));
        statusMagnesium.setBackgroundColor(statusInRange[5] == 0 ? getResources().getColor(R.color.colorFour) : statusInRange[5] == 1 ? getResources().getColor(R.color.colorOne) : getResources().getColor(R.color.colorPrimary));
        statusIron.setBackgroundColor(statusInRange[6] == 0 ? getResources().getColor(R.color.colorFour) : statusInRange[6] == 1 ? getResources().getColor(R.color.colorOne) : getResources().getColor(R.color.colorPrimary));
        statusManganese.setBackgroundColor(statusInRange[7] == 0 ? getResources().getColor(R.color.colorFour) : statusInRange[7] == 1 ? getResources().getColor(R.color.colorOne) : getResources().getColor(R.color.colorPrimary));
        statusBoron.setBackgroundColor(statusInRange[8] == 0 ? getResources().getColor(R.color.colorFour) : statusInRange[8] == 1 ? getResources().getColor(R.color.colorOne) : getResources().getColor(R.color.colorPrimary));
        statusCopper.setBackgroundColor(statusInRange[9] == 0 ? getResources().getColor(R.color.colorFour) : statusInRange[9] == 1 ? getResources().getColor(R.color.colorOne) : getResources().getColor(R.color.colorPrimary));
        statusPotassium.setBackgroundColor(statusInRange[2] == 0 ? getResources().getColor(R.color.colorFour) : statusInRange[2] == 1 ? getResources().getColor(R.color.colorOne) : getResources().getColor(R.color.colorPrimary));
        statusMolybdenum.setBackgroundColor(statusInRange[10] == 0 ? getResources().getColor(R.color.colorFour) : statusInRange[10] == 1 ? getResources().getColor(R.color.colorOne) : getResources().getColor(R.color.colorPrimary));
    }

    private void setPhRange(Double ph) {
        if (ph >= 4 && ph <= 4.5) statusInRange = status1;
        else if (ph >= 4.5 && ph <= 5.0) statusInRange = status2;
        else if (ph >= 5.0 && ph <= 5.5) statusInRange = status3;
        else if (ph >= 5.5 && ph <= 6.0) statusInRange = status4;
        else if (ph >= 6.0 && ph <= 6.5) statusInRange = status5;
        else if (ph >= 6.5 && ph <= 7.0) statusInRange = status6;
        else if (ph >= 7.0 && ph <= 7.5) statusInRange = status7;
        else if (ph >= 7.5 && ph <= 8.0) statusInRange = status8;
        else if (ph >= 8.0 && ph <= 8.5) statusInRange = status9;
        else if (ph >= 8.5 && ph <= 9.0) statusInRange = status10;
        else if (ph >= 9.0 && ph <= 9.5) statusInRange = status11;
        else if (ph >= 9.5 && ph <= 10.0) statusInRange = status12;
        else statusInRange = status1;
    }

    @OnClick(R.id.historylink)
    public void onViewClicked() {
        startActivity(new Intent(this, HistoryActivity.class));
    }
}
