package com.asal.car.service.impl;

import com.asal.car.DAO.ManufacturerDAO;
import com.asal.car.model.Manufacturer;
import com.asal.car.service.base.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    ManufacturerDAO manufacturerDAO;

    @Override
    public Manufacturer findManufacturerById(Integer id) {
        return manufacturerDAO.findManufacturerById(id);
    }
}
