package com.edutech.progressive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.exception.SupplierAlreadyExistsException;
import com.edutech.progressive.exception.SupplierDoesNotExistException;
import com.edutech.progressive.repository.ProductRepository;
import com.edutech.progressive.repository.ShipmentRepository;
import com.edutech.progressive.repository.SupplierRepository;
import com.edutech.progressive.repository.WarehouseRepository;
import com.edutech.progressive.service.SupplierService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SupplierServiceImplJpa implements SupplierService {

    @Override
    public List<Supplier> getAllSuppliers() throws SQLException {
        return new ArrayList<>();
    }

    @Override
    public int addSupplier(Supplier supplier) throws SQLException {
        return -1;
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() throws SQLException {
        return new ArrayList<>();
    }

    public void updateSupplier(Supplier supplier) throws SQLException {
    }

    public void deleteSupplier(int supplierId) throws SQLException {
    }

    public Supplier getSupplierById(int supplierId) throws SQLException {
        return null;
    }

}