/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import cinema.Database;
import java.sql.*;
import entity.Service;
/**
 *
 * @author Lenovo
 */
public class ServiceDAO {
    private Connection getConnect() throws ClassNotFoundException, SQLException{
       return Database.getDB().connect();
    }
    public void addService(Service service) throws SQLException, ClassNotFoundException{
        String sql="insert into service values(?,?,?,?)";
        try(PreparedStatement pst=getConnect().prepareStatement(sql)){
            pst.setString(1,service.getId());
            pst.setString(2,service.getName());
            pst.setDouble(3,service.getPrice());
            pst.setInt(4,service.getQuantity());
            pst.executeUpdate();
        }
    }
    public void editService(Service service) throws SQLException, ClassNotFoundException{
        String sql="update service set service_name=?,service_price=?,service_quantity=? where service_id=?";
        try(PreparedStatement pst=getConnect().prepareStatement(sql)){           
            pst.setString(1,service.getName());
            pst.setDouble(2,service.getPrice());
            pst.setInt(3,service.getQuantity());
            pst.setString(4,service.getId());
            pst.executeUpdate();
        }
    }
    public void deleteService(String id) throws SQLException, ClassNotFoundException{
        String sql="delete from service where service_id=?";
        try(PreparedStatement pst=getConnect().prepareStatement(sql)){
            pst.setString(1,id);
            pst.executeUpdate();
        }
    }    
    
}
