package org.example;

import dp.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        getAllItems();
    }

    public static void getAllItems() {
        Connection connection = Database.DbConn();
        PreparedStatement ps;
        ResultSet rs;
        Scanner scanner = new Scanner(System.in);

        try{
            ps = connection.prepareStatement("SELECT * FROM items");
            rs = ps.executeQuery();

            //Loop through the result set
            while(rs.next()) {
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
}