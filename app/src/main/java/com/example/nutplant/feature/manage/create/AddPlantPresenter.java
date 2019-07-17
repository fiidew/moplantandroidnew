package com.example.nutplant.feature.manage.create;

import com.example.nutplant.model.ResponseAddplant;
import com.example.nutplant.model.ResponseRegister;
import com.example.nutplant.model.ResponseTipes;
import com.example.nutplant.service.ApiClient;
import com.example.nutplant.service.PlantService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPlantPresenter implements AddPlantContract.Presenter{
    private PlantService service;
    private AddPlantContract.View view;

    public AddPlantPresenter(AddPlantContract.View view) {
        this.view = view;
        service = ApiClient.getClient().create(PlantService.class);

    }

    @Override
    public void getSpecies(String token) {
        view.showLoading(true);
        Call<ResponseTipes> getTypes = service.getalltype(token);
        getTypes.enqueue(new Callback<ResponseTipes>() {
            @Override
            public void onResponse(Call<ResponseTipes> call, Response<ResponseTipes> response) {
                view.showLoading(false);
                if (response.code()==200){
                    view.showSpecies(response.body().getData(), response.body().getMessage());
                }else{
                    view.showSpecies(null,response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseTipes> call, Throwable t) {
                view.showLoading(false);
                t.printStackTrace();
                call.cancel();
                view.showSpecies(null,t.getMessage());
            }
        });
    }

    @Override
    public void create(String token, String namaTanaman, Double luasLahan, String lokasiLahan, String spesies, String tanggal) {
        Call<ResponseAddplant> create = service.createplants(token, namaTanaman, luasLahan, lokasiLahan, spesies, tanggal);
        create.enqueue(new Callback<ResponseAddplant>() {
            @Override
            public void onResponse(Call<ResponseAddplant> call, Response<ResponseAddplant> response) {
                view.showLoading(false);
                if (response.code() == 200) {
                    if (response.body().getStatus())
                        view.create(true, "Plant succesfully added");
                    else
                        view.create(false, response.body().getMessage());
                } else {
                    view.create(false, "Failed add plant" + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseAddplant> call, Throwable t) {
                view.showLoading(false);
                view.create(false, t.getMessage());
                call.cancel();
                t.printStackTrace();
            }
        });

    }
}
