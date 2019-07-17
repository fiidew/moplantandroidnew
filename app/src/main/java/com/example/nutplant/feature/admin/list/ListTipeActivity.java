package com.example.nutplant.feature.admin.list;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.nutplant.R;
import com.example.nutplant.adapters.TipeAdapter;
import com.example.nutplant.feature.admin.FormDataPlantActivity;
import com.example.nutplant.model.DataTipe;
import com.example.nutplant.utils.SessionManager;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListTipeActivity extends AppCompatActivity implements ListTipeContract.View {

    ListTipeContract.Presenter presenter;
    SessionManager sessionManager;
    ProgressDialog dialog;
    TipeAdapter adapter;
    @BindView(R.id.ListType)
    RecyclerView ListType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tipe);
        ButterKnife.bind(this);
        presenter = new ListTipePresenter(this);
        sessionManager = new SessionManager(this);
        adapter = new TipeAdapter(new ArrayList<>(), this);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setMessage("Get List Notification");
        dialog.setCancelable(false);
        ListType.setLayoutManager(new LinearLayoutManager(this));
        ListType.setHasFixedSize(false);
        ListType.setAdapter(adapter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.getTypes(sessionManager.getToken());
    }

    @Override
    public void showLoading(boolean show) {
        if (show) dialog.show();
        else dialog.cancel();
    }

    @Override
    public void read(ArrayList<DataTipe> types, String message) {
        if (types != null) {
            adapter.getAll().clear();
            adapter.getAll().addAll(types);
            adapter.notifyDataSetChanged();
        } else Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.tab)
    public void onViewClicked() {
        startActivity(new Intent(this,FormDataPlantActivity.class));
    }
}
