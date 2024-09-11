package com.carrental.rateshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    FleetService fleetService;

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Fleet service online...");
    }

    @PutMapping("add-car")
    public ResponseEntity<?> addCar(@RequestBody Car car) {
        try {
            if (car == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Car details cannot be null.");
            }
            System.out.println(car.toString());
            Car addedCar = fleetService.addCar(car);
            return ResponseEntity.ok(addedCar);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding car: " + e.getMessage());
        }
    }

    @DeleteMapping("delete-car")
    public ResponseEntity<?> deleteCar(@RequestParam String carNo) {
        try {
            if (carNo == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Car details cannot be null.");
            }
            String message = fleetService.deleteCar(carNo);
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting car: " + e.getMessage());
        }
    }

    @GetMapping("all-cars")
    public ResponseEntity<?> getAllCars() {
        try {
            System.out.println("All cars request");
            List<Car> cars = fleetService.getAllCars();
            return ResponseEntity.ok(cars);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching cars: " + e.getMessage());
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> getCars(
            @RequestParam(required = false) String carNo,
            @RequestParam(required = false) Integer carYear,
            @RequestParam(required = false) String carMake,
            @RequestParam(required = false) String carModel,
            @RequestParam(required = false) String carTrim,
            @RequestParam(required = false) String carBody,
            @RequestParam(required = false) String carTransmission,
            @RequestParam(required = false) Integer carCondition,
            @RequestParam(required = false) Float carOdometer,
            @RequestParam(required = false) String carFleetNo,
            @RequestParam(required = false) Integer carGasReading,
            @RequestParam(required = false) String carStatus) {
        try {
            List<Car> cars = fleetService.getCars(carNo, carYear, carMake, carModel, carTrim, carBody, carTransmission,
                    carCondition, carOdometer, carFleetNo, carGasReading, carStatus);
            return ResponseEntity.ok(cars);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error searching cars: " + e.getMessage());
        }
    }

    @PostMapping("/predict-rent")
    public ResponseEntity<?> predictRent(@RequestBody RentPredictionRequest request) {
        try {
            if (request == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Prediction request cannot be null.");
            }
            RentPredictionResponse rent = fleetService.predictRent(request);
            return ResponseEntity.ok(rent);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error predicting rent: " + e.getMessage());
        }
    }
}
