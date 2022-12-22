package controllers;

import db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Item {
    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);

    public static void createItemsTable() {
        try {
            ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS items(" +
                    "    id serial PRIMARY KEY," +
                    "    name varchar(255) NOT NULL," +
                    "    description varchar(255) NOT NULL," +
                    "    qty_in_stock int," +
                    "    price float)");
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getAllItems() {
        try {
            ps = connection.prepareStatement("SELECT * FROM items");
            rs = ps.executeQuery();

            //Loop through the result set
            while (rs.next()) {
                String id = "id: " + rs.getInt("id");
                String name = "name: " + rs.getString("name");
                String desc = "desc: " + rs.getString("description");
                String qty = "qty: " + rs.getInt("qty_in_stock");
                String price = "price: " + rs.getFloat("price");
                System.out.println(id + " " + name + " " + desc + " " + qty + " " + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static boolean createNewItem() {
        // Add prompts to tell the user what data they need to enter next
        System.out.print("Enter the item name: ");
        String name = scanner.nextLine();


        System.out.print("Enter the description name: ");
        String desc = scanner.nextLine();

        System.out.print("Enter the qty: ");
        int qty = scanner.nextInt();

        System.out.print("Enter the price: ");
        float price = scanner.nextFloat();

        try {
            ps = connection.prepareStatement("INSERT INTO items(name, description, qty_in_stock, price) " +
                    "VALUES ('" + name + "', '" + desc + "', " + qty + ", " + price + ")");

            ps.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // 19:57 starting - 20mins
    // Implement a method to update an item using its id, where its id should be passed
    // by the user, i.e use the scanner class to get the id.

    public static boolean updateItem() {
        // Prompt the user info
        System.out.print("Enter the item's id: ");
        int id = scanner.nextInt();

        System.out.print("Enter the new quantity: ");
        int qty = scanner.nextInt();

        System.out.print("Enter the new price: ");
        float price = scanner.nextFloat();

        try {
            ps = connection.prepareStatement("UPDATE items SET" + " qty_in_stock = " + qty
                    + ", price =" + price + " WHERE id = " + id);
            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Implement 2 methods:
    public static boolean deleteItem() {
        // First method should be called deleteItem() and it
        // should prompt the user to enter the id of the item to be deleted
        // return a boolean if the operation is successful

        System.out.print("Enter the item's you wish to delete id: ");
        int id = scanner.nextInt();

        try {
            ps = connection.prepareStatement("DELETE FROM items" + " WHERE id = " + id);
            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    public static void getItemById() {
        // The second method should be called getItemById() and it should prompt
        // the user to also the id of the item in question
        System.out.print("Enter the id to get the item: ");
        int id = scanner.nextInt();

        try {
            ps = connection.prepareStatement("SELECT * FROM items WHERE id = " + id);
            rs = ps.executeQuery();

            //Loop through the result set
            while (rs.next()) {

                String name = "name: " + rs.getString("name");
                String desc = "desc: " + rs.getString("description");
                String qty = "qty: " + rs.getInt("qty_in_stock");
                String price = "price: " + rs.getFloat("price");
                System.out.println(id + " " + name + " " + desc + " " + qty + " " + price);

            }
        }catch (SQLException e) {
            e.printStackTrace();

        }
    }


}








