/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import cinema.Database;
import entity.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CustomerDAO {

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        return Database.getDB().connect();
    }

    public List<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM Customer";
        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Customer(
                        rs.getString("Cus_ID"),
                        rs.getString("Cus_name"),
                        rs.getString("Cus_phone"),
                        rs.getString("Cus_email")
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi tải dữ liệu khách hàng: " + e.getMessage());
        }
        return list;
    }

    public boolean insertCustomer(Customer c) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Customer (Cus_ID, Cus_name, Cus_phone, Cus_email) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getCusID());
            ps.setString(2, c.getCusName());
            ps.setString(3, c.getCusPhone());
            ps.setString(4, c.getCusEmail());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi thêm khách hàng: " + e.getMessage());
            return false;
        }
    }

    public boolean updateCustomer(Customer c) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Customer SET Cus_name=?, Cus_phone=?, Cus_email=? WHERE Cus_ID=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getCusName());
            ps.setString(2, c.getCusPhone());
            ps.setString(3, c.getCusEmail());
            ps.setString(4, c.getCusID());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi cập nhật khách hàng: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteCustomer(String cusID) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Customer WHERE Cus_ID=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cusID);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi xóa khách hàng: " + e.getMessage());
            return false;
        }
    }

    public List<Customer> searchByPhone(String keyword) throws SQLException, ClassNotFoundException {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM Customer WHERE Cus_phone LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Customer(
                        rs.getString("Cus_ID"),
                        rs.getString("Cus_name"),
                        rs.getString("Cus_phone"),
                        rs.getString("Cus_email")
                ));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm khách hàng: " + e.getMessage());
        }
        return list;
    }
}
