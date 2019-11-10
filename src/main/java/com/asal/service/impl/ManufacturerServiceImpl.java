package com.asal.service.impl;

import com.asal.DAO.ManufacturerDAO;
import com.asal.model.Manufacturer;
import com.asal.service.base.ManufacturerService;
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
