package Services;
import java.io.File;
import model.Employee;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import model.Employee;
import Calculator.AppraisalCalculator;


public class AppraisalService {
    private static final String REPORTS_DIRECTORY = "./reports";

    public void evaluate(Employee employee) {
        try {
            // Calculate performance score
            double score = calculatePerformanceScore(employee);

            // Calculate appraisal percentage
            double appraisalPercentage = calculateAppraisalPercentage(score, employee);

            // Generate and display report
            generateAppraisalReport(employee, score, appraisalPercentage);

            // Show report viewer
            showReportViewer();

        } catch (DateTimeParseException e) {
            System.err.println("Error parsing date/time: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred during appraisal: " + e.getMessage());
        }
    }

    private double calculatePerformanceScore(Employee employee) {
        double score = 0;

        // Work metrics
        score += employee.getTicketsClosed() * 2;
        score -= employee.getDisciplinaryActions() * 5;
        score -= employee.getTicketsRemaining() * 1.5;

        // Review scores
        score += employee.getSelfReview() * 2;
        score += employee.getManagerReview() * 3;
        score += employee.getCoworkerReview() * 2;
        score += employee.getInnovation() * 2;
        score += employee.getPunctuality() * 1.5;

        // Punctuality adjustment
        LocalTime arrival = LocalTime.parse(employee.getArrivalTime());
        if (arrival.isBefore(LocalTime.of(9, 15))) score += 3;
        if (arrival.isAfter(LocalTime.of(10, 0))) score -= 3;

        return Math.min(Math.max(score, 0), 100);
    }

    private double calculateAppraisalPercentage(double score, Employee employee) {
        double appraisalPercentage = 0;

        // Base percentage based on score
        if (score >= 80) appraisalPercentage = 15;
        else if (score >= 60) appraisalPercentage = 10;
        else if (score >= 40) appraisalPercentage = 5;

        // Salary adjustment
        if (employee.getCurrentSalaryLPA() > 30) appraisalPercentage *= 0.5;
        else if (employee.getCurrentSalaryLPA() < 8) appraisalPercentage *= 1.5;

        // Tenure adjustment
        LocalDate joining = LocalDate.parse(employee.getJoiningDate());
        long years = ChronoUnit.YEARS.between(joining, LocalDate.now());
        if (years < 1) appraisalPercentage = 0;
        else if (years > 3) appraisalPercentage += 5;

        return Math.round(appraisalPercentage * 100.0) / 100.0;
    }

    private void generateAppraisalReport(Employee employee, double score, double appraisalPercentage) {
        double newSalary = employee.getCurrentSalaryLPA() * (1 + appraisalPercentage / 100);
        newSalary = Math.round(newSalary * 100.0) / 100.0;

        // Display report
        System.out.println("\n--- Appraisal Report ---");
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Performance Score: " + score + " / 100");
        System.out.println("Appraisal Percentage: " + appraisalPercentage + "%");
        System.out.println("Revised Salary: ₹" + newSalary + " LPA");

        // Save to file
        saveReportToFile(employee, score, appraisalPercentage, newSalary);
    }

    private void saveReportToFile(Employee employee, double score, double appraisalPercentage, double newSalary) {
        // Ensure reports directory exists
        new File(REPORTS_DIRECTORY).mkdirs();

        String filename = REPORTS_DIRECTORY + "/appraisal_report_" + employee.getId() + ".txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("--- Appraisal Report ---\n");
            writer.write("Employee Name: " + employee.getName() + "\n");
            writer.write("Employee ID: " + employee.getId() + "\n");
            writer.write("Performance Score: " + score + " / 100\n");
            writer.write("Appraisal Percentage: " + appraisalPercentage + "%\n");
            writer.write("Revised Salary: ₹" + newSalary + " LPA\n");
            System.out.println("✅ Appraisal saved to: " + Paths.get(filename).toAbsolutePath());
        } catch (IOException e) {
            System.err.println("❌ Failed to save appraisal: " + e.getMessage());
        }
    }

    private void showReportViewer() {
        Scanner scanner = new Scanner(System.in);
        ReportReaderService reader = new ReportReaderService(scanner);
        reader.startReportViewer();
        scanner.close();
    }
}