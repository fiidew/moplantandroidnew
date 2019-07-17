package com.example.nutplant.feature.admin.list;

import com.example.nutplant.model.DataTipe;

import java.util.ArrayList;

public class ListTipeContract {
    interface View{
        void showLoading(boolean show);
        void read(ArrayList<DataTipe> types, String message);
    }

    interface Presenter{
        void getTypes(String token);
    }
}
