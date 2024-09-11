# rateshop-backend

# Rateshop Backend

This repository is part of the **Car Rental Front Office Operations** application, which consists of the following components:

- [**CarRentalPricingPrediction**](https://github.com/mj301296/CarRentalPricingPrediction): A Python package for predicting car rental prices.
- [**CarRentalPredictionApi**](https://github.com/mj301296/CarRentalPredictionApi): A FastAPI microservice that provides car rental price predictions.
- [**Rateshop Backend**](https://github.com/mj301296/RateShop): A Spring Boot application that handles car fleet management.
- [**Rateshop Frontend**](https://github.com/mj301296/rateshop-frontend): A React application offering an interactive user interface for managing car fleet operations.

## Overview

The **Rateshop Backend** is a Spring Boot application designed to manage and maintain information about a car fleet. It leverages Hibernate and JPA for object-relational mapping (ORM) and interacts with a PostgreSQL database to store and retrieve car details.

### Technologies Used

- **Spring Boot**: A framework for building production-ready applications with minimal configuration.
- **Hibernate**: An ORM framework for mapping Java objects to database tables, handling data persistence.
- **JPA (Java Persistence API)**: Provides a standard for object-relational mapping in Java, used here to manage database interactions.
- **PostgreSQL**: The relational database management system used for storing car fleet information.

## Explanation of Files and Directories

- **`src/`**: Contains the source code of the application.
  - **`main/java/com/carrental/rateshop/`**: Houses the main application and its components.
    - **`RateshopApplication.java`**: The main Spring Boot application class that serves as the entry point.
    - **`config/`**: Configuration classes for setting up application-specific properties and beans.
      - **`WebConfig.java/`**: Configures CORS settings for the Spring Boot application to control how resources are shared across different domains.
    - **`controller/`**: REST controllers for handling HTTP requests and responses.
      - **`FleetController.java/`**: REST controller that handles HTTP requests related to car management and rental price predictions.
    - **`dao/`**: Data Access Objects (DAOs) for interacting with the database. Contains repositories that use JPA for CRUD operations.
      - **`FleetDao.java/`**: The FleetDao interface provides data access methods for interacting with the car data in the database.
    - **`model/`**: Data models representing entities such as `Car`. Uses JPA annotations for mapping to database tables.
      - **`Car.java/`**: Defines the attributes and behavior of a car entity for persistence in the database.
      - **`CarSpecifications.java/`**: Provides methods to create JPA Specification instances for filtering Car entities based on different attributes.
      - **`RentPredictionRequest.java/`**: To define the data structure for car rental price prediction requests.
      - **`RentPredictionResponse.java/`**: To define the data structure for car rental price prediction responses.
    - **`service/`**: Service classes that contain business logic and interact with DAOs.
      - **`FleetService.java/`**: It handles business logic related to car fleet operations and communicates with the Rent Predictor microservice to get rental price predictions.
  - **`resources/`**: 
    - **`application.properties`**: Configuration properties for the Spring Boot application. Includes database settings and external service URLs.
- **`Dockerfile`**: Configuration file for building a Docker image of the application.
- **`rateshop-backend-deployment.yaml`**: Kubernetes deployment configuration for deploying the application in a Kubernetes cluster.
- **`pom.xml`**: Maven project descriptor specifying project dependencies and build configurations.

### API Endpoints

#### **Backend**

- `GET fleet/all-cars`: Retrieve all cars.
- `PUT fleet/add-car`: Add or Update a car.
- `GET fleet/search`: Search for cars with specific criteria.
- `DELETE fleet/{carNo}`: Delete a car by its number.
- `POST fleet/predit-rent`: Calls CarRentalPredictionApi app to predict rental prices based on car attributes


## Installation

To get started with the Rateshop Backend, follow these steps:

1. **Configure Environment Variables**

   Create a `.env` file in the root directory and add the following variables:

    ```properties
    DB_URL=jdbc:postgresql://localhost:5432/rateshop
    DB_USERNAME=postgres
    DB_PASSWORD=postgres
    RENT_PREDICTOR_URL=http://localhost:8000
    RATESHOP_FRONTEND_URL=http://localhost:3000
    ```

2.  **Build the Project**

    Build the project using Maven:

    ```bash
    ./mvnw clean package
    ```

3. **Build the Docker Image**

    Create a Docker image of the application:

    ```bash
    docker build -t rateshop-backend .
    ```

## Running the Application

### Locally

1. **Run the Application in Docker**

    Start the application using Docker:

    ```bash
    docker run -p 8080:8080 rateshop-backend
    ```

2. **Sample Request**

    Test the API endpoint using `curl`:

    ```bash
    curl -X POST "http://localhost:8080/fleet/predict-rent" \
    -H "Content-Type: application/json" \
    -d '{
        "year": 2013,
        "make": "Toyota",
        "trim": "LE",
        "body": "Sedan",
        "condition": 4,
        "odometer": 15000.5,
        "transmission": "automatic"
    }'
    ```

## Kubernetes Deployment

For deploying the application on Kubernetes, refer to the README of [**Rateshop Frontend**](https://github.com/mj301296/rateshop-frontend).

