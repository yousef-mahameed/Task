package com.asal.controller;

import com.asal.DTO.CarDetails;
import com.asal.service.base.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping(value = {"", "/"})
    public List<CarDetails> findAllCars() {
        try {
            return carService.getAllCars();
        } catch (Exception e) {
            // TODO add logs
            return null;
        }
    }

    @GetMapping(value = "/{id}")
    public CarDetails getCarById(@PathVariable("id") Integer id) {
        try {
            return carService.findCarById(id);
        } catch (Exception e) {
            // TODO add logs
            return null;
        }
    }

    @PutMapping(value = "/insertCar")
    public int insertCar(@RequestBody CarDetails carDetails) {
        try {
            return carService.insertCar(carDetails);
        } catch (Exception e) {
            return -1;
        }
    }

    @PutMapping(value = "/updateCar/{id}")
    public int updateCar(@PathVariable("id") Integer id, @RequestBody CarDetails carDetails) {
        try {
            return carService.updateCar(id, carDetails);
        } catch (Exception e) {
            return -1;
        }
    }

    @DeleteMapping(value = "/deleteCar")
    public int deleteCar(@RequestParam("id") Integer id) {
        try {
            return carService.deleteCar(id);
        } catch (Exception e) {
            return -1;
        }
    }

}
