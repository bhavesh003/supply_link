package com.edutech.progressive.dao;

import com.edutech.progressive.entity.Supplier;
import java.util.Collections;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public int addSupplier(Supplier supplier) {
        return -1;
    }

    @Override
    public Supplier getSupplierById(int supplierId) {
        return null;
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        // Method body is empty
    }

    @Override
    public void deleteSupplier(int supplierId) {
        // Method body is empty
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return Collections.emptyList();
    }
}

