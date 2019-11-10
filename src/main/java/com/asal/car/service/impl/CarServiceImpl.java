package com.asal.car.service.impl;

import com.asal.car.DAO.CarDAO;
import com.asal.car.DTO.BasicItem;
import com.asal.car.DTO.CarDetails;
import com.asal.car.model.Car;
import com.asal.car.model.Manufacturer;
import com.asal.car.service.base.CarService;
import com.asal.car.service.base.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarDAO carDAO;

    @Autowired
    ManufacturerService manufacturerService;

    @Override
    public int insertCar(CarDetails carDetails) {
        try {
            Car car = convertToEntity(carDetails);
            if (car != null) {
                car.setIsSelected(false);
                car.setCreatedOn(ZonedDateTime.now());
                carDAO.save(car);
                return 1;
            }
            return -1;
        }catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int updateCar(int id, CarDetails carDetails) {
        try {
            Car origCar = carDAO.findCarById(id);
            if (origCar != null) {
                Car newCar = convertToEntity(carDetails);
                if (newCar != null) {
                    if (newCar.getIsConvertible() != null) {
                        origCar.setIsConvertible(newCar.getIsConvertible());
                    }
                    if (newCar.getEngineType() != null) {
                        origCar.setEngineType(newCar.getEngineType());
                    }
                    if (newCar.getPlateLicense() != null) {
                        origCar.setPlateLicense(newCar.getPlateLicense());
                    }
                    if (newCar.getRating() != null) {
                        origCar.setRating(newCar.getRating());
                    }
                    if (newCar.getSeatCount() != null) {
                        origCar.setSeatCount(newCar.getSeatCount());
                    }
                    if (newCar.getManufacturer() != null) {
                        origCar.setManufacturer(newCar.getManufacturer());
                    }
                    carDAO.save(origCar);
                    return 1;
                }
            }
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int deleteCar(int id) {
        try {
            Car car = carDAO.findCarById(id);
            carDAO.delete(car);
            return 1;
        }catch (Exception e) {
            //TODO add logs
            return -1;
        }
    }

    @Override
    public CarDetails findCarById(int id) {
        try {
            Car car = carDAO.findCarById(id);
            return convertToDTO(car);
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<CarDetails> getAllCars() {
        try {
            Iterable<Car> iterable = carDAO.findAll();
            List<CarDetails> cars = new ArrayList<>();
            iterable.forEach(car -> cars.add(convertToDTO(car)));
            return cars;
        }catch (Exception e) {
            return null;
        }
    }
    @Override
    public int selectCar(Integer carId) {
        return setCarSelected(carId, true);
    }

    @Override
    public int deselectCar(Integer carId) {
        return setCarSelected(carId, false);
    }


    private int setCarSelected(int carId, boolean selected) {
        try {
            Car car = carDAO.findCarById(carId);
            if (car != null) {
                car.setIsSelected(selected);
                carDAO.save(car);
                return 1;
            }
            return -1;
        }
        catch (Exception e) {
            return -1;
        }
    }


    //the next methods should be moved another layer such as Facade
    private Car convertToEntity(CarDetails carDetails) {
        if (carDetails != null) {
            Car car = new Car();
            car.setId(carDetails.getId());
            car.setPlateLicense(carDetails.getPlateLicense());
            car.setSeatCount(carDetails.getSeatCount());
            car.setIsConvertible(carDetails.isConvertible());
            car.setEngineType(carDetails.getEngineType());
            car.setRating(carDetails.getRating());
            car.setIsSelected(carDetails.isSelected());
            car.setCreatedOn(carDetails.getCreatedOn());
            Manufacturer manufacturer = manufacturerService.findManufacturerById(carDetails.getManufacturerId());
            if (manufacturer == null) {
                return null;
            }
            car.setManufacturer(manufacturer);
            return car;
        }
        return null;
    }

    private CarDetails convertToDTO (Car car) {
        if (car != null) {
            CarDetails carDetails = new CarDetails();
            carDetails.setId(car.getId());
            carDetails.setPlateLicense(car.getPlateLicense());
            carDetails.setSeatCount(car.getSeatCount());
            carDetails.setConvertible(car.getIsConvertible());
            carDetails.setEngineType(car.getEngineType());
            carDetails.setRating(car.getRating());
            carDetails.setManufacturerId(car.getManufacturer().getId());
            carDetails.setSelected(car.getIsSelected());
            carDetails.setCreatedOn(car.getCreatedOn());
            return carDetails;
        }
        return null;
    }

    private BasicItem convertToBasicItem (Car car) {
        if (car != null) {
            BasicItem carDetails = new BasicItem();
            carDetails.setId(car.getId());
            carDetails.setValue(car.getPlateLicense());
            return carDetails;
        }
        return null;
    }
}
