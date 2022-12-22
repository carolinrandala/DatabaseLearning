package exercise;

import exercise.menu.Menu;

public class ExerciseMain {
    /*
    Create a table called Students and another table called Grades
    The column on the students table should be as follows: id, name, age
    Complete the controllers for the students table by adding methods
    handle CURD operations on a table

    On the Grades table, store the students id, score and the grade where
    The columns on Grades should be student_id and score
    for each Grade:
    0-40 F, 41-49 D, 50-59 C, 60 - 69 B, 70 - 100 A
    Complete the controller from the Grades table to have Create, Delete and Read Operations
    For the read operation, you should be able to see students information as well
     */

    public static void main(String[] args) {
        Students.createStudentsTable();
        Grades.createGradesTable();

        // My homework can be checked here:
        Menu.mainMenu();;
    }
}
