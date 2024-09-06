package com.carrental.rateshop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.carrental.rateshop.dao.FleetDao;
import com.carrental.rateshop.model.Car;
import com.carrental.rateshop.model.CarSpecifications;
import com.carrental.rateshop.model.RentPredictionRequest;
import com.carrental.rateshop.model.RentPredictionResponse;

@Service
public class FleetService {
	
	
	@Autowired
	FleetDao fleetDao;
	

    @Value("${rent.predictor.url}")
    private String rentPredictorUrl;

	public RentPredictionResponse predictRent(RentPredictionRequest request) {
		
        if (request == null) {
            throw new IllegalArgumentException("Car not found");
        }

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> rentRequest = new HashMap<>();
        rentRequest.put("year", request.getCarYear());
        rentRequest.put("make", request.getCarMake());
        rentRequest.put("trim", request.getCarTrim());
        rentRequest.put("body", request.getCarBody());
        rentRequest.put("condition", request.getCarCondition());
        rentRequest.put("odometer", request.getCarOdometer());
        rentRequest.put("transmission", request.getCarTransmission());

        try {
            // Call the Rent Predictor microservice
            return restTemplate.postForObject(rentPredictorUrl, rentRequest, RentPredictionResponse.class);
        } catch (RestClientException e) {
            throw new RuntimeException("Error connecting to Rent Predictor service: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error while predicting rent: " + e.getMessage(), e);
        }
		
	}

    public List<Car> getAllCars() {
        try {
            return fleetDao.findAll();
        } catch (DataAccessException e) {
            throw new RuntimeException("Database error while fetching all cars: " + e.getMessage(), e);
        }
    }

    public Car addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("Car cannot be null.");
        }

        try {
            return fleetDao.save(car);
        } catch (DataAccessException e) {
            throw new RuntimeException("Database error while saving the car: " + e.getMessage(), e);
        }
    }

    public List<Car> getCars(String carNo, Integer carYear, String carMake, String carModel, String carTrim,
                             String carBody, String carTransmission, Integer carCondition, Float carOdometer, String carFleetNo) {
        try {
            Specification<Car> spec = Specification.where(CarSpecifications.hasCarNo(carNo))
                    .and(CarSpecifications.hasCarYear(carYear))
                    .and(CarSpecifications.hasCarMake(carMake))
                    .and(CarSpecifications.hasCarModel(carModel))
                    .and(CarSpecifications.hasCarTrim(carTrim))
                    .and(CarSpecifications.hasCarBody(carBody))
                    .and(CarSpecifications.hasCarTransmission(carTransmission))
                    .and(CarSpecifications.hasCarCondition(carCondition))
                    .and(CarSpecifications.hasCarOdometer(carOdometer))
                    .and(CarSpecifications.hasCarFleetNo(carFleetNo));

            return fleetDao.findAll(spec);
        } catch (DataAccessException e) {
            throw new RuntimeException("Database error while searching for cars: " + e.getMessage(), e);
        }
    }

	public String deleteCar(String carNo) {
	       if (carNo == null) {
	            throw new IllegalArgumentException("Car cannot be null.");
	        }

	        try {
	            	fleetDao.deleteById(carNo);
	            	return "Car deleted successfully";
	        } catch (DataAccessException e) {
	            throw new RuntimeException("Database error while deleting the car: " + e.getMessage(), e);
	        }
	}
}

