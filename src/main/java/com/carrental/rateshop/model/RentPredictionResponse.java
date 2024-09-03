package com.carrental.rateshop.model;

import lombok.Data;

@Data
public class RentPredictionResponse {
	
	private float sellingprice;
	private float hourly;
	private float daily;
	private float weekly;
	private float monthly;
	public float getSellingprice() {
		return sellingprice;
	}
	public void setSellingprice(float sellingprice) {
		this.sellingprice = sellingprice;
	}
	public float getHourly() {
		return hourly;
	}
	public void setHourly(float hourly) {
		this.hourly = hourly;
	}
	public float getDaily() {
		return daily;
	}
	public void setDaily(float daily) {
		this.daily = daily;
	}
	public float getWeekly() {
		return weekly;
	}
	public void setWeekly(float weekly) {
		this.weekly = weekly;
	}
	public float getMonthly() {
		return monthly;
	}
	public void setMonthly(float monthly) {
		this.monthly = monthly;
	}
	public RentPredictionResponse(float sellingprice, float hourly, float daily, float weekly, float monthly) {
		super();
		this.sellingprice = sellingprice;
		this.hourly = hourly;
		this.daily = daily;
		this.weekly = weekly;
		this.monthly = monthly;
	}

	


}
