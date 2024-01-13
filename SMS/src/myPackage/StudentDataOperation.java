package myPackage;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDataOperation {

    public static void addStudent(Student stu) throws SQLException {

        Connection con = DB.DBConnect();
        String querry = Querry.add;
        PreparedStatement pstm = con.prepareStatement(querry);
        pstm.setString(1, stu.getRollno());
        pstm.setString(2, stu.getName());
        pstm.setString(3, stu.getGrade());

        pstm.executeUpdate();
        pstm.close();
        con.close();

    }

    public static ArrayList<Student> readData() throws SQLException {
        ArrayList<Student> list = new ArrayList<>();
        Connection conn = DB.DBConnect();
        String querry = Querry.read;
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        while (rs.next()) {
            Student stu = new Student(rs.getString(1), rs.getString(2), rs.getString(3));
            list.add(stu);
        }

        stm.close();
        conn.close();

        return list;
    }

    public static Student searchStu(String rollno) throws SQLException {
        Student stu = null;
        Connection con = DB.DBConnect();
        String querry = Querry.search;
        PreparedStatement pstm = con.prepareStatement(querry);
        pstm.setString(1, rollno);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            stu = new Student(rs.getString(1), rs.getString(2), rs.getString(3));
        }
        pstm.close();
        rs.close();
        con.close();
        return stu;

    }

    public static void deleteRecord(String id) throws SQLException {
        Connection con = DB.DBConnect();
        String querry = Querry.delete;
        PreparedStatement pstm = con.prepareStatement(querry);
        pstm.setString(1, id);
        pstm.executeUpdate();
        System.out.println("Data Deleted Succesfully ");
        pstm.close();
        con.close();

    }

    public static void update() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection con = DB.DBConnect();
        String querry;
        PreparedStatement pstm;
        System.out.println("Enter Rollno of Student ");
        String rollno = sc.next();
        System.out.println("1. Name   2. Grade");
        char ch = sc.next().charAt(0);
        if (ch == '1') {
            sc.nextLine();
            System.out.println("Enter new Name : ");
            String name = sc.nextLine();
            querry = Querry.updateName;
            pstm = con.prepareStatement(querry);
            pstm.setString(1, name);
            pstm.setString(2, rollno);
            pstm.executeUpdate();
            pstm.close();
        } else if (ch == '2') {
            sc.nextLine();
            System.out.println("Enter new Grade : ");
            String grade = sc.nextLine();
            querry = Querry.updateGrade;
            pstm = con.prepareStatement(querry);
            pstm.setString(1, grade);
            pstm.setString(2, rollno);
            pstm.executeUpdate();
            pstm.close();
        } else {
            System.out.println("Invalied Choice");
        }

        con.close();
   

    }

}
