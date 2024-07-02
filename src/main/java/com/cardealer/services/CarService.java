package com.cardealer.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cardealer.models.Car;
import com.cardealer.repositories.CarRepository;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> findAvailableCars(){
        List<Car> allCars = carRepository.findAll();
        List<Car> availableCars = new ArrayList<>();
        for(Car car: allCars){
            if(car.getIsAvailable()){
                availableCars.add(car);
            }
        }
        List<Car> discCars = discountedCars(availableCars);
        return discCars;
    }

    public Car findCarById(Long id){
        Optional<Car> car = carRepository.findById(id);
        return car.get();
    }

    public Car addCar(Car car){
        LocalDate currentDate = LocalDate.now();
        car.setDateAdded(currentDate);
        car.setDiscountApplied(false);
        Car savedCar = carRepository.save(car);
        return savedCar;
    }

    public List<Car> discountedCars(List<Car> cars){

        //iterate through all cars passed into the method
        for(Car car: cars){
            //check how long the car has been in inventory
            LocalDate startDate = car.getDateAdded();
            LocalDate endDate = LocalDate.now();
            long daysBetween = ChronoUnit.DAYS.between(startDate,endDate);
            if(daysBetween > 120 && car.getDiscountApplied() == false){
                //apply discount
                double newPrice = car.getPrice() * .90;
                //update car price, calling repository to save price in the database
                car.setPrice(newPrice);
                //ensure we only apply discount to cars once
                car.setDiscountApplied(true);
                carRepository.save(car);
            }
        }
        return cars;

    }
    public List<Car> findCarByModel(String model) {
        List<Car> cars = carRepository.findCarByModel(model);
        return cars;
    }

    
    
}
