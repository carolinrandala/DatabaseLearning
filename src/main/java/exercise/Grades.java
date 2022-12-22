package exercise;

import db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Grades {
    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);

    public static void createGradesTable() {
        try {
            ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS grades(" +
                    "id serial PRIMARY KEY," +
                    "student_id int," +
                    "score int," +
                    "grade varchar(10)," +
                    "FOREIGN KEY(student_id) REFERENCES students(student_id))");

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createNewGrade() {

        System.out.print("Enter the score: ");
        int score = scanner.nextInt();
        String grade = null;

        if (score <= 40) {
            grade = "F";
        } else if (score > 40 && score <= 49) {
            grade = "D";
        } else if (score > 49 && score <= 59) {
            grade = "C";
        } else if (score > 59 && score <= 69) {
            grade = "B";
        } else if (score > 69 && score <= 100) {
            grade = "A";
        }

        System.out.print("Enter the student's id: ");
        int studentId = scanner.nextInt();


        try {
            ps = connection.prepareStatement("INSERT INTO grades(student_id, score, grade) " +
                    "VALUES(" + studentId + ", " + score + ", '" + grade + "')");


            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void getGradesRecords() {
        // READ
        try {
            ps = connection.prepareStatement("SELECT * FROM grades");
            rs = ps.executeQuery();

            //Loop through the result set
            while (rs.next()) {
                String id = "id: " + rs.getInt("id");
                String student_id = "student_id: " + rs.getInt("student_id");
                String score = "score: " + rs.getInt("score");
                String grade = "grade: " + rs.getString("grade");
                System.out.println(id + ", " +student_id + ", " + score + ", " + grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deleteGrade() {
        // First method should be called deleteItem() and it
        // should prompt the user to enter the id of the item to be deleted


        System.out.print("Enter the student id to delete grade: ");
        int id = scanner.nextInt();

        try {
            ps = connection.prepareStatement("DELETE FROM grades WHERE student_id =" + id);
            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
