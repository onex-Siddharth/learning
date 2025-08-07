package src.main.java.com.example.example;

import com.example.model.Student;
import com.example.service.StudentService;
import com.example.util.DBUtil;
import src.main.java.com.example.example.service.CsvExporter;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DBUtil.initializeDatabase();
        StudentService service = new StudentService();
        CsvExporter exporter = new CsvExporter();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add student\n2. View all students\n3. Export to CSV\n4. Exit");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Sport: ");
                    String sport = sc.nextLine();
                    System.out.print("Age: ");
                    int age = Integer.parseInt(sc.nextLine());
                    service.insertStudent(new Student(name, sport, age));
                    System.out.println("✅ Student added.");
                }

                case "2" -> {
                    List<Student> students = service.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("⚠️ No students found.");
                    } else {
                        System.out.println("\n--- Student Records ---");
                        for (Student s : students) {
                            System.out.printf("ID: %d | Name: %s | Sport: %s | Age: %d\n",
                                    s.getId(), s.getName(), s.getSport(), s.getAge());
                        }
                    }
                }

                case "3" -> {
                    exporter.exportToCsv(service.getAllStudents(), "students.csv");
                    System.out.println("✅ Exported to students.csv");
                }

                case "4" -> {
                    System.out.println("👋 Exiting...");
                    System.exit(0);
                }

                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
