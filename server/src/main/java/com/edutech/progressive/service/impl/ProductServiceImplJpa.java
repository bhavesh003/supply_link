package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Product;
import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.exception.InsufficientCapacityException;
import com.edutech.progressive.repository.ProductRepository;
import com.edutech.progressive.repository.ShipmentRepository;
import com.edutech.progressive.repository.WarehouseRepository;
import com.edutech.progressive.service.ProductService;

@Service
public class ProductServiceImplJpa implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    ShipmentRepository shipmentRepository;

    @Autowired
    public ProductServiceImplJpa(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        return productRepository.findByProductId(productId);
    }

    @Override
    public int addProduct(Product product) throws InsufficientCapacityException {
        Warehouse warehouse = warehouseRepository.findByWarehouseId(product.getWarehouse().getWarehouseId());
        List<Product> products = productRepository.findAllByWarehouse_WarehouseId(warehouse.getWarehouseId());
        int count = 0;
        for (Product p : products) {
            count += p.getQuantity();
        }
        if (count + product.getQuantity() > warehouse.getCapacity()) {
            throw new InsufficientCapacityException(
                    "Warehouse has reached its maximum capacity of " + warehouse.getCapacity() + " products.");
        }
        return productRepository.save(product).getProductId();
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        productRepository.save(product).getProductId();
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        shipmentRepository.deleteByProductId(productId);
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> getAllProductByWarehouse(int warehouseId) throws SQLException {
        return productRepository.findAllByWarehouse_WarehouseId(warehouseId);
    }
}