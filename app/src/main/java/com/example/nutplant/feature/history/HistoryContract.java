package com.example.nutplant.feature.history;

import com.example.nutplant.model.DataPlant;

import java.util.ArrayList;

public class HistoryContract {
    interface View{
        void showLoading(boolean show);
        void read (ArrayList<DataPlant> plants, String message);
    }

    interface Presenter{
        void getPlants(String token);
        //ketika ngambil data tanaman perlu difilter apa
    }
}
