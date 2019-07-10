package com.example.nutplant.feature.history;

import com.example.nutplant.model.DataNotification;

import java.util.ArrayList;

public class HistoryContract {
    interface View{
        void showLoading(boolean show);
        void read(ArrayList<DataNotification> notifications, String message);
    }

    interface Presenter{
        void getNotifications(String token);
    }
}
