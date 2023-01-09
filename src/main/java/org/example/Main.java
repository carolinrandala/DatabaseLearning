package org.example;

import controllers.Item;
import controllers.Orders;
import controllers.Sales;
import db.Database;
import entities.Customer;
import entities.Items;
import exercise.menu.Menu;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        //Menu.mainMenu();

        Session session = Database.getHibSesh();

        /*
        Customer cust = session.find(Customer.class, 2);
        System.out.println(cust);

        Customer barry = new Customer("Barry", "Allen", "barry@allen.com");

        try {
            Transaction trans = session.beginTransaction();
            session.save(barry);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

         */
        Items items = session.find(Items.class, 10);
        System.out.println(items);

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
}