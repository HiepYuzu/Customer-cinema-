/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Lenovo
 */
public class InvoiceService {
    private Invoice inv;
    private Service ser;
    private Double serPrice;
    private int quantity;
    private Double total;
    public InvoiceService(){}
    public InvoiceService(Invoice inv,Service ser,Double serPrice,int quantity){
        this.inv=inv;
        this.ser=ser;
        this.serPrice=serPrice;
        this.quantity=quantity;
        this.total=serPrice*quantity;
    }
    public Invoice getInv(){return inv;}
    public void setInv(Invoice inv){this.inv=inv;}
    public Service getSer(){return ser;}
    public void setSer(Service ser){this.ser=ser;}
    public Double getPrice() {return serPrice;}
    public void setPrice(Double serPrice){
        this.serPrice=serPrice;
        this.total=serPrice*quantity;
    }
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity){
        this.quantity=quantity;
        this.total=serPrice*quantity;
    } 
    public Double getTotal() {return total;}
}
