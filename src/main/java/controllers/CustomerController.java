package controllers;

import db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerController {
    //Fields
    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);

    // CRUD - CREATE, READ, UPDATE, DELETE

    // Create a table for the class above if and only it doesn't already exist.
    public static boolean createCustomerTable() {
        try {
            ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS customer(" +
                    "    id serial," +
                    "    first_name varchar(255)," +
                    "    last_name varchar(255)," +
                    "    email varchar(255)," +
                    "    PRIMARY KEY(id))");

            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    public static void getAllCustomers() {
        // READ
        try {
            ps = connection.prepareStatement("SELECT * FROM customer");
            rs = ps.executeQuery();

            //Loop through the result set
            while (rs.next()) {
                String id = "id: " + rs.getInt("id");
                String firstName = "first_name: " + rs.getString("first_name");
                String lastName = "last_name: " + rs.getString("last_name");
                String email = "email: " + rs.getString("email");
                System.out.println(id + ", " + firstName + ", " + lastName + ", " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    // 30min 18:13
    // Complete the Customer class by adding the CREATE, UPDATE AND DELETE
    // functionalities to handle those respective operations on a customer object
    // or record

    public static boolean createNewCustomer() {
        // Add prompts to tell the user what data they need to enter next
        System.out.print("Enter the customer name: ");
        String first_name = scanner.nextLine();

        System.out.print("Enter the customer surname: ");
        String last_name = scanner.nextLine();

        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();


        try {
            ps = connection.prepareStatement("INSERT INTO customer(first_name, last_name, email) " +
                    "VALUES ('" + first_name + "', '" + last_name + "', '" + email +"')");

            ps.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateCustomer() {
        // Prompt the user info
        System.out.print("Enter the field name you wish to update: first name, last name, email");

        System.out.println("Enter the field name: ");
        String fieldName = scanner.nextLine();

        System.out.println("Enter the value for the field: ");
        String fieldValue = scanner.nextLine();

        System.out.print("Enter the customer's id: ");
        int id = scanner.nextInt();

        if(!fieldName.equals("first_name") || !fieldName.equals("last_name") || (!fieldName.equals("email"))) {
            System.out.println("Invalid field name");
            updateCustomer();
        }

        try {
            ps = connection.prepareStatement("UPDATE customer SET" + fieldName + " = '" + fieldValue + "' " + "WHERE id = " + id);
            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void deleteCustomer() {
        // First method should be called deleteItem() and it
        // should prompt the user to enter the id of the item to be deleted


        System.out.print("Enter the customer's id you wish to delete: ");
        int id = scanner.nextInt();

        try {
            ps = connection.prepareStatement("DELETE FROM sales WHERE customer_id =" + id);
            ps.execute();

            ps = connection.prepareStatement("DELETE FROM customer WHERE id = " + id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
