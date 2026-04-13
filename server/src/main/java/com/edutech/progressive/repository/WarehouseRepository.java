package com.edutech.progressive.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edutech.progressive.entity.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
    Warehouse findByWarehouseId(int warehouseId);

    @Transactional
    void deleteBySupplierId(int supplierId);

    List<Warehouse> findAllBySupplierId(int supplierId);
}
