package com.carrental.rateshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.carrental.rateshop.model.Car;

public interface FleetDao extends JpaRepository<Car, String>, JpaSpecificationExecutor<Car> {

//	List<Car> findByCarTypeAndStartDateGreaterThanEqualAndEndDateLessThanEqual(String carType, Timestamp startDate, Timestamp endDate);
	

}
