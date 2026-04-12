package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.repository.WarehouseRepository;
import com.edutech.progressive.service.WarehouseService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Warehouse;

import com.edutech.progressive.exception.NoWarehouseFoundForSupplierException;

import com.edutech.progressive.repository.ProductRepository;
import com.edutech.progressive.repository.ShipmentRepository;
import com.edutech.progressive.repository.WarehouseRepository;

import com.edutech.progressive.service.WarehouseService;

@Service
public class WarehouseServiceImplJpa implements WarehouseService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ShipmentRepository shipmentRepository;

    private WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseServiceImplJpa(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<Warehouse> getAllWarehouses() throws SQLException {
        return new ArrayList<>();
    }

    @Override
    public int addWarehouse(Warehouse warehouse) throws SQLException {
        return -1;
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() throws SQLException {
        return new ArrayList<>();
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) throws SQLException {
    }

    @Override
    public void deleteWarehouse(int warehouseId) throws SQLException {
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) throws SQLException {
        return null;
    }

    @Override
    public List<Warehouse> getWarehouseBySupplier(int supplierId) {
        return null;
    }
}