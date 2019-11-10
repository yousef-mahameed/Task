package com.asal.DAO;

import com.asal.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDAO extends CrudRepository<Car, Integer> {

    public Car findCarById(int id);
}
