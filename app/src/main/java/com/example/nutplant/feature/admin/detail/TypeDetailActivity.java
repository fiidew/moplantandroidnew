package com.example.nutplant.feature.admin.detail;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nutplant.R;
import com.example.nutplant.model.DataTipe;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TypeDetailActivity extends AppCompatActivity {

    @BindView(R.id.logos)
    ImageView logos;
    @BindView(R.id.et_typePlant)
    EditText etTypePlant;
    @BindView(R.id.input1)
    TextInputLayout input1;
    @BindView(R.id.text1)
    TextView text1;
    @BindView(R.id.nutrisiSR)
    TextInputLayout nutrisiSR;
    @BindView(R.id.nutrisiR)
    TextInputLayout nutrisiR;
    @BindView(R.id.et_Nitrogen)
    EditText etNitrogen;
    @BindView(R.id.nutrisiM)
    TextInputLayout nutrisiM;
    @BindView(R.id.nitrogenlayout)
    LinearLayout nitrogenlayout;
    @BindView(R.id.et_sangatRendahP)
    EditText etSangatRendahP;
    @BindView(R.id.nutrisiSRP)
    TextInputLayout nutrisiSRP;
    @BindView(R.id.et_rendahP)
    EditText etRendahP;
    @BindView(R.id.nutrisiRP)
    TextInputLayout nutrisiRP;
    @BindView(R.id.et_MediumP)
    EditText etMediumP;
    @BindView(R.id.nutrisiMP)
    TextInputLayout nutrisiMP;
    @BindView(R.id.phosporuslayout)
    LinearLayout phosporuslayout;
    @BindView(R.id.et_sangatRendahPo)
    EditText etSangatRendahPo;
    @BindView(R.id.nutrisiSRPo)
    TextInputLayout nutrisiSRPo;
    @BindView(R.id.et_rendahPo)
    EditText etRendahPo;
    @BindView(R.id.nutrisiRPo)
    TextInputLayout nutrisiRPo;
    @BindView(R.id.et_MediumPo)
    EditText etMediumPo;
    @BindView(R.id.nutrisiMPo)
    TextInputLayout nutrisiMPo;
    @BindView(R.id.potassiumlayout)
    LinearLayout potassiumlayout;
    @BindView(R.id.btnForm)
    Button btnForm;
    DataTipe dataTipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_detail);
        ButterKnife.bind(this);
        dataTipe = getIntent().getParcelableExtra("type");
        etTypePlant.setText(dataTipe.getTipe());
        etNitrogen.setText(String.valueOf(dataTipe.getNitrogen()));
        etSangatRendahP.setText(String.valueOf(dataTipe.getPhosporusVL()));
        etRendahP.setText(String.valueOf(dataTipe.getPhosporusL()));
        etMediumP.setText(String.valueOf(dataTipe.getPhosporusM()));
        etSangatRendahPo.setText(String.valueOf(dataTipe.getPotassiumVL()));
        etRendahPo.setText(String.valueOf(dataTipe.getPotassiumL()));
        etMediumPo.setText(String.valueOf(dataTipe.getPotassiumM()));
    }
}
