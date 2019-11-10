package com.asal.controller;

import com.asal.customException.CarInUseException;
import com.asal.service.base.CarService;
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
        int status = carService.selectCar(carId);
        if (status == -2) {
            throw new CarInUseException(
                    "Car already selected",
                    "Car is currently used by other driver",
                    "Try to select another car or wait for this to be not in use"
            );
        }
        else {
            return status;
        }
    }

    @PostMapping(value = "/deselectCar")
    public Integer deselectCar(@RequestParam(name = "carId") Integer carId) throws CarInUseException {
        return carService.deselectCar(carId);
    }
}
