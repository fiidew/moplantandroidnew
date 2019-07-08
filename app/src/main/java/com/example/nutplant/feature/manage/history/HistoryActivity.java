package com.example.nutplant.feature.manage.history;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.nutplant.R;
import com.example.nutplant.adapters.HistoryAdapter;
import com.example.nutplant.model.DataPerangkat;
import com.example.nutplant.model.DataPlant;
import com.example.nutplant.utils.SessionManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends AppCompatActivity implements HistoryContract.View {
    @BindView(R.id.managePlantHistory)
    RecyclerView managePlantHistory;
    HistoryContract.Presenter presenter;
    ProgressDialog dialog;
    SessionManager sessionManager;

    private HistoryAdapter adapter;
    private ArrayList<DataPerangkat> plant;
    public HistoryActivity() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getdetailhistory(sessionManager.getToken(), "5d2051df961315159c760bad", "06-06-2019", "07-07-2019");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_bintang);
        ButterKnife.bind(this);

        presenter = new HistoryPresenter(this);
        sessionManager = new SessionManager(this);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.setCancelable(false);
        dialog.setTitle("Manage");

        adapter = new HistoryAdapter(new ArrayList<>(), this);
        managePlantHistory.setLayoutManager(new LinearLayoutManager(this));
        managePlantHistory.setHasFixedSize(false);
        managePlantHistory.setAdapter(adapter);


    }

    @Override
    public void getdetailhistory(ArrayList<DataPerangkat> plant, String message) {
        if (plant != null){
//            adapter.getAll().clear();
            adapter.getAll().addAll(plant);
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


}
