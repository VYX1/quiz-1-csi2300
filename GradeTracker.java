// code is saved to https://github.com/VYX1/quiz-1-csi2300

import java.util.Scanner;

public class GradeTracker {

    // Constants
    /// a constant in code is a defined value that cannot be changed after it is defined, unlike a variable which can change via code
    /// in this code, the constants are assigned to values that have a substantial meaning and are unlikely to change. 
    /// however, as per the instructions, the MAX_STUDENTS constant has been changed to a user assigned variable.
    
    // final static int MAX_STUDENTS = 5; 
    final static int PASSING_GRADE = 60;

    // Student class
    /// a class is a 'blueprint' which can be used to create objects, house variables, and also methods. It can also contain more classes.  
    /// it is considered a 'blueprint' because it is just a layout without any instance or real data.

    static class Student {
        String name; // stores information as a string. can store numbers as a string as well, but they cannot be used for math in string format.
        int grade; // stores information as a integer. cannot accept decimal numbers or letters. can be used in mathematical equations.

        Student(String name, int grade) { // sets up the information contained in the array
            this.name = name;
            this.grade = grade;
        }
    }

    /// this is the main method of this code, where processing actually happens. It is the front door of the class blueprint.
    /// "main" is a special method name that indicates to java to start the code here. void means it does not return a value. 
    /// public means it can be accessed from anywhere. static means it belongs to the gradetracker class and not to an object of the class.
    /// the code has been modified to count how many students passed as well as to show the highest and lowest grades of the class
    
    public static void main(String[] args) {
        
        int passedCount = 0;
        int highestGrade = -1; //set to -1 since we will be increasing it via loop to match the highest grade of the class by comparing values
        int lowestGrade = 999; //set to 999 since we will be decreasing it via loop to match the lowest grade of the class by comparing values

        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter number of students: ");
        int MAX_STUDENTS = input.nextInt(); //changing MAX_STUDENTS to a user input
        input.nextLine(); //clearing input of leftover newline character

        Student[] students = new Student[MAX_STUDENTS]; //array to hold information about students. can hold more information such as specific subjects information if it was included in the Student class.

        // Input student data
        for (int i = 0; i < MAX_STUDENTS; i++) { //simple loop to get student names and grades.
            System.out.print("Enter name for student " + (i + 1) + ": "); // prompts the user to type in a name
            String name = input.nextLine(); // saves the name to a string stored in the array

            int grade;
            while (true) {
                System.out.print("Enter grade for " + name + ": "); // prompts the user to type in a grade for (name)
                if (input.hasNextInt()) {
                    grade = input.nextInt(); // saves the grade to a int var stored in the array
                    input.nextLine(); // consume newline
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number."); // checks for invalid input. if the input is invalid, it will restart the grade loop.
                    input.next(); // discard invalid input
                    /// if you forget to validate input like this, then somone could accidentally input a letter and break the whole code. 
                    /// it is also important to validate since even in this code, grades can be inputted that are well outside the 0-100 range that would also break the code.
                    /// alternatively, some inputs in this code want to accept a number, but inputting a decimal number will break the code, which for a user could be incredibly frustrating. 
                }
            }

            students[i] = new Student(name, grade);
        }

        // Output results
        System.out.println("\n--- Grade Report ---");
        int total = 0;
        for (Student s : students) {
            System.out.print(s.name + " - Grade: " + s.grade);
            if (s.grade >= PASSING_GRADE) {
                System.out.println(" (Pass)");
            } else {
                System.out.println(" (Fail)");
            }//simple if statement to count how many students passed
            if (s.grade >= PASSING_GRADE) {
                passedCount++;
            } //simple if statement to set variable to the highest grade
            if (s.grade > highestGrade) {
                highestGrade = s.grade;
            }//simple if statement to set variable to the lowest grade
            if (s.grade < lowestGrade) {
                lowestGrade = s.grade;
            }
            total += s.grade;
    }
        double average = (double) total / MAX_STUDENTS;
        System.out.println("\nClass Average: " + average);
    }
}