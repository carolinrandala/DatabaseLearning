package controllers.menu;

import controllers.Customer;
import controllers.Item;
import controllers.Orders;
import controllers.Sales;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("Pick a submenu number to continue: ");
        System.out.println("1. Items");
        System.out.println("2. Customer");
        System.out.println("3. Sales");
        System.out.println("4. Orders");

        System.out.println();
        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch(option) {
            case 1:
                itemsMenu();
                break;
            case 2:
                customerMenu();
                break;
            case 3:
                salesMenu();
            case 4:
                ordersMenu();
            default:
                System.out.println("Invalid option.");
                mainMenu();
                break;
        }
    }

    public static void itemsMenu() {
        System.out.println("Pick a submenu number to continue: ");
        System.out.println("1. Get all items");
        System.out.println("2. Create new item");

        System.out.println();
        System.out.println("Select an option or enter 0 to go back to the main menu: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenu();
                break;
            case 1:
                Item.getAllItems();
                itemsMenu();
                break;
            case 2:
                Item.createItemsTable();
                itemsMenu();
                break;
            default:
                System.out.println("Invalid option.");
                itemsMenu();
                break;
        }
    }

    public static void customerMenu() {
        System.out.println("Pick a submenu number to continue: ");
        System.out.println("1. Get all customer");
       // System.out.println("2. Create new item");

        System.out.println();
        System.out.println("Select an option or enter 0 to go back to the main menu: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenu();
                break;
            case 1:
                Customer.getAllCustomers();
                customerMenu();
                break;
            default:
                System.out.println("Invalid option.");
                customerMenu();
                break;
        }
    }

    public static void salesMenu() {
        System.out.println("Pick a submenu number to continue: ");
        System.out.println("1. View all the sales");


        System.out.println();
        System.out.println("Select an option or enter 0 to go back to the main menu: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenu();
                break;
            case 1:
                Sales.getAllSales();
                salesMenu();
                break;
            default:
                System.out.println("Invalid option.");
                salesMenu();
                break;
        }
    }

    public static void ordersMenu() {
        System.out.println("Pick a submenu number to continue: ");
        System.out.println("1. View all the orders");


        System.out.println();
        System.out.println("Select an option or enter 0 to go back to the main menu: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenu();
                break;
            case 1:
                Orders.getAllOrders();
                ordersMenu();
                break;
            default:
                System.out.println("Invalid option.");
                ordersMenu();
                break;
        }
    }
}
