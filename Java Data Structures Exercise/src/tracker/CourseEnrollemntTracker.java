package tracker;

import models.Course;
import services.CourseEnrollmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseEnrollemntTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseEnrollmentService service = new CourseEnrollmentService();
        List<Course> courses = new ArrayList<>();

        System.out.print("Enter number of courses: ");
        int numCourses = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numCourses; i++) {
            System.out.print("Enter course code for Course " + (i + 1) + ": ");
            String courseCode = scanner.nextLine();

            System.out.print("Enter course name for Course " + (i + 1) + ": ");
            String courseName = scanner.nextLine();

            Course course = new Course(courseCode, courseName);

            System.out.print("Enter number of students to enroll in " + courseCode + ": ");
            int studentCount = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < studentCount; j++) {
                System.out.print("Enter student name #" + (j + 1) + ": ");
                String student = scanner.nextLine();
                course.enrollStudent(student);
            }

            courses.add(course);
        }

        // Sorted Report
        System.out.println("\n✅ Sorted Course List:");
        service.sortCourses(courses);
        service.printCourseReport(courses);

        // Student Frequency
        System.out.print("\n🔍 Enter course code to check student frequency: ");
        String searchCourse = scanner.nextLine();
        Course selectedCourse = courses.stream()
                .filter(c -> c.getCourseCode().equalsIgnoreCase(searchCourse))
                .findFirst()
                .orElse(null);

        if (selectedCourse != null) {
            System.out.print("Enter student name to check frequency in " + selectedCourse.getCourseName() + ": ");
            String studentName = scanner.nextLine();
            service.printStudentFrequency(selectedCourse, studentName);
        } else {
            System.out.println("Course not found.");
        }

        // Shuffled Report
        System.out.println("\n🎲 Shuffled Course List:");
        service.shuffleCourses(courses);
        service.printCourseReport(courses);

        scanner.close();
    }
}
