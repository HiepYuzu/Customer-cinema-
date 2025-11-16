/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Lenovo
 */

public class Ticket {
    private String id;
    private Invoice inv;
    private Showtime show;
    private String seatNum;
    private Double price;
    public Ticket(){}
    public Ticket(String id,Invoice inv,Showtime show,String seatNum,Double price){
        this.id=id;
        this.inv=inv;
        this.show=show;
        this.seatNum=seatNum;
        this.price=price;
    }
    public String getId(){return id;}
    public void setId(String id){this.id=id;}
    public Invoice getInv(){return inv;}
    public void setInv(Invoice inv){this.inv=inv;}    
    public Showtime getShow(){return show;}
    public void setShow(Showtime show){this.show=show;}   
    public String getSeat(){return seatNum;}
    public void setSeat(String seatNum){this.seatNum=seatNum;}    
    public Double getPrice() {return price;}
    public void setPrice(Double price){this.price=price;}    
}
