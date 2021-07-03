package com.upnyk.covid_19.view.rs;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.upnyk.covid_19.api.APIService;
import com.upnyk.covid_19.view.rs.pojo.DataItem;
import com.upnyk.covid_19.view.rs.pojo.RumahSakitResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RumahSakitViewModel extends ViewModel {

    MutableLiveData<List<DataItem>> listRumahSakit;
    public RumahSakitViewModel() {
        listRumahSakit = new MutableLiveData<>();
    }

    public MutableLiveData<List<DataItem>> getListRumahSakit() {
        return listRumahSakit;
    }

    void obtainRumahSakitList(){
        APIService apiService = new APIService();
        apiService.getAPI().getRumahSakit().enqueue(new Callback<RumahSakitResponse>() {
            @Override
            public void onResponse(Call<RumahSakitResponse> call, Response<RumahSakitResponse> response) {
                listRumahSakit.setValue(response.body().getData());
            }

            @Override
            public void onFailure(Call<RumahSakitResponse> call, Throwable t) {

            }
        });
    }
}
