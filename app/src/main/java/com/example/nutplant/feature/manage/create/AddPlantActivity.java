package com.example.nutplant.feature.manage.create;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutplant.R;
import com.example.nutplant.utils.SessionManager;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddPlantActivity extends AppCompatActivity implements AddPlantContract.View  {

    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.edtNameP)
    EditText edtNameP;
    @BindView(R.id.edtAreaP)
    EditText edtAreaP;
    @BindView(R.id.edtSpeciesP)
    EditText edtSpeciesP;
    @BindView(R.id.edtLocationP)
    EditText edtLocationP;
    @BindView(R.id.edtDateP)
    EditText edtDateP;
    @BindView(R.id.btnCreate)
    Button btnCreate;

    ProgressDialog dialog;

    private Context mContext;
    private Activity mActivity;

    AddPlantContract.Presenter presenter;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;

    SessionManager sessionManager;

    private CoordinatorLayout mCLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);
        ButterKnife.bind(this);

        presenter = new AddPlantPresenter(this);
        sessionManager = new SessionManager(this);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.setCancelable(false);
        dialog.setTitle("Add plant");

        edtSpeciesP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(AddPlantActivity.this);

                builder.setTitle("Choose a plant.");

                final String[] tanaman = new String[]{
                        "Kangkung",
                        "Sawi",
                        "Bayam",
                        "Cabai",
                        "Terong"
                };

                builder.setSingleChoiceItems(
                        tanaman,
                        -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String selectedItem = Arrays.asList(tanaman).get(i);

                                edtSpeciesP.setText(selectedItem);
                            }
                        });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

                AlertDialog dialog = builder.create();

                dialog.show();
            }
        });

        dateFormatter = new SimpleDateFormat("MM-dd-yyyy", Locale.US);
    }

    private void showDateDialog() {

        Calendar newCalendar = Calendar.getInstance();

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(dayOfMonth, monthOfYear, year);

                edtDateP.setText(dateFormatter.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.DAY_OF_MONTH), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.YEAR));

        datePickerDialog.show();
    }

    @OnClick({R.id.edtDateP, R.id.btnCreate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.edtDateP: showDateDialog();
                break;
            case R.id.btnCreate:
                attachAddplant(edtNameP.getText().toString() ,edtAreaP.getText().toString(), edtSpeciesP.getText().toString() ,edtLocationP.getText().toString(), edtDateP.getText().toString());
                break;
        }

    }


    private void attachAddplant(String namaTanaman, String luasLahan, String spesies, String lokasiLahan,  String tanggal) {
        String namaTanamanError = null;
        String luasLahanError = null;
        String lokasiLahanError = null;
        String spesiesError = null;
        String tanggalError = null;

        if (TextUtils.isEmpty(namaTanaman))
            namaTanamanError = "Name cannot be empty";

        if (TextUtils.isEmpty(luasLahan))
            luasLahanError = "Area of field cannot be empty";

        if (TextUtils.isEmpty(lokasiLahan))
            lokasiLahanError = "Location field cannot be empty";

        if (TextUtils.isEmpty(spesies))
            spesiesError = "Species cannot be empty";

        if (TextUtils.isEmpty(tanggal))
            tanggalError = "Date cannot be empty";


        if (namaTanamanError == null && luasLahanError == null && lokasiLahanError == null && spesiesError == null && tanggalError == null)
            presenter.create(sessionManager.getToken(), namaTanaman, Double.parseDouble(luasLahan), lokasiLahan, spesies, tanggal);
        else {
            edtNameP.setError(namaTanamanError);
            edtAreaP.setError(luasLahanError);
            edtLocationP.setError(lokasiLahanError);
            edtSpeciesP.setError(spesiesError);
            edtDateP.setError(tanggalError);
        }
    }

    @Override
    public void create(boolean isSucces, String message) {
        if (isSucces) {
            finish();
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(boolean show) {
        if (show) dialog.show();
        else dialog.cancel(); //or u can use dismiss

    }
}
