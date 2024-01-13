package myPackage;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
    Scanner sc = new Scanner(System.in);

    public App() {
        Boolean exit = true;
        while (exit) {
            System.out.println("\n\n -----------------------Student Management System---------------\n\n");
            System.out.println(
                    "1.ADD STUDENT  2.SEE ALL STUDENT DATA  3.SEARCH STUDENT  4.DELETE STUDENT 5. UPDATE STUDENT RECORD 6.exit");
            int choice = sc.nextInt();
            sc.nextLine();
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter Student Data ");
                        System.out.println("Enter Rollno : ");
                        String rollno = sc.next();
                        sc.nextLine();
                        System.out.println("Enter name : ");
                        String name = sc.nextLine();
                        System.out.println("Enter student grade : ");
                        String grade = sc.next();
                        Student stu = new Student(rollno, name, grade);
                        StudentDataOperation.addStudent(stu);
                        System.out.println("Data added");
                        break;
                    case 2:
                        ArrayList<Student> list = StudentDataOperation.readData();
                        for (Student s : list) {
                            System.out.println(s);
                        }
                        break;
                    case 3:
                        System.out.println("Enter Student Rollno : ");
                        String Rollno = sc.next();
                        Student student = StudentDataOperation.searchStu(Rollno);
                        if (student != null) {
                            System.out.println("---------------Record Found---------------");
                            System.out.println(student);
                        } else {
                            System.out.println("No Record for Student " + Rollno);
                        }
                        break;
                    case 4:
                        System.out.println("Enter Student Rollno : ");
                        String id = sc.next();
                        StudentDataOperation.deleteRecord(id);
                        break;
                    case 5:
                        StudentDataOperation.update();
                        break;
                    case 6:
                        exit = false;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
