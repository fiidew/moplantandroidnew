package com.example.nutplant.feature.notification;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutplant.R;
import com.example.nutplant.model.DataNotification;
import com.example.nutplant.utils.SessionManager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationActivity extends AppCompatActivity implements NotificationContract.View {

    @BindView(R.id.imageView8)
    ImageView imageView8;
    @BindView(R.id.textView12)
    TextView textView12;
    @BindView(R.id.plantnotif)
    TextView plantnotif;
    @BindView(R.id.plantnotif2)
    TextView plantnotif2;
    @BindView(R.id.plantnotif3)
    TextView plantnotif3;
    @BindView(R.id.pupuknotif)
    TextView pupuknotif;
    @BindView(R.id.clPupuk)
    ConstraintLayout clPupuk;
    @BindView(R.id.cardView)
    CardView cardView;
    @BindView(R.id.button)
    Button button;
    ProgressDialog dialog;
    NotificationPresenter presenter;
    SessionManager sessionManager;
    DataNotification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        notification = getIntent().getParcelableExtra("dataNotification");
        presenter = new NotificationPresenter(this);
        sessionManager = new SessionManager(this);
        plantnotif.setText("to your " + getIntent().getStringExtra("namaTanaman") + " plant");
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setMessage("Updating data");
        dialog.setCancelable(false);
        if (notification.getStatus() == 0) {
            textView12.setText("Recommendations have been ignored");
            plantnotif.setText("please take care of your plants");
            clPupuk.setBackgroundColor(getResources().getColor(R.color.colorSix));
            imageView8.setImageDrawable(getResources().getDrawable(R.drawable.ignore));
            button.setBackgroundColor(getResources().getColor(R.color.colorSix));
            button.setEnabled(false);
        } else if (notification.getStatus() == 1) {
            imageView8.setImageDrawable(getResources().getDrawable(R.drawable.logo1));
        } else {
            clPupuk.setBackgroundColor(getResources().getColor(R.color.colorSix));
            imageView8.setImageDrawable(getResources().getDrawable(R.drawable.logo1));
            button.setBackgroundColor(getResources().getColor(R.color.colorSix));
            button.setEnabled(false);
        }
        pupuknotif.setText(notification.getRecommendation());
    }

    @Override
    public void isUpdateNotification(boolean isSuccess, String message) {
        if (isSuccess) {
            clPupuk.setBackgroundColor(getResources().getColor(R.color.colorSix));
            imageView8.setImageDrawable(getResources().getDrawable(R.drawable.logo1));
            button.setBackgroundColor(getResources().getColor(R.color.colorSix));
            button.setEnabled(false);
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialog(boolean show) {
        if (show) dialog.show();
        else dialog.cancel();
    }

    private void showDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle("Update confirmation");
        alertDialogBuilder
                .setMessage("Does the plant already get fertilizer?")
                .setIcon(R.drawable.logo)
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        presenter.updateNotification(sessionManager.getToken(), notification.getId(), 2);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        showDialog();
    }
}
