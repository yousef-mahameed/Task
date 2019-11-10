package com.asal.car.service.base;

import com.asal.car.DTO.CarDetails;

import java.util.List;

public interface CarService {

    public int insertCar(CarDetails car);
    public int updateCar(int id, CarDetails car);
    public int deleteCar(int id);
    public CarDetails findCarById(int id);
    public List<CarDetails> getAllCars();

    public int selectCar(Integer carId);
    public int deselectCar(Integer carId);
}
