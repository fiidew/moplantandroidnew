package com.example.nutplant.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        holder.luaslahan.setText(String.valueOf(plant.getLuasLahan()));
        holder.lokasilahan.setText(plant.getLokasiLahan());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = dateFormat.parse(plant.getTanggal().substring(0, 10));
            Date now = calendar.getTime();
            long umur = Math.abs(date.getTime() - now.getTime());
            holder.umurplant.setText(String.valueOf(TimeUnit.MILLISECONDS.toDays(umur)));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return plants.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView2)
        ImageView imageView2;
        @BindView(R.id.namaplant)
        TextView namaplant;
        @BindView(R.id.speciesplant)
        TextView speciesplant;
        @BindView(R.id.textView3)
        TextView textView3;
        @BindView(R.id.umurplant)
        TextView umurplant;
        @BindView(R.id.luaslahan)
        TextView luaslahan;
        @BindView(R.id.lokasilahan)
        TextView lokasilahan;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}