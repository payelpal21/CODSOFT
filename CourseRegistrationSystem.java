import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    // Getter methods for course attributes

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }
}

class Student {
    private int studentID;
    private String name;
    private List<String> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        // Initialize courses
        Course course1 = new Course("CSCI101", "Introduction to Programming", "Learn programming basics.", 30, "MWF 10:00 AM");
        Course course2 = new Course("MATH202", "Calculus II", "Advanced calculus topics.", 25, "TTH 2:00 PM");

        // Initialize students
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");

        // Register students for courses
        student1.registerCourse(course1.getCourseCode());
        student1.registerCourse(course2.getCourseCode());
        student2.registerCourse(course1.getCourseCode());

        // Display available courses
        System.out.println("Available Courses:");
        System.out.println(course1.getCourseCode() + ": " + course1.getTitle() + " - " + course1.getSchedule());
        System.out.println(course2.getCourseCode() + ": " + course2.getTitle() + " - " + course2.getSchedule());

        // Display registered courses for each student
        System.out.println("\nRegistered Courses for " + student1.getName() + ": " + student1.getRegisteredCourses());
        System.out.println("Registered Courses for " + student2.getName() + ": " + student2.getRegisteredCourses());

        // Drop a course for a student
        student1.dropCourse(course1.getCourseCode());

        // Display updated registered courses for student1
        System.out.println("\nUpdated Registered Courses for " + student1.getName() + ": " + student1.getRegisteredCourses());
    }
}
