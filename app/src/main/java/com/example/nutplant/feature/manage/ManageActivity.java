package com.example.nutplant.feature.manage;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.nutplant.AddPlantActivity;
import com.example.nutplant.R;
import com.example.nutplant.adapters.PlantAdapter;
import com.example.nutplant.feature.auth.register.RegisterContract;
import com.example.nutplant.feature.auth.register.RegisterPresenter;
import com.example.nutplant.model.Plant;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

    private PlantAdapter adapter;
    public ManageActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        ButterKnife.bind(this);

        presenter = new ManagePresenter(this);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.setCancelable(false);
        dialog.setTitle("Manage");

        adapter = new PlantAdapter(new ArrayList<>(), this);
        managePlant.setLayoutManager(new LinearLayoutManager(this));
        managePlant.setHasFixedSize(false);
        managePlant.setAdapter(adapter);

        presenter.getPlants();
    }

    @Override
    public void read(ArrayList<Plant> plants) {
        if (plants != null){
//            adapter.getAll().clear();
            adapter.getAll().addAll(plants);
            adapter.notifyDataSetChanged();
        }else{
            Toast.makeText(this, "Failed get data", Toast.LENGTH_SHORT).show();
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
