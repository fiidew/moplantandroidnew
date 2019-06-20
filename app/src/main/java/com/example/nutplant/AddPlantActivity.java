package com.example.nutplant;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

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

public class AddPlantActivity extends AppCompatActivity {

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

    private Context mContext;
    private Activity mActivity;

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;

    private CoordinatorLayout mCLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);
        ButterKnife.bind(this);

        edtSpeciesP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(AddPlantActivity.this);

                builder.setTitle("Choose a plant.");

                final String[] tanaman = new String[]{
                        "Kangkung",
                        "Sawi",
                        "Bayam"
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

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
    }

    private void showDateDialog() {

        Calendar newCalendar = Calendar.getInstance();

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                edtDateP.setText("Tanggal tanam : " + dateFormatter.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    @OnClick({R.id.edtDateP, R.id.btnCreate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.edtDateP: showDateDialog();
                break;
            case R.id.btnCreate:
                break;
        }
    }
}
