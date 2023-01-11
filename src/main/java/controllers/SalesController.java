package controllers;

import db.Database;
import objects.OrderObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class SalesController {

    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);


    public static boolean createSalesTable() {
        try {
            ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS sales(" +
                    "    id serial PRIMARY KEY," +
                    "    customer_id int," +
                    "    date_purchased TIMESTAMP," +
                    "    total float," +
                    "    FOREIGN KEY (customer_id) REFERENCES customer(id))");

            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static void getAllSales() {
        try {
            ps = connection.prepareStatement("SELECT sales.*, customer.first_name, customer.last_name FROM sales " +
                    "LEFT JOIN customer ON sales.customer_id = customer.id");
            rs = ps.executeQuery();

            // Loop through the result set
            while (rs.next()) {
                String id = "id: " + rs.getInt("id");
                String custId = "customer_id: " + rs.getInt("customer_id");
                String datePurchased = "date_purchased: " + rs.getTimestamp("date_purchased");
                String total = "total: " + rs.getFloat("total");
                String firstName = "first_name: " + rs.getString("first_name");
                String lastName = "last_name: " + rs.getString("last_name");
                System.out.println(id + ", " + custId + ", " + total + ", " + firstName + ", " + lastName + ", " + datePurchased);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private static List<OrderObject> handleItemTotal() {

        System.out.println("Enter how many items were bought: ");
        int numberOfItems = scanner.nextInt();

        //Map<Integer, Float> items = new HashMap<>();
        List<OrderObject> itemsPurchased = new ArrayList<>();
        float itemTotal = 0;

        for (int i = 0; i < numberOfItems; i++) {
            // Use the collection to get the item by the id after you
            // pass it into the map
            System.out.print("Enter the item id: ");
            int itemId = scanner.nextInt();

            System.out.println("Enter the quantity purchased: ");
            int qty = scanner.nextInt();

            float itemPrice = 0;

            try {
                ps = connection.prepareStatement("SELECT price FROM items WHERE id = " + itemId);
                rs = ps.executeQuery();

                while (rs.next()) {
                    itemPrice = rs.getFloat("price");
                }
                itemTotal = itemPrice * qty;

               // items.putIfAbsent(itemId, itemTotal);
                itemsPurchased.add(new OrderObject(itemId, qty, itemTotal));
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return itemsPurchased;
    }

    private static float collateOrderTotal(List<OrderObject> orders) {
        float sum = 0;

        for (OrderObject order : orders) {
            sum += order.getTotalOnItem();
        }
        return sum;
    }

    public static void createSaleAndOrder() {
        // Prompt the user for the customer id
        System.out.println("Enter the customer id: ");
        int custId = scanner.nextInt();

        // Get the items purchased
        List<OrderObject> itemsPurchased = handleItemTotal();

        // Get the total on the items
        float totalSale = collateOrderTotal(itemsPurchased);

        int saleId = 0;

        try {
            ps = connection.prepareStatement("INSERT INTO sales(customer_id, date_purchased, total) " +
                    "VALUES(" + custId + ", current_timestamp, " + totalSale + " ) RETURNING id");
            rs = ps.executeQuery();

            // Loop through the result set until empty
            while (rs.next()) {
                saleId = rs.getInt("id");
                // for each sale, use the id to create the orders.
                for (OrderObject order: itemsPurchased) {
                    ps = connection.prepareStatement("INSERT INTO orders(sale_id, item_id, qty_purchased, item_total) " +
                            "VALUES(" + saleId + ", " + order.getItemId() + ", " + order.getQtyPurchased() + ", " +
                            order.getTotalOnItem() + ")");

                    ps.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /*
    public static void createNewSale() {
        // Add a method called createNewSale:
        // - collect the total price of all the items bought using the
        // handleItemsTotal method and log the total to the console

        float sum = 0;
        for (float value: handleItemTotal().values()) {
            sum += value;
        }
        System.out.println("Total price of the items: " + sum);
        System.out.println();
    }

     */

}









