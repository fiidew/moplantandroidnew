package com.example.nutplant.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nutplant.feature.notification.NotificationActivity;
import com.example.nutplant.R;
import com.example.nutplant.model.DataNotification;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private ArrayList<DataNotification> notifications;
    private Context context;
    private String namaTanaman;

    public NotificationAdapter(ArrayList<DataNotification> notifications, Context context, String namaTanaman) {
        this.notifications = notifications;
        this.context = context;
        this.namaTanaman = namaTanaman;
    }

    public ArrayList<DataNotification> getAll() {
        return this.notifications;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_history, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final DataNotification notification = notifications.get(position);
        holder.cvParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NotificationActivity.class);
                intent.putExtra("dataNotification", notification);
                intent.putExtra("namaTanaman", namaTanaman);
                context.startActivity(intent);
            }
        });
        holder.pupukhistory.setText(notification.getRecommendation());
        holder.tanggalhistory.setText(notification.getTanggal());
        if (notification.getStatus()==0){
            holder.statushistory.setText("Ignore");
            holder.ivStatus.setImageDrawable(context.getDrawable(R.drawable.status_history_ignore));
        }else if(notification.getStatus()==1){
            holder.statushistory.setText("Pending");
            holder.ivStatus.setImageDrawable(context.getDrawable(R.drawable.status_history_pending));
        }else{
            holder.statushistory.setText("Done");
            holder.ivStatus.setImageDrawable(context.getDrawable(R.drawable.status_history_done));
        }
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cvParent)
        CardView cvParent;
        @BindView(R.id.statushistory)
        TextView statushistory;
        @BindView(R.id.ivStatus)
        ImageView ivStatus;
        @BindView(R.id.tanggalhistory)
        TextView tanggalhistory;
        @BindView(R.id.pupukhistory)
        TextView pupukhistory;
        @BindView(R.id.Daftarhistory)
        ConstraintLayout Daftarhistory;
        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
