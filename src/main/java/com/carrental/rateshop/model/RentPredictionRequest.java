package com.carrental.rateshop.model;

import lombok.Data;

@Data
public class RentPredictionRequest {
	
	private int carYear;
	private String carMake;
	private String carTrim;
	private String carBody;
	private int carCondition;
	private float carOdometer;
	private	String carTransmission;
	

	
	public RentPredictionRequest(int carYear, String carMake, String carModel, String carTrim,
			String carBody, String carTransmission, int carCondition, float carOdometer) {
		super();
		this.carYear = carYear;
		this.carMake = carMake;
		this.carTrim = carTrim;
		this.carBody = carBody;
		this.carTransmission = carTransmission;
		this.carCondition = carCondition;
		this.carOdometer = carOdometer;
	}



	public int getCarYear() {
		return carYear;
	}



	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}



	public String getCarMake() {
		return carMake;
	}



	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}



	public String getCarTrim() {
		return carTrim;
	}



	public void setCarTrim(String carTrim) {
		this.carTrim = carTrim;
	}



	public String getCarBody() {
		return carBody;
	}



	public void setCarBody(String carBody) {
		this.carBody = carBody;
	}



	public int getCarCondition() {
		return carCondition;
	}



	public void setCarCondition(int carCondition) {
		this.carCondition = carCondition;
	}



	public float getCarOdometer() {
		return carOdometer;
	}



	public void setCarOdometer(float carOdometer) {
		this.carOdometer = carOdometer;
	}



	public String getCarTransmission() {
		return carTransmission;
	}



	public void setCarTransmission(String carTransmission) {
		this.carTransmission = carTransmission;
	}



	@Override
	public String toString() {
		return "RentPredictionRequest [carYear=" + carYear + ", carMake=" + carMake + ", carTrim=" + carTrim
				+ ", carBody=" + carBody + ", carCondition=" + carCondition + ", carOdometer=" + carOdometer
				+ ", carTransmission=" + carTransmission + "]";
	}
	
	

}
