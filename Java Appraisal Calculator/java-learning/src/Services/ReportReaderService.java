package Services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class ReportReaderService {
    private static final String REPORTS_DIRECTORY = "./reports";
    private final Scanner scanner;

    public ReportReaderService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startReportViewer() {
        System.out.println("\n=== Appraisal Report Viewer ===");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. View all appraisal reports");
            System.out.println("2. View specific employee's report");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAllReports();
                    break;
                case 2:
                    viewEmployeeReport();
                    break;
                case 3:
                    System.out.println("Exiting report viewer...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewAllReports() {
        File folder = new File(REPORTS_DIRECTORY);

        if (!folder.exists() || !folder.isDirectory()) {
            System.err.println("Reports directory not found: " + REPORTS_DIRECTORY);
            return;
        }

        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().startsWith("appraisal_report_") &&
                name.toLowerCase().endsWith(".txt"));

        if (files != null && files.length > 0) {
            System.out.println("\nAvailable Reports:");
            for (File file : files) {
                String empId = extractEmployeeId(file.getName());
                System.out.println("- Employee ID: " + empId);
            }

            System.out.println("\nReport Contents:");
            for (File file : files) {
                printReport(file);
            }
        } else {
            System.out.println("No appraisal reports found.");
        }
    }

    private void viewEmployeeReport() {
        System.out.print("Enter Employee ID: ");
        String empId = scanner.nextLine().trim();

        File reportFile = new File(REPORTS_DIRECTORY, "appraisal_report_" + empId + ".txt");

        if (reportFile.exists()) {
            printReport(reportFile);
        } else {
            System.out.println("No appraisal report found for employee ID: " + empId);
        }
    }

    private void printReport(File file) {
        System.out.println("\n---- " + file.getName() + " ----");
        try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading " + file.getName() + ": " + e.getMessage());
        }
    }

    private String extractEmployeeId(String filename) {
        // Extract the employee ID from filename like "appraisal_report_655.txt"
        try {
            return filename.replace("appraisal_report_", "").replace(".txt", "");
        } catch (Exception e) {
            return "UNKNOWN";
        }
    }
}