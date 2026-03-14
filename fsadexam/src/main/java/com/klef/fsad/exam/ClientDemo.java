package com.klef.fsad.exam;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.Date;
import java.util.List;

public class ClientDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();

        // I. Insert records using persistent objects
        Session s1 = sf.openSession();
        Transaction t1 = s1.beginTransaction();

        Invoice inv1 = new Invoice();
        inv1.setName("Invoice-001");
        inv1.setDate(new Date());
        inv1.setStatus("Paid");
        inv1.setAmount(15000.00);
        inv1.setCustomer("Rahul Sharma");
        s1.save(inv1);

        Invoice inv2 = new Invoice();
        inv2.setName("Invoice-002");
        inv2.setDate(new Date());
        inv2.setStatus("Pending");
        inv2.setAmount(8500.50);
        inv2.setCustomer("Priya Reddy");
        s1.save(inv2);

        Invoice inv3 = new Invoice();
        inv3.setName("Invoice-003");
        inv3.setDate(new Date());
        inv3.setStatus("Paid");
        inv3.setAmount(23000.75);
        inv3.setCustomer("Arjun Mehta");
        s1.save(inv3);

        t1.commit();
        s1.close();
        System.out.println("Records inserted successfully.");

        // II. View all records without WHERE clause using HQL
        Session s2 = sf.openSession();
        Query<Invoice> query = s2.createQuery("from Invoice", Invoice.class);
        List<Invoice> allInvoices = query.list();

        System.out.println("\n--- All Invoice Records (HQL without WHERE) ---");
        for (Invoice inv : allInvoices) {
            System.out.println(inv);
        }
        s2.close();

        // III. HQL with positional parameters
        Session s3 = sf.openSession();
        Query<Invoice> paramQuery = s3.createQuery(
            "from Invoice where status = ?1", Invoice.class
        );
        paramQuery.setParameter(1, "Paid");
        List<Invoice> paidInvoices = paramQuery.list();

        System.out.println("\n--- Invoices with Status='Paid' (HQL positional parameter) ---");
        for (Invoice inv : paidInvoices) {
            System.out.println(inv);
        }
        s3.close();

        sf.close();
    }
}
