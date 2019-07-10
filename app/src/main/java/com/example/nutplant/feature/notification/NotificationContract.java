package com.example.nutplant.feature.notification;

public class NotificationContract {
    interface View{
        void isUpdateNotification(boolean isSuccess, String message);
        void showDialog(boolean show);
    }
    interface Presenter{
        void updateNotification(String token, String id, Integer status);
    }
}
