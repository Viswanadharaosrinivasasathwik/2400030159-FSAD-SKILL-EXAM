package com.klef.fsad.exam;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private String status;

    @Column(name = "amount")
    private double amount;

    @Column(name = "customer")
    private String customer;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCustomer() { return customer; }
    public void setCustomer(String customer) { this.customer = customer; }

    @Override
    public String toString() {
        return "Invoice [id=" + id + ", name=" + name + ", date=" + date +
               ", status=" + status + ", amount=" + amount + ", customer=" + customer + "]";
    }
}
