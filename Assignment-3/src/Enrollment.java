import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

public class UniversityEnrollmentSystem {
    private static final int COURSE_CAPACITY = 3;
    private static Map<String, Integer> courseEnrollment = new HashMap<>();
    private static Map<String, String> coursePrerequisites = new HashMap<>();

    static {
        coursePrerequisites.put("Advanced Java", "Core Java");
        courseEnrollment.put("Advanced Java", 2); // Already enrolled students
    }

    public static void enrollStudent(String course, boolean prerequisiteCompleted) throws CourseFullException, PrerequisiteNotMetException {
        if (coursePrerequisites.containsKey(course) && !prerequisiteCompleted) {
            throw new PrerequisiteNotMetException("Complete " + coursePrerequisites.get(course) + " before enrolling in " + course);
        }
        
        int enrolledStudents = courseEnrollment.getOrDefault(course, 0);
        if (enrolledStudents >= COURSE_CAPACITY) {
            throw new CourseFullException(course + " is full.");
        }
        
        courseEnrollment.put(course, enrolledStudents + 1);
        System.out.println("Successfully enrolled in " + course);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enroll in Course: ");
        String course = scanner.nextLine();
        
        System.out.print("Prerequisite Completed (true/false): ");
        boolean prerequisiteCompleted = scanner.nextBoolean();
        
        try {
            enrollStudent(course, prerequisiteCompleted);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
