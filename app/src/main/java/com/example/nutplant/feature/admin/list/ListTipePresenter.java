package com.example.nutplant.feature.admin.list;

import com.example.nutplant.model.ResponseTipes;
import com.example.nutplant.service.ApiClient;
import com.example.nutplant.service.PlantService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListTipePresenter implements ListTipeContract.Presenter{

    PlantService service;
    ListTipeContract.View view;

    public ListTipePresenter(ListTipeContract.View view) {
        this.view = view;
        service = ApiClient.getClient().create(PlantService.class);
    }

    @Override
    public void getTypes(String token) {
        view.showLoading(true);
        Call<ResponseTipes> getTypes = service.getalltype(token);
        getTypes.enqueue(new Callback<ResponseTipes>() {
            @Override
            public void onResponse(Call<ResponseTipes> call, Response<ResponseTipes> response) {
                view.showLoading(false);
                if (response.code()==200){
                    view.read(response.body().getData(), response.body().getMessage());
                }else{
                    view.read(null,response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseTipes> call, Throwable t) {
                view.showLoading(false);
                t.printStackTrace();
                call.cancel();
                view.read(null,t.getMessage());
            }
        });
    }
}
