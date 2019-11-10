package com.asal.car.controller;

import com.asal.car.customException.CarInUseException;
import com.asal.car.service.base.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/drivers")
public class DriverController {

    @Autowired
    CarService carService;

    @PostMapping(value = "/selectCar")
    public Integer selectCar(@RequestParam(name = "carId") Integer carId) throws CarInUseException {
        return carService.selectCar(carId);
    }

    @PostMapping(value = "/deselectCar")
    public Integer deselectCar(@RequestParam(name = "carId") Integer carId) throws CarInUseException {
        return carService.deselectCar(carId);
    }
}
