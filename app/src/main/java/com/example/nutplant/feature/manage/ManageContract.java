package com.example.nutplant.feature.manage;

import com.example.nutplant.model.DataPlant;
import com.example.nutplant.model.Plant;

import java.util.ArrayList;

public class ManageContract {
    interface View{
        void showLoading(boolean show);
        void read (ArrayList<DataPlant> plants,String message);
    }

    interface Presenter{
        void getPlants(String token);
        //ketika ngambil data tanaman perlu difilter apa
    }
}
