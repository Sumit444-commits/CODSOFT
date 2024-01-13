package myPackage;

import java.util.Scanner;

public class StudentMarks {
    Scanner sc = new Scanner(System.in);
    private int totalSubjects;
    private int[] marks;

    private int total = 0;
    private double average = 0;
    private char grade = 'F';

    public void checkResult() {
        UserInput();
        calcTotalMarks();
        AvgPercent();
        calculateGrade();
        resultDisplay();
    }

    public void UserInput() {
        System.out.print("Enter the number of subjects: ");
        totalSubjects = sc.nextInt(); // total number of subjects
        marks = new int[totalSubjects];

        int err = 0; // err if user inserts marks more than 100
        while (err >= 0 && err < totalSubjects) {
            for (int i = err; i < totalSubjects; i++) {
                System.out.print("Enter the marks of subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();

                if (marks[i] < 0 || marks[i] > 100) {
                    System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                    err = i;
                    break;
                }
                err = -1;
            }
        }
    }

    public void calcTotalMarks() {
        for (int i = 0; i < marks.length; i++) {
            total += marks[i];
        }
    }

    public void AvgPercent() {
        average = (double) total / totalSubjects;
    }

    public void calculateGrade() {
        if (average >= 80) {
            grade = 'A';
        } else if (average >= 60) {
            grade = 'B';
        } else if (average >= 40) {
            grade = 'C';
        } else {
            grade = 'D';
        }
    }

    public void resultDisplay() {
        System.out.println("Total marks: " + total);
        System.out.printf("Average percentage : %.2f\n", average);
        System.out.println("Grade: " + grade);
    }

}
