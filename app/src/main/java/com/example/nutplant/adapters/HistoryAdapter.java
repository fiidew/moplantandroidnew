package com.example.nutplant.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutplant.R;
import com.example.nutplant.model.DataPerangkat;
import com.example.nutplant.model.DataPlant;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    private ArrayList<DataPerangkat> plants;
    private Context context;

    public HistoryAdapter(ArrayList<DataPerangkat> plants, Context context) {
        this.plants = plants;
        this.context = context;
    }

    public ArrayList<DataPerangkat> getAll() {
        return this.plants;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_manage, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final DataPerangkat plant = plants.get(position);

        holder.currentSoilMoisture3.setText(String.valueOf(plant.getKelembabanTanah()));
        holder.currentTemperature3.setText(String.valueOf(plant.getKelembabanUdara()));
        holder.currentHumidity3.setText(String.valueOf(plant.getSuhuUdara()));

    }

    @Override
    public int getItemCount() {
        return plants.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.currentSoilMoisture3)
        TextView currentSoilMoisture3;
        @BindView(R.id.currentTemperature3)
        TextView currentTemperature3;
        @BindView(R.id.currentHumidity3)
        TextView currentHumidity3;
        @BindView(R.id.DaftarplantHistory)
        public ConstraintLayout DaftarplantHistory;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
