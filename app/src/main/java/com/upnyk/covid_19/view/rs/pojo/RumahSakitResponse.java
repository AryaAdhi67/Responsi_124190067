package com.upnyk.covid_19.view.rs.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RumahSakitResponse{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private List<DataItem> data;

	public int getStatusCode(){
		return statusCode;
	}

	public List<DataItem> getData(){
		return data;
	}
}