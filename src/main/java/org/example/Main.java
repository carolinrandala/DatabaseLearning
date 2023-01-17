package org.example;

import db.Database;
import entities.Customer;
import entities.Items;
import entities.Orders;
import entities.Sales;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //Menu.mainMenu();

        Session session = Database.getHibSesh();
        Scanner scanner = new Scanner(System.in);

        //Customer minaj = new Customer("Nicky", "Minaj", "minaj@gmail.com");
        //minaj.setFirstname("Billy");
        //System.out.println(minaj);
        //Customer.deleteCustomer(9);

        //Orders order = session.find(Orders.class, 1);
        //System.out.println(order);

        // - How to hack the select * from []; query
        //Customer.listCustomers();


        // Sales sale = session.find(Sales.class, 3);
        // System.out.println(sale);






        //Items items = session.find(Items.class, 10);
         //System.out.println(items);

        /*
        Items item = new Items("Water", "Something to drink", 20, 8.60f);

        try {
            Transaction trans = session.beginTransaction();
            session.save(item);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */



    }





    // Using Hibernate create the entity object for the items class and
    // make find queries on the items table to retrieve any items you previously stored in it.
    // Also demonstrate how you would save a new entry into the items table

    // 30min(18:41)
    // Using Hibernate create the entity object for the orders class and
    // make find queries on the order table to test your work
}