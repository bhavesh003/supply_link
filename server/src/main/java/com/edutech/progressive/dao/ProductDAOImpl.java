package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Product;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public int addProduct(Product product) throws SQLException {
        int generatedID = -1;

        String sql = "INSERT INTO product (warehouse_id, product_name, product_description, quantity, price) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, product.getWarehouseId());
            statement.setString(2, product.getProductName());
            statement.setString(3, product.getProductDescription());
            statement.setInt(4, product.getQuantity());
            statement.setLong(5, product.getPrice());

            statement.executeUpdate();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    generatedID = resultSet.getInt(1);
                    product.setProductId(generatedID);
                }
            }
        }

        return generatedID;
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        String sql = "SELECT * FROM product WHERE product_id = ?";

        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, productId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int warehouseId = resultSet.getInt("warehouse_id");
                    String productName = resultSet.getString("product_name");
                    String productDescription = resultSet.getString("product_description");
                    int quantity = resultSet.getInt("quantity");
                    Long price = resultSet.getLong("price");

                    return new Product(productId, warehouseId, productName, productDescription, quantity, price);
                }
            }
        }

        return null;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        String sql = "UPDATE product SET warehouse_id = ?, product_name = ?, product_description = ?, quantity = ?, price = ? WHERE product_id = ?";

        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, product.getWarehouseId());
            statement.setString(2, product.getProductName());
            statement.setString(3, product.getProductDescription());
            statement.setInt(4, product.getQuantity());
            statement.setLong(5, product.getPrice());
            statement.setInt(6, product.getProductId());

            statement.executeUpdate();
        }
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        String sql = "DELETE FROM product WHERE product_id = ?";

        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, productId);
            statement.executeUpdate();
        }
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                int warehouseId = resultSet.getInt("warehouse_id");
                String productName = resultSet.getString("product_name");
                String productDescription = resultSet.getString("product_description");
                int quantity = resultSet.getInt("quantity");
                Long price = resultSet.getLong("price");

                products.add(new Product(productId, warehouseId, productName, productDescription, quantity, price));
            }
        }

        return products;
    }
}