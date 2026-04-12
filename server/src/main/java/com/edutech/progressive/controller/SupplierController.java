package com.edutech.progressive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.exception.SupplierAlreadyExistsException;
import com.edutech.progressive.exception.SupplierDoesNotExistException;
import com.edutech.progressive.service.impl.SupplierServiceImplArraylist;
import com.edutech.progressive.service.impl.SupplierServiceImplJpa;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierServiceImplArraylist supplierServiceImplArraylist;

    @Autowired
    SupplierServiceImplJpa supplierServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() throws SQLException {
        List<Supplier> suppliers = supplierServiceImplJpa.getAllSuppliers();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    public ResponseEntity<?> getSupplierById(@PathVariable int supplierId) throws SQLException {
        try {
            Supplier supplier = supplierServiceImplJpa.getSupplierById(supplierId);
            if (supplier == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(supplier, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> addSupplier(@RequestBody Supplier supplier) throws SQLException {
        try {
            int supplierId = supplierServiceImplJpa.addSupplier(supplier);
            return new ResponseEntity<>(supplierId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{supplierId}")
    public ResponseEntity<?> updateSupplier(@PathVariable int supplierId, @RequestBody Supplier supplier)
            throws SQLException {
        try {
            supplier.setSupplierId(supplierId);
            supplierServiceImplJpa.updateSupplier(supplier);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{supplierId}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable int supplierId) throws SQLException {
        try {
            supplierServiceImplJpa.deleteSupplier(supplierId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Supplier>> getAllSuppliersFromArrayList() {
        List<Supplier> suppliers = supplierServiceImplArraylist.getAllSuppliers();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Integer> addSupplierToArrayList(@RequestBody Supplier supplier) {
        int listSize = supplierServiceImplArraylist.addSupplier(supplier);
        return new ResponseEntity<>(listSize, HttpStatus.CREATED);
    }

    @GetMapping("/fromArrayList/all")
    public ResponseEntity<List<Supplier>> getAllSuppliersSortedByNameFromArrayList() {
        List<Supplier> supplierList = supplierServiceImplArraylist.getAllSuppliersSortedByName();
        return new ResponseEntity<>(supplierList, HttpStatus.OK);
    }
}