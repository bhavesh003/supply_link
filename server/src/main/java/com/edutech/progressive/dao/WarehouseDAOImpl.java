package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Warehouse;

public class WarehouseDAOImpl implements WarehouseDAO {

    @Override
    public int addWarehouse(Warehouse warehouse) throws SQLException {
        int generatedID = -1;

        String sql = "INSERT INTO warehouse (supplier_id, warehouse_name, location, capacity) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, warehouse.getSupplierId());
            statement.setString(2, warehouse.getWarehouseName());
            statement.setString(3, warehouse.getLocation());
            statement.setInt(4, warehouse.getCapacity());

            statement.executeUpdate();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    generatedID = resultSet.getInt(1);
                    warehouse.setWarehouseId(generatedID);
                }
            }
        }

        return generatedID;
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) throws SQLException {
        String sql = "SELECT * FROM warehouse WHERE warehouse_id = ?";

        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, warehouseId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int supplierId = resultSet.getInt("supplier_id");
                    String warehouseName = resultSet.getString("warehouse_name");
                    String location = resultSet.getString("location");
                    int capacity = resultSet.getInt("capacity");

                    return new Warehouse(warehouseId, supplierId, warehouseName, location, capacity);
                }
            }
        }

        return null;
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) throws SQLException {
        String sql = "UPDATE warehouse SET supplier_id = ?, warehouse_name = ?, location = ?, capacity = ? WHERE warehouse_id = ?";

        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, warehouse.getSupplierId());
            statement.setString(2, warehouse.getWarehouseName());
            statement.setString(3, warehouse.getLocation());
            statement.setInt(4, warehouse.getCapacity());
            statement.setInt(5, warehouse.getWarehouseId());

            statement.executeUpdate();
        }
    }

    @Override
    public void deleteWarehouse(int warehouseId) throws SQLException {
        String sql = "DELETE FROM warehouse WHERE warehouse_id = ?";

        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, warehouseId);
            statement.executeUpdate();
        }
    }

    @Override
    public List<Warehouse> getAllWarehouse() throws SQLException {
        List<Warehouse> warehouses = new ArrayList<>();
        String sql = "SELECT * FROM warehouse";

        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int warehouseId = resultSet.getInt("warehouse_id");
                int supplierId = resultSet.getInt("supplier_id");
                String warehouseName = resultSet.getString("warehouse_name");
                String location = resultSet.getString("location");
                int capacity = resultSet.getInt("capacity");

                warehouses.add(new Warehouse(warehouseId, supplierId, warehouseName, location, capacity));
            }
        }

        return warehouses;
    }
}