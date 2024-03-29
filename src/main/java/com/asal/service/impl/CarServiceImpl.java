package com.asal.service.impl;

import com.asal.DAO.CarDAO;
import com.asal.DTO.BasicItem;
import com.asal.DTO.CarDetails;
import com.asal.DTO.CarStatus;
import com.asal.constants.Constants;
import com.asal.model.Car;
import com.asal.model.Manufacturer;
import com.asal.service.base.CarService;
import com.asal.service.base.ManufacturerService;
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
                car = carDAO.save(car);
                CarStatus carStatus = new CarStatus(
                        Constants.CarEngineStatus.FUNCTIONING.name(),
                        Constants.TransmissionSystemHealth.EXCELLENT.name(),
                        Constants.Fuel.FULL.name()
                );
                this.updateCarStatus(car.getId(), carStatus);
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

    @Override
    public int updateCarStatus(Integer carId, CarStatus carStatus) {
        try {
            Car car = carDAO.findCarById(carId);
            if (car != null) {
                car.setCarEngineStatus(Constants.CarEngineStatus.valueOf(carStatus.getEngineStatus()));
                car.setTransmissionSystemHealth(Constants.TransmissionSystemHealth.valueOf(carStatus.getTransmissionSystemHealth()));
                car.setFuel(Constants.Fuel.valueOf(carStatus.getFuel()));
                carDAO.save(car);
                return 1;
            }
            return -1;
        }catch (Exception e) {
            return -1;
        }
    }


    private int setCarSelected(int carId, boolean selected) {
        try {
            Car car = carDAO.findCarById(carId);
            if (car.getIsSelected() && selected) {
                return -2;
            }
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
            if (carDetails.getId()!= null) {
                car.setId(carDetails.getId());
            }
            if (carDetails.getPlateLicense()!= null) {
                car.setPlateLicense(carDetails.getPlateLicense());
            }
            car.setSeatCount(carDetails.getSeatCount());
            car.setIsConvertible(carDetails.isConvertible());
            if (carDetails.getEngineType()!= null) {
                car.setEngineType(carDetails.getEngineType());
            }
            car.setRating(carDetails.getRating());
            car.setIsSelected(carDetails.isSelected());
            if (carDetails.getCreatedOn()!= null) {
                car.setCreatedOn(carDetails.getCreatedOn());
            }
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
            if (car.getId() != null) {
                carDetails.setId(car.getId());
            }
            if (car.getPlateLicense() != null) {
                carDetails.setPlateLicense(car.getPlateLicense());
            }
            if (car.getSeatCount() != null) {
                carDetails.setSeatCount(car.getSeatCount());
            }
            if (car.getIsConvertible() != null) {
                carDetails.setConvertible(car.getIsConvertible());
            }

            if (car.getEngineType() != null) {
                carDetails.setEngineType(car.getEngineType());
            }
            if (car.getRating() != null) {
                carDetails.setRating(car.getRating());
            }
            if (car.getManufacturer().getId() != null) {
                carDetails.setManufacturerId(car.getManufacturer().getId());
            }
            if (car.getIsSelected() != null) {
                carDetails.setSelected(car.getIsSelected());
            }
            if (car.getCreatedOn() != null) {
                carDetails.setCreatedOn(car.getCreatedOn());
            }
            if (car.getCarEngineStatus() != null) {
                carDetails.setEngineStatus(car.getCarEngineStatus().name());
            }
            if (car.getTransmissionSystemHealth() != null) {
                carDetails.setTransmissionSystemHealth(car.getTransmissionSystemHealth().name());
            }
            if (car.getFuel() != null) {
                carDetails.setFuel(car.getFuel().name());
            }
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
