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

class Course {
    private String name;
    private String prerequisite;
    private int capacity;
    private int enrolled;

    public Course(String name, String prerequisite, int capacity) {
        this.name = name;
        this.prerequisite = prerequisite;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    public String getName() {
        return name;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void enrollStudent(boolean prerequisiteCompleted) throws CourseFullException, PrerequisiteNotMetException {
        if (!prerequisiteCompleted) {
            throw new PrerequisiteNotMetException("Complete " + prerequisite + " before enrolling in " + name + ".");
        }
        if (enrolled >= capacity) {
            throw new CourseFullException("Course " + name + " is full. Cannot enroll.");
        }
        enrolled++;
        System.out.println("Successfully enrolled in " + name);
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Course advancedJava = new Course("Advanced Java", "Core Java", 2);
        
        try {
            advancedJava.enrollStudent(false);
        } catch (PrerequisiteNotMetException | CourseFullException e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
