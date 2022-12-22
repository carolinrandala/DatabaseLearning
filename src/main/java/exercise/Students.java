package exercise;

import db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Students {
    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);
    public static void createStudentsTable() {
        try {
            ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS students(" +
                    "student_id serial PRIMARY KEY," +
                    "name varchar(255) NOT NULL," +
                    "age int)");

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean createNewStudent() {
        // Add prompts to tell the user what data they need to enter next
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        try {
            ps = connection.prepareStatement("INSERT INTO students(name, age) " +
                    "VALUES ('" + name + "', " + age + ")");

            ps.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void getAllStudents() {
        // READ
        try {
            ps = connection.prepareStatement("SELECT * FROM students");
            rs = ps.executeQuery();

            //Loop through the result set
            while (rs.next()) {
                String student_id = "student_id: " + rs.getInt("student_id");
                String name = "name: " + rs.getString("name");
                String age = "age: " + rs.getInt("age");
                System.out.println(student_id + ", " + name + ", " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deleteStudent() {
        // First method should be called deleteItem() and it
        // should prompt the user to enter the id of the item to be deleted


        System.out.print("Enter the student's id to delete: ");
        int id = scanner.nextInt();

        try {
            ps = connection.prepareStatement("DELETE FROM students WHERE student_id =" + id);
            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
