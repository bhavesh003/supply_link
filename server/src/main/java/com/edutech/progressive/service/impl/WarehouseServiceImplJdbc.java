package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.dao.WarehouseDAO;
import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.service.WarehouseService;

public class WarehouseServiceImplJdbc implements WarehouseService {
private WarehouseDAO warehouseDAO;
 
    public WarehouseServiceImplJdbc(WarehouseDAO warehouseDAO) {
    this.warehouseDAO = warehouseDAO;
}
 
    @Override
    public List<Warehouse> getAllWarehouses()throws SQLException {
           try{
       return warehouseDAO.getAllWarehouse();
        }catch(SQLException e){
           throw e;
        }finally{
 
        }
    }
 
    @Override
    public int addWarehouse(Warehouse warehouse) throws SQLException{
           try{
         return warehouseDAO.addWarehouse(warehouse);
    }catch(SQLException e){
        throw e;
    }finally{
 
    }
    }
 
    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() throws SQLException{
          try{
        List<Warehouse> sortWarehouses=warehouseDAO.getAllWarehouse();
        Collections.sort(sortWarehouses,Comparator.comparing(Warehouse::getCapacity));
        return sortWarehouses;
       }catch(SQLException e){
        throw e;
       }
       finally{
 
       }
    }
    @Override
     public  void updateWarehouse(Warehouse warehouse)throws SQLException {
        try{
     warehouseDAO.updateWarehouse(warehouse);
        }catch(SQLException e){
            throw e;
        }finally{
 
        }
    }
    @Override
    public  void deleteWarehouse(int warehouseId)throws SQLException {
           try{
        warehouseDAO.deleteWarehouse(warehouseId);
      }catch(SQLException e){
        throw e;
      }finally{
      }
    }
    @Override
    public  Warehouse getWarehouseById(int warehouseId)throws SQLException {
           try{
              return warehouseDAO.getWarehouseById(warehouseId);
    }catch(SQLException e){
        throw e;
    }finally{
 
    }
    }
 
 
}