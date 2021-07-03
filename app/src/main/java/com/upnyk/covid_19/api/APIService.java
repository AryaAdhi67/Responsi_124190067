package com.upnyk.covid_19.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {
    private Retrofit retrofit = null;

    public Covid19API getAPI(){
        if (retrofit == null){
            retrofit =new Retrofit.Builder()
                    .baseUrl("https://covid19-public.digitalservice.id/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Covid19API.class);
    }
}
