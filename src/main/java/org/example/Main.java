package org.example;

import controllers.Customer;
import controllers.Item;
import controllers.Orders;
import controllers.Sales;
import controllers.menu.Menu;

public class Main {
    public static void main(String[] args) {
        Customer.createCustomerTable();

        Item.createItemsTable();

        Sales.createSalesTable();
        Orders.createOrdersTable();

        // subsequent objects will have their create table methods here
        Menu.mainMenu();

    }
    // TASK 1
    // Add 2 features to this application that allows user to view all the orders and all the sales.







}