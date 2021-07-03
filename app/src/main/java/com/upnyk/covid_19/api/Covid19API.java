package com.upnyk.covid_19.api;

import com.upnyk.covid_19.view.covid19.pojo.Covid19Response;
import com.upnyk.covid_19.view.rs.pojo.RumahSakitResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Covid19API {

    @GET("rekapitulasi_v2/jabar/harian")
    Call<Covid19Response> getCovid19();

    @GET("sebaran_v2/jabar/faskes")
    Call<RumahSakitResponse> getRumahSakit();

}
