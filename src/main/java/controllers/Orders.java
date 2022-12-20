package controllers;

import db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Orders {
    //Fields
    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);

    // Create a table for the class above if and only it doesn't already exist.
    public static boolean createOrdersTable() {
        try {
            ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS orders(" +
                    "    sale_id int NOT NULL," +
                    "    item_id int NOT NULL," +
                    "    qty_purchased int NOT NULL," +
                    "    item_total int NOT NULL," +
                    "    FOREIGN KEY(sale_id) REFERENCES sales(id)," +
                    "    FOREIGN KEY(item_id) REFERENCES items(id))");

            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    public static void getAllOrders() {
        try {
            ps = connection.prepareStatement("SELECT * FROM orders");
            rs = ps.executeQuery();

            //Loop through the result set
            while (rs.next()) {
                String sale_id = "sale_id: " + rs.getInt("sale_id");
                String item_id = "item_id: " + rs.getInt("item_id");
                String qty_purchased = "qty_purchased: " + rs.getInt("qty_purchased");
                String item_total = "item_total: " + rs.getInt("item_total");

                System.out.println(sale_id + " " + item_id + " " + qty_purchased + " " + item_total);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}