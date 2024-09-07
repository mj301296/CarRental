package com.carrental.rateshop.model;
import org.springframework.data.jpa.domain.Specification;

public class CarSpecifications {

    // Specification for carNo
    public static Specification<Car> hasCarNo(String carNo) {
        return (root, query, criteriaBuilder) -> 
            carNo == null ? null : criteriaBuilder.equal(root.get("carNo"), carNo);
    }

    // Specification for carYear
    public static Specification<Car> hasCarYear(Integer carYear) {
        return (root, query, criteriaBuilder) -> 
            carYear == null ? null : criteriaBuilder.equal(root.get("carYear"), carYear);
    }

    // Specification for carMake
    public static Specification<Car> hasCarMake(String carMake) {
        return (root, query, criteriaBuilder) -> 
            carMake == null ? null : criteriaBuilder.equal(root.get("carMake"), carMake);
    }

    // Specification for carModel
    public static Specification<Car> hasCarModel(String carModel) {
        return (root, query, criteriaBuilder) -> 
            carModel == null ? null : criteriaBuilder.equal(root.get("carModel"), carModel);
    }

    // Specification for carTrim
    public static Specification<Car> hasCarTrim(String carTrim) {
        return (root, query, criteriaBuilder) -> 
            carTrim == null ? null : criteriaBuilder.equal(root.get("carTrim"), carTrim);
    }

    // Specification for carBody
    public static Specification<Car> hasCarBody(String carBody) {
        return (root, query, criteriaBuilder) -> 
            carBody == null ? null : criteriaBuilder.equal(root.get("carBody"), carBody);
    }

    // Specification for carTransmission
    public static Specification<Car> hasCarTransmission(String carTransmission) {
        return (root, query, criteriaBuilder) -> 
            carTransmission == null ? null : criteriaBuilder.equal(root.get("carTransmission"), carTransmission);
    }

    // Specification for carCondition
    public static Specification<Car> hasCarCondition(Integer carCondition) {
        return (root, query, criteriaBuilder) -> 
            carCondition == null ? null : criteriaBuilder.equal(root.get("carCondition"), carCondition);
    }

    // Specification for carOdometer
    public static Specification<Car> hasCarOdometer(Float carOdometer) {
        return (root, query, criteriaBuilder) -> 
            carOdometer == null ? null : criteriaBuilder.equal(root.get("carOdometer"), carOdometer);
    }

    // Specification for carFleetNo
    public static Specification<Car> hasCarFleetNo(String carFleetNo) {
        return (root, query, criteriaBuilder) -> 
            carFleetNo == null ? null : criteriaBuilder.equal(root.get("carFleetNo"), carFleetNo);
    }

	public static Specification<Car> hasCarGasReading(Integer carGasReading) {
        return (root, query, criteriaBuilder) -> 
        carGasReading == null ? null : criteriaBuilder.equal(root.get("carGasReading"), carGasReading);
	}

	public static Specification<Car> hasCarStatus(String carStatus) {
		return (root, query, criteriaBuilder) -> 
		carStatus == null ? null : criteriaBuilder.equal(root.get("carStatus"), carStatus);
	}
}
