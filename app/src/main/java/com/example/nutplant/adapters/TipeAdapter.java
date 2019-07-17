package com.example.nutplant.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nutplant.R;
import com.example.nutplant.feature.admin.detail.TypeDetailActivity;
import com.example.nutplant.feature.manage.detailplant.DetailPlantActivity;
import com.example.nutplant.model.DataTipe;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TipeAdapter extends RecyclerView.Adapter<TipeAdapter.MyViewHolder> {

    private ArrayList<DataTipe> types;
    private Context context;

    public TipeAdapter(ArrayList<DataTipe> types, Context context) {
        this.types = types;
        this.context = context;
    }

    public ArrayList<DataTipe> getAll() {
        return this.types;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_type, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final DataTipe type = types.get(position);

        holder.typeName.setText(type.getTipe());
        holder.cvParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TypeDetailActivity.class);
                intent.putExtra("type", type);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return types.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.typeName)
        TextView typeName;
        @BindView(R.id.cvParent)
        CardView cvParent;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}