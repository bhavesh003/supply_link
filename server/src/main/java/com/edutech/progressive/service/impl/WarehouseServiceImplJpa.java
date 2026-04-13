package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.repository.WarehouseRepository;
import com.edutech.progressive.service.WarehouseService;

import java.sql.SQLException;

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
    private WarehouseRepository warehouseRepository;

    public WarehouseServiceImplJpa() {
    }

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    @Override
    public int addWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse).getWarehouseId();
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() {
        List<Warehouse> sortedWarehouses = warehouseRepository.findAll();
        Collections.sort(sortedWarehouses);
        return sortedWarehouses;
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    @Override
    public void deleteWarehouse(int warehouseId) {
        warehouseRepository.deleteById(warehouseId);
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) {
        return warehouseRepository.findByWarehouseId(warehouseId);
    }

    @Override
    public List<Warehouse> getWarehouseBySupplier(int supplierId) {
        return warehouseRepository.findAllBySupplierId(supplierId);
    }
}