/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import cinema.Database;
import entity.InvoiceStatistic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceStatisticDAO {
public List<InvoiceStatistic> getAllInvoices() throws ClassNotFoundException  {
        List<InvoiceStatistic> list = new ArrayList<>();
        String sql = "SELECT inv_id, cus_id, inv_date, ticket_subtotal, service_subtotal, inv_total " +
                     "FROM invoice ORDER BY inv_date DESC";

        try (Connection conn = Database.getDB().connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                InvoiceStatistic stat = new InvoiceStatistic(
                    rs.getString("inv_id"),
                    rs.getString("cus_id"),
                    rs.getTimestamp("inv_date"),           
                    rs.getDouble("ticket_subtotal"),
                    rs.getDouble("service_subtotal"),
                    rs.getDouble("inv_total")
                );
                list.add(stat);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy tất cả hóa đơn: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

   
    public List<InvoiceStatistic> getInvoicesByDate(java.util.Date from, java.util.Date to) throws ClassNotFoundException {
        List<InvoiceStatistic> list = new ArrayList<>();
        String sql = "SELECT inv_id, cus_id, inv_date, ticket_subtotal, service_subtotal, inv_total " +
                     "FROM invoice " +
                     "WHERE inv_date BETWEEN ? AND ? " +
                     "ORDER BY inv_date DESC";

        try (Connection conn = Database.getDB().connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

           
            ps.setDate(1, new java.sql.Date(from.getTime()));
            ps.setDate(2, new java.sql.Date(to.getTime()));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    InvoiceStatistic stat = new InvoiceStatistic(
                        rs.getString("inv_id"),
                        rs.getString("cus_id"),
                        rs.getTimestamp("inv_date"),
                        rs.getDouble("ticket_subtotal"),
                        rs.getDouble("service_subtotal"),
                        rs.getDouble("inv_total")
                    );
                    list.add(stat);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy hóa đơn theo ngày: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }
}
 

