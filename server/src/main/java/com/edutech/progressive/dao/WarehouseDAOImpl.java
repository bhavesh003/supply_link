package com.edutech.progressive.dao;

import com.edutech.progressive.entity.Warehouse;
import java.util.List;

public class WarehouseDAOImpl implements WarehouseDAO {

    @Override
    public int addWarehouse(Warehouse warehouse) {
        return -1;
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) {
        return null;
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) {
        // No operation performed
    }

    @Override
    public void deleteWarehouse(int warehouseId) {
        // No operation performed
    }

    @Override
    public List<Warehouse> getAllWarehouse() {
        return List.of();
    }
}
