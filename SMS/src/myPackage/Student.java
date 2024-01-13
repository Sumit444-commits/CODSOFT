package myPackage;

public class Student {
    private String rollno;
    private String name;
    private String grade;
    public Student(String rollno, String name, String grade) {
        this.rollno = rollno;
        this.name = name;
        this.grade = grade;
    }
    public String getRollno() {
        return rollno;
    }
    public String getName() {
        return name;
    }
    public String getGrade() {
        return grade;
    }
    @Override
    public String toString() {
        return "Student [rollno=" + rollno + ", name=" + name + ", Grade=" + grade + "]";
    }
}
