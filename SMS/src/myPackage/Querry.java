package myPackage;

public class Querry {
    public static String add = "INSERT INTO student(rollno,name,grade) VALUES (?,?,?)";
    public static String delete = "DELETE FROM student WHERE rollno = ?";
    public static String search = "SELECT * FROM student WHERE rollno = ?";
    public static String read = "SELECT * FROM student";

    public static String updateName = "UPDATE student SET name = ? WHERE rollNo = ? ";
    public static String updateGrade = "UPDATE student SET grade = ? WHERE rollNo = ? ";
}
