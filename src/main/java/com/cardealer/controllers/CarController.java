package com.cardealer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cardealer.models.Car;
import com.cardealer.services.CarService;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String availableCars(Model model){
        List<Car> availableCars = carService.findAvailableCars();
        model.addAttribute("availableCars", availableCars);
        return "availablecars";

    }

    //@PathVariable allows spring to extract data from the url path
    @GetMapping("/cardetails/{id}")
    public String carDetail(@PathVariable Long id, Model model){
        Car car = carService.findCarById(id);
        model.addAttribute("car", car);

        return "cardetails";
    }

    @GetMapping("/addcar")
    public String addCar(){

        return "addcar";
    }
}
