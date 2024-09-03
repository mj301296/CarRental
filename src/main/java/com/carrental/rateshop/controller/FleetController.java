package com.carrental.rateshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carrental.rateshop.model.Car;
import com.carrental.rateshop.model.RentPredictionRequest;
import com.carrental.rateshop.model.RentPredictionResponse;
import com.carrental.rateshop.service.FleetService;



@RestController
@RequestMapping("fleet")
public class FleetController {
	@Autowired
	FleetService fleetService ;
	
	@GetMapping("/health")
	public String health()
	{
		return "Hello";
	}

	@PostMapping("add-car")
	public Car addRate(@RequestBody Car car) {
		return fleetService.addCar(car);
	}
	
	@GetMapping("all-cars")
	public List<Car> getAllRates() {
		
		return fleetService.getAllCars();
	}
	
	@GetMapping("/search")
    public List<Car> getCars(
        @RequestParam(required = false) String carNo,
        @RequestParam(required = false) Integer carYear,
        @RequestParam(required = false) String carMake,
        @RequestParam(required = false) String carModel,
    	@RequestParam(required = false) String carTrim,
    	@RequestParam(required = false) String carBody,
    	@RequestParam(required = false) String carTransmission,
    	@RequestParam(required = false) Integer carCondition,
    	@RequestParam(required = false) Float carOdometer,
    	@RequestParam(required = false) String carFleetNo) {
        
        return fleetService.getCars(carNo, carYear, carMake, carModel, carTrim, carBody, carTransmission, carCondition, carOdometer, carFleetNo);
	}
	
//	@PostMapping("/update-car"){
//		
//	}
	
    @PostMapping("/predict-rent")
    public ResponseEntity<?> predictRent(@RequestBody RentPredictionRequest request) {
        try {
            RentPredictionResponse rent = fleetService.predictRent(request);
            return ResponseEntity.ok(rent);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
