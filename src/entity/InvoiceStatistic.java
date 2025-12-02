/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.util.Date;
/**
 *
 * @author Hoang Hiep
 */




public class InvoiceStatistic {
    private String inv_id;        
    private String  cus_id;
    private Date inv_date;
    private double ticket_subtotal;
    private double service_subtotal;
    private double inv_total;

    public InvoiceStatistic(String inv_id, String cus_id, Date inv_date,
                           double ticket_subtotal, double service_subtotal, double inv_total) {
        this.inv_id = inv_id;
        this.cus_id = cus_id;
        this.inv_date = inv_date;
        this.ticket_subtotal = ticket_subtotal;
        this.service_subtotal = service_subtotal;
        this.inv_total = inv_total;
    }

    // Getter & Setter
    public String getInv_id() { return inv_id; }
    public void setInv_id(String inv_id) { this.inv_id = inv_id; }

    public String getCus_id() { return cus_id; }
    public void setCus_id(String cus_id) { this.cus_id = cus_id; }

    public Date getInv_date() { return inv_date; }
    public void setInv_date(Date inv_date) { this.inv_date = inv_date; }

    public double getTicket_subtotal() { return ticket_subtotal; }
    public double getService_subtotal() { return service_subtotal; }
    public double getInv_total() { return inv_total; }
}
