package com.carrental.rateshop;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Rate {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
	private String carSegment;
	private String carType;
	private float hourly;
	private float daily;
	private float weekly;
	private float monthly;
	private Timestamp startDate;
	private Timestamp endDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCarSegment() {
		return carSegment;
	}
	public void setCarSegment(String carSegment) {
		this.carSegment = carSegment;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
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
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Rate [id=" + id + ", carSegment=" + carSegment + ", carType=" + carType + ", hourly=" + hourly
				+ ", daily=" + daily + ", weekly=" + weekly + ", monthly=" + monthly + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	
}