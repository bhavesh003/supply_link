package com.edutech.progressive.dao;

import com.edutech.progressive.entity.Product;
import java.util.Collections;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public int addProduct(Product product) {
        return -1;
    }

    @Override
    public Product getProductById(int productId) {
        return null;
    }

    @Override
    public void updateProduct(Product product) {
        // Empty implementation
    }

    @Override
    public void deleteProduct(int productId) {
        // Empty implementation
    }

    @Override
    public List<Product> getAllProducts() {
        return Collections.emptyList();
    }
}

