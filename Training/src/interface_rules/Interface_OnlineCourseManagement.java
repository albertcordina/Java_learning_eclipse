package interface_rules;
import java.util.*;
//___________________________________________________________________________________________________________

interface OnlineCourse {
    void enrollStudent(String studentName);
    void displayCourseDetails();
}
//____________________________________________________________________________________________________________

class ProgrammingCourse implements OnlineCourse {
    private String courseName;
    private String instructorName;
    private List<String> enrolledStudents;
    
    public ProgrammingCourse(String courseName, String instructorName) {
        this.courseName = courseName;
        this.instructorName = instructorName;
        this.enrolledStudents = new ArrayList<>();
    }
    @Override
    public void enrollStudent(String studentName) {
        enrolledStudents.add(studentName);
    }
    @Override
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName + "Instructor: " + instructorName + "Enrolled Students:");
        for (String student : enrolledStudents) {
            System.out.println("- " + student);
        }
    }
}
//_______________________________________________________________________________________________________________

class MathCourse implements OnlineCourse {
    private String courseName;
    private String instructorName;
    private List<String> enrolledStudents;
    
    public MathCourse(String courseName, String instructorName) {
        this.courseName = courseName;
        this.instructorName = instructorName;
        this.enrolledStudents = new ArrayList<>();
    }
    @Override
    public void enrollStudent(String studentName) {
        enrolledStudents.add(studentName);
    }
    @Override
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName + "Instructor: " + instructorName + "Enrolled Students:");
        for (String student : enrolledStudents) {
            System.out.println("- " + student);
        }
    }
}
//_______________________________________________________________________________________________________________

class CourseManager {
    private List<OnlineCourse> courses;

    public CourseManager() {

        courses = new ArrayList<>();
    }
    public void addCourse(OnlineCourse course) {
        courses.add(course);
    }
    public void enrollStudentInCourse(String studentName, OnlineCourse course) {
        course.enrollStudent(studentName);
    }
    public void displayAllCourseDetails() {
        for (OnlineCourse course : courses) {
            course.displayCourseDetails();
            System.out.println();
        }
    }
}
//______________________________________________________________________________________________

public class Interface_OnlineCourseManagement {
    public static void main(String[] args) {
        CourseManager manager = new CourseManager();
        List<Integer> list = new ArrayList<Integer>();
        list = new ArrayList<Integer>();

        // Create programming and math courses
        OnlineCourse programmingCourse = new ProgrammingCourse("Java Programming", "John Doe");
        OnlineCourse mathCourse = new MathCourse("Calculus", "Alice Smith");

        manager.addCourse(programmingCourse);
        manager.addCourse(mathCourse);

        // Enroll students in courses
        manager.enrollStudentInCourse("Alice", programmingCourse);
        manager.enrollStudentInCourse("Bob", programmingCourse);
        manager.enrollStudentInCourse("Charlie", mathCourse);

        // Display course details
        manager.displayAllCourseDetails();
    }
}