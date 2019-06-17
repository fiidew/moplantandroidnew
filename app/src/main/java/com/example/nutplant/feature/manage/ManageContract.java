package com.example.nutplant.feature.manage;

import com.example.nutplant.model.Plant;

import java.util.ArrayList;

public class ManageContract {
    interface View{
        void read (ArrayList <Plant> plants);
        void showLoading(boolean show);
    }

    interface Presenter{
        void getPlants();
        //ketika ngamil data tanaman perlu difilter apa
    }
}
