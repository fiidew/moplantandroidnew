package com.example.nutplant.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nutplant.feature.manage.detailplant.DetailPlantActivity;
import com.example.nutplant.R;
import com.example.nutplant.model.DataPlant;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.MyViewHolder> {

    private ArrayList<DataPlant> plants;
    private Context context;

    public PlantAdapter(ArrayList<DataPlant> plants, Context context) {
        this.plants = plants;
        this.context = context;
    }

    public ArrayList<DataPlant> getAll() {
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
        final DataPlant plant = plants.get(position);

        holder.namaplant.setText(plant.getNamaTanaman());
        holder.speciesplant.setText("Spesies : " + plant.getSpesies());
        holder.largeplant.setText("Luas Lahan : " + String.valueOf(plant.getLuasLahan()));


        String plantAge = "";

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = dateFormat.parse(plant.getTanggal().substring(0, 10));
            Date now = calendar.getTime();
            long age = Math.abs(date.getTime() - now.getTime());
            plantAge = String.valueOf(TimeUnit.MILLISECONDS.toDays(age));
            holder.umurplant.setText(plantAge);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String finalPlantAge = plantAge;
        holder.daftarplant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPlantActivity.class);
                intent.putExtra("plant", plant);
                intent.putExtra("umur", finalPlantAge);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return plants.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView2)
        ImageView imageView2;
        @BindView(R.id.namaplant)
        TextView namaplant;
        @BindView(R.id.speciesplant)
        TextView speciesplant;
        @BindView(R.id.largeplant)
        TextView largeplant;
        @BindView(R.id.textView3)
        TextView textView3;
        @BindView(R.id.umurplant)
        TextView umurplant;
        @BindView(R.id.Daftarplant)
        public ConstraintLayout daftarplant;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}