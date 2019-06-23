package com.example.nutplant.feature.manage;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.nutplant.feature.manage.create.AddPlantActivity;
import com.example.nutplant.R;
import com.example.nutplant.adapters.PlantAdapter;
import com.example.nutplant.model.DataPlant;
import com.example.nutplant.utils.SessionManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ManageActivity extends AppCompatActivity implements ManageContract.View {
    @BindView(R.id.managePlant)
    RecyclerView managePlant;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    ManageContract.Presenter presenter;
    ProgressDialog dialog;
    SessionManager sessionManager;

    private PlantAdapter adapter;
    private ArrayList<DataPlant> plants;
    public ManageActivity() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getPlants(sessionManager.getToken());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        ButterKnife.bind(this);

        presenter = new ManagePresenter(this);
        sessionManager = new SessionManager(this);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.setCancelable(false);
        dialog.setTitle("Manage");

        adapter = new PlantAdapter(new ArrayList<>(), this);
        managePlant.setLayoutManager(new LinearLayoutManager(this));
        managePlant.setHasFixedSize(false);
        managePlant.setAdapter(adapter);


    }

    @Override
    public void read(ArrayList<DataPlant> plants, String message) {
        if (plants != null){
//            adapter.getAll().clear();
            adapter.getAll().addAll(plants);
            adapter.notifyDataSetChanged();
        }else{
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showLoading(boolean show) {
        if (show) dialog.show();
        else dialog.cancel(); //or u can use dismiss
    }

    @OnClick(R.id.fab)
    public void onViewClicked() {
        startActivity(new Intent(this, AddPlantActivity.class));
    }

}
