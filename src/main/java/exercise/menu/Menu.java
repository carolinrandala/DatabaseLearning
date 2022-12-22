package exercise.menu;

import controllers.Item;
import exercise.Grades;
import exercise.Students;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    public static void mainMenu() {
        System.out.println("Pick a submenu number to continue: ");
        System.out.println("1. Students");
        System.out.println("2. Grades");

        System.out.println();
        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch(option) {
            case 1:
                studentsMenu();
                break;
            case 2:
                gradesMenu();
                break;
            default:
                System.out.println("Invalid option.");
                mainMenu();
                break;
        }
    }

    public static void studentsMenu() {
        System.out.println("Pick a submenu number to continue: ");
        System.out.println("1. Create a new student");
        System.out.println("2. Get all students");
        System.out.println("3. Delete student");



        System.out.println();
        System.out.println("Select an option or enter 0 to go back to the main menu: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenu();
                break;
            case 1:
                Students.createNewStudent();
                studentsMenu();
                break;
            case 2:
                Students.getAllStudents();
                studentsMenu();
                break;
            case 3:
                Students.deleteStudent();
                studentsMenu();
                break;
            default:
                System.out.println("Invalid option.");
                studentsMenu();
                break;
        }
    }

    public static void gradesMenu() {
        System.out.println("Pick a submenu number to continue: ");
        System.out.println("1. Get all the grades");
        System.out.println("2. Delete grade");
        System.out.println("3. Create a grade");




        System.out.println();
        System.out.println("Select an option or enter 0 to go back to the main menu: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenu();
                break;
            case 1:
                Grades.getGradesRecords();
                gradesMenu();
                break;
            case 2:
                Grades.deleteGrade();
                gradesMenu();
                break;
            case 3:
                Grades.createNewGrade();
                gradesMenu();
            default:
                System.out.println("Invalid option.");
                studentsMenu();
                break;
        }
    }
}
