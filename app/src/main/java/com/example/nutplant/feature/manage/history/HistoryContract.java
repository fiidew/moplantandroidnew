package com.example.nutplant.feature.manage.history;

import com.example.nutplant.model.DataPerangkat;
import com.example.nutplant.model.DataPlant;

import java.util.ArrayList;

public class HistoryContract {
    interface View{
        void showLoading(boolean show);
        void getdetailhistory (ArrayList<DataPerangkat> plants, String message);
    }

    interface Presenter{
        void getdetailhistory(String token, String idTanaman, String start, String end);
        //ketika ngambil data tanaman perlu difilter apa
    }
}
