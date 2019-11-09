package com.asal.car.DAO;

import com.asal.car.model.Manufacturer;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturerDAO extends CrudRepository<Manufacturer, Integer> {

    public Manufacturer findManufacturerById(Integer id);
}
