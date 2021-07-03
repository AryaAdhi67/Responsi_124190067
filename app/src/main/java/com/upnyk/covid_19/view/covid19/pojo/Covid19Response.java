package com.upnyk.covid_19.view.covid19.pojo;

import com.google.gson.annotations.SerializedName;

public class Covid19Response{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private Data data;

	public int getStatusCode(){
		return statusCode;
	}

	public Data getData(){
		return data;
	}
}