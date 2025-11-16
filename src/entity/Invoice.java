/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.sql.*;
/**
 *
 * @author Lenovo
 */
public class Invoice {
    private String id;
    private Customer cus;
    private Double total;
    private Timestamp date;
    public Invoice(){}
    public Invoice(String id,Customer cus,Double total){
       this.id=id;
       this.cus=cus;
       this.total=total;
    }
    public String getId() {
        return id;
    }
    
     public void setId(String id) {
        this.id = id;
    }
    public Customer getCus() {
        return cus;
    }
    
     public void setCustomer(Customer cus) {
        this.cus = cus;
    }
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }     
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp Date) {
        this.date = Date;
    }
}
