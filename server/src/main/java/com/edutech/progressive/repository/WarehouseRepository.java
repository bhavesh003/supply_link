package com.edutech.progressive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edutech.progressive.entity.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

    Warehouse findByWarehouseId(int warehouseId);

    @Transactional
    void deleteByWarehouseId(int warehouseId);

    List<Warehouse> findBySupplier_SupplierId(int supplierId);
}