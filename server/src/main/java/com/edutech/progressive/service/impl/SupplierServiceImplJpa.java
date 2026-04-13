package com.edutech.progressive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.repository.SupplierRepository;
import com.edutech.progressive.service.SupplierService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SupplierServiceImplJpa implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public SupplierServiceImplJpa() {
    }

    public SupplierServiceImplJpa(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public int addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier).getSupplierId();
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() {
        List<Supplier> sortedSuppliers = supplierRepository.findAll();
        Collections.sort(sortedSuppliers);
        return sortedSuppliers;
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void deleteSupplier(int supplierId) {
        supplierRepository.deleteBySupplierId(supplierId);
    }

    @Override
    public Supplier getSupplierById(int supplierId) {
        return supplierRepository.findBySupplierId(supplierId);
    }

}