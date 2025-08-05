package services;

import models.Course;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CourseEnrollmentService {
    public void sortCourses(List<Course> courses) {
        courses.sort(Comparator.comparing(Course::getCourseCode));
    }

    public void shuffleCourses(List<Course> courses) {
        Collections.shuffle(courses);
    }

    public void printCourseReport(List<Course> courses) {
        for (Course course : courses) {
            System.out.println("📘 " + course.getCourseCode() + " - " + course.getCourseName());
            List<String> students = course.getEnrolledStudents();
            for (String student : students) {
                System.out.println("   👤 " + student);
            }
        }
    }

    public void printStudentFrequency(Course course, String studentName) {
        long count = course.getEnrolledStudents().stream()
                .filter(name -> name.equalsIgnoreCase(studentName))
                .count();
        System.out.println("🔁 " + studentName + " enrolled " + count + " times in " + course.getCourseCode() + " (" + course.getCourseName() + ")");
    }
}
