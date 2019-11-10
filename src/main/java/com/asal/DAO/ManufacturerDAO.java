package com.asal.DAO;

import com.asal.model.Manufacturer;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturerDAO extends CrudRepository<Manufacturer, Integer> {

    public Manufacturer findManufacturerById(Integer id);
}
