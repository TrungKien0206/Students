package students;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Student {

    String id;
    String fullName;
    float GPA;
    Date dateOfBirth;
    String major;

    public Student() {
    }

    public Student(String id, String fullName, float GPA, Date dateOfBirth, String major) {
        this.id = id;
        this.fullName = fullName;
        this.GPA = GPA;
        this.dateOfBirth = dateOfBirth;
        this.major = major;
    }

    public Student enterStudentInfo(Student student) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); 

        System.out.println("ID: ");
        student.id = sc.nextLine();
        
        System.out.println("Full Name: ");
        student.fullName = sc.nextLine();
        
        System.out.println("GPA: ");
        student.GPA = sc.nextFloat();
        sc.nextLine(); 

        boolean validDate = false;
        while (!validDate) {
            try {
                System.out.println("Date of Birth : ");
                String dateInput = sc.nextLine();
                student.dateOfBirth = sdf.parse(dateInput); 
                validDate = true; 
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }

        System.out.println("Major: ");
        student.major = sc.nextLine();
        return student;
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Student ID: " + id + "\n"
                + "Full Name: " + fullName + "\n"
                + "GPA: " + GPA + "\n"
                + "Date of Birth: " + sdf.format(dateOfBirth) + "\n"
                + "Major: " + major;
    }
}

class Processor {

    public static void main(String[] args) {
        Student student = new Student();
        student.enterStudentInfo(student);
        System.out.println(student.toString());
    }
}
