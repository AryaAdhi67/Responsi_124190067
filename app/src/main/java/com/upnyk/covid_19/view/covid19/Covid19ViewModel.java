package com.upnyk.covid_19.view.covid19;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.upnyk.covid_19.api.APIService;
import com.upnyk.covid_19.view.covid19.pojo.ContentItem;
import com.upnyk.covid_19.view.covid19.pojo.Covid19Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Covid19ViewModel extends ViewModel {

    MutableLiveData<List<ContentItem>> listCovid19;
    public Covid19ViewModel() {
        listCovid19 = new MutableLiveData<>();
    }

    public MutableLiveData<List<ContentItem>> getListCovid19() {
        return listCovid19;
    }

    void obtainCovid19List(){
        APIService apiService = new APIService();
        apiService.getAPI().getCovid19().enqueue(new Callback<Covid19Response>() {
            @Override
            public void onResponse(Call<Covid19Response> call, Response<Covid19Response> response) {
                listCovid19.setValue(response.body().getData().getContent());
            }

            @Override
            public void onFailure(Call<Covid19Response> call, Throwable t) {

            }
        });
    }
}
