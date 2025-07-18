package services;
import model.Employee;
import services.ReportReaderService;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class AppraisalService {

    public void evaluate(Employee e) {
        double score = 0;

        score += e.ticketsClosed * 2;
        score -= e.disciplinaryActions * 5;
        score -= e.ticketsRemaining * 1.5;
        score += e.selfReview * 2;
        score += e.managerReview * 3;
        score += e.coworkerReview * 2;
        score += e.innovation * 2;
        score += e.punctuality * 1.5;

        LocalTime arrival = LocalTime.parse(e.arrivalTime);
        if (arrival.isBefore(LocalTime.of(9, 15))) score += 3;
        if (arrival.isAfter(LocalTime.of(10, 0))) score -= 3;

        double normalizedScore = Math.min(Math.max(score, 0), 100);
        double appraisalPercentage = 0;

        if (normalizedScore >= 80) appraisalPercentage = 15;
        else if (normalizedScore >= 60) appraisalPercentage = 10;
        else if (normalizedScore >= 40) appraisalPercentage = 5;

        if (e.currentSalaryLPA > 30) appraisalPercentage *= 0.5;
        else if (e.currentSalaryLPA < 8) appraisalPercentage *= 1.5;

        LocalDate joining = LocalDate.parse(e.joiningDate);
        long years = ChronoUnit.YEARS.between(joining, LocalDate.now());
        if (years < 1) appraisalPercentage = 0;
        else if (years > 3) appraisalPercentage += 5;

        appraisalPercentage = Math.round(appraisalPercentage * 100.0) / 100.0;
        double newSalary = e.currentSalaryLPA + (e.currentSalaryLPA * appraisalPercentage / 100);

        System.out.println("\n--- Appraisal Report ---");
        System.out.println("model.Employee Name: " + e.name);
        System.out.println("model.Employee ID: " + e.id);
        System.out.println("Performance Score: " + normalizedScore + " / 100");
        System.out.println("Appraisal Percentage: " + appraisalPercentage + "%");
        System.out.println("Revised Salary: ₹" + newSalary + " LPA");

        // Save to file
        try (FileWriter writer = new FileWriter("appraisal_report_" + e.id + ".txt")) {
            writer.write("--- Appraisal Report ---\n");
            writer.write("model.Employee Name: " + e.name + "\n");
            writer.write("model.Employee ID: " + e.id + "\n");
            writer.write("Performance Score: " + normalizedScore + " / 100\n");
            writer.write("Appraisal Percentage: " + appraisalPercentage + "%\n");
            writer.write("Revised Salary: ₹" + newSalary + " LPA\n");
            System.out.println("✅ Appraisal saved to file: appraisal_report_" + e.id + ".txt");
        } catch (IOException ex) {
            System.out.println("❌ Failed to write appraisal file: " + ex.getMessage());
        }
        ReportReaderService reader = new ReportReaderService();
        reader.readAllReports();  // ← this will now read from the "out" folder

    }
}
