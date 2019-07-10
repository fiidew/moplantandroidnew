package com.example.nutplant.feature.history;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.nutplant.R;
import com.example.nutplant.adapters.NotificationAdapter;
import com.example.nutplant.model.DataNotification;
import com.example.nutplant.model.DataPlant;
import com.example.nutplant.utils.SessionManager;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends AppCompatActivity implements HistoryContract.View {

    HistoryContract.Presenter presenter;
    SessionManager sessionManager;
    ProgressDialog dialog;
    NotificationAdapter adapter;
    @BindView(R.id.managePlant)
    RecyclerView managePlant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        presenter = new HistoryPresenter(this);
        sessionManager = new SessionManager(this);
        adapter = new NotificationAdapter(new ArrayList<>(), this,getIntent().getStringExtra("namaTanaman"));
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setMessage("Get List Notification");
        dialog.setCancelable(false);
        managePlant.setLayoutManager(new LinearLayoutManager(this));
        managePlant.setHasFixedSize(false);
        managePlant.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getNotifications(sessionManager.getToken());
    }

    @Override
    public void showLoading(boolean show) {
        if (show) dialog.show();
        else dialog.cancel();
    }

    @Override
    public void read(ArrayList<DataNotification> notifications, String message) {
        if (notifications != null){
            adapter.getAll().clear();
            adapter.getAll().addAll(notifications);
            adapter.notifyDataSetChanged();
        }else Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
