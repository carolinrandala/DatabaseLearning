package org.example;

import controllers.Customer;
import controllers.Item;
import controllers.Orders;
import controllers.Sales;
import controllers.menu.Menu;

public class Main {
    public static void main(String[] args) {
        Customer.createCustomerTable();
        Orders.createOrdersTable();
        Sales.createSalesTable();
        Item.createItemsTable();
        // subsequent objects will have their create table methods here
        Menu.mainMenu();

    }

    // 25 mins- 20:21
    // Add 2 features to this application that allows user to view
    // all the orders and all the sales.

}