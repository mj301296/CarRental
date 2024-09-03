package com.carrental.rateshop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
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

//
//	public List<Rate> getAllRates() {
//		return rateDao.findAll();
//	}
//
//
//	public List<Rate> getRateByParams(String carType, Timestamp startDate, Timestamp endDate) {
//		// TODO Auto-generated method stub
//		return rateDao.findByCarTypeAndStartDateGreaterThanEqualAndEndDateLessThanEqual(carType, (Timestamp)startDate, (Timestamp)endDate);
//	}
//
//
//	public Rate addRate(Rate rate) {
//		// TODO Auto-generated method stub
//		return rateDao.save(rate);
//	}

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

        // Call the Rent Predictor microservice
        return restTemplate.postForObject(rentPredictorUrl, rentRequest, RentPredictionResponse.class);
		
	}

	public List<Car> getAllCars() {
		return fleetDao.findAll();
	}

	public Car addCar(Car car) {
		return fleetDao.save(car);
	}

	public List<Car> getCars(String carNo, Integer carYear, String carMake, String carModel, String carTrim,
			String carBody, String carTransmission, Integer carCondition, Float carOdometer, String carFleetNo) {
	
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
	}
	
	
	

}
