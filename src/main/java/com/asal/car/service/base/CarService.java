package com.asal.car.service.base;

import com.asal.car.DTO.CarDetails;
import com.asal.car.model.Car;

import java.util.List;

public interface CarService {

    public int insertCar(CarDetails car);
    public int updateCar(int id, CarDetails car);
    public int deleteCar(int id);
    public CarDetails findCarById(int id);
    public List<CarDetails> getAllCars();

}
