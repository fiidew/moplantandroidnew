package com.example.nutplant.feature.admin;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutplant.R;
import com.example.nutplant.utils.SessionManager;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FormDataPlantActivity extends AppCompatActivity implements FormContract.View {

    FormContract.Presenter presenter;
    ProgressDialog dialog;
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

    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_data_plant);
        ButterKnife.bind(this);

        presenter = new FormPresenter(this);
        sessionManager = new SessionManager(this);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.setCancelable(false);
        dialog.setTitle("Add Type");
    }

    @OnClick(R.id.btnForm)
    public void onViewClicked() {
        attachAddType(etTypePlant.getText().toString(), etNitrogen.getText().toString(), etSangatRendahP.getText().toString(), etRendahP.getText().toString(), etMediumP.getText().toString(), etSangatRendahPo.getText().toString(), etRendahPo.getText().toString(), etMediumPo.getText().toString());
    }

    private void attachAddType(String tipe, String nitrogen, String phosporusVL, String phosporusL, String phosporusM, String potassiumVL, String potassiumL, String potassiumM) {
        String tipeError = null;
        String nitrogenError = null;
        String phosporusVLError = null;
        String phosporusLError = null;
        String phosporusMError = null;
        String potassiumVLError = null;
        String potassiumLError = null;
        String potassiumMError = null;


        if (TextUtils.isEmpty(tipe))
            tipeError = "Tipe cannot be empty";

        if (TextUtils.isEmpty(nitrogen))
            nitrogenError = "Nitrogen recommendation cannot be empty";

        if (TextUtils.isEmpty(phosporusVL))
            phosporusVLError = "Phosporus recommendation cannot be empty";

        if (TextUtils.isEmpty(phosporusL))
            phosporusLError = "Phosporus recommendation cannot be empty";

        if (TextUtils.isEmpty(phosporusM))
            phosporusMError = "Phosporus recommendation cannot be empty";

        if (TextUtils.isEmpty(potassiumVL))
            potassiumVLError = "Potassium recommendation cannot be empty";

        if (TextUtils.isEmpty(potassiumL))
            potassiumLError = "Potassium recommendation cannot be empty";

        if (TextUtils.isEmpty(potassiumM))
            potassiumMError = "Potassium recommendation cannot be empty";


        if (tipeError == null && nitrogenError == null && phosporusVLError == null && phosporusLError == null && phosporusMError == null && potassiumVLError == null && potassiumLError == null && potassiumMError == null)
            presenter.addTipe(sessionManager.getToken(), tipe, Integer.parseInt(nitrogen), Integer.parseInt(phosporusVL), Integer.parseInt(phosporusL), Integer.parseInt(phosporusM), Integer.parseInt(potassiumVL), Integer.parseInt(potassiumL), Integer.parseInt(potassiumM));
        else {
            etTypePlant.setError(tipeError);
            etNitrogen.setError(nitrogenError);
            etSangatRendahP.setError(phosporusVLError);
            etRendahP.setError(phosporusLError);
            etMediumP.setError(phosporusMError);
            etSangatRendahPo.setError(potassiumVLError);
            etRendahPo.setError(potassiumLError);
            etMediumPo.setError(potassiumMError);
        }
    }

    @Override
    public void addTipe(boolean isSucces, String message) {
//        if (isSucces) clearForm();
        if (isSucces) finish();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void clearForm() {
        etTypePlant.setText("");
        etNitrogen.setText("");
        etSangatRendahP.setText("");
        etRendahP.setText("");
        etMediumP.setText("");
        etSangatRendahPo.setText("");
        etRendahPo.setText("");
        etMediumPo.setText("");
    }

    @Override
    public void showLoading(boolean show) {
        if (show) dialog.show();
        else dialog.cancel(); //or u can use dismiss

    }
}
