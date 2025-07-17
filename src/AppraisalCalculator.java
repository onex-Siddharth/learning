import java.util.Scanner;

public class AppraisalCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter number of Jira tickets closed: ");
        int ticketsClosed = scanner.nextInt();

        System.out.print("Enter number of disciplinary actions: ");
        int disciplinaryActions = scanner.nextInt();

        System.out.print("Enter number of tickets remaining: ");
        int ticketsRemaining = scanner.nextInt();

        System.out.print("Enter Self Review Score (0 to 10): ");
        double selfReview = scanner.nextDouble();

        System.out.print("Enter Manager Review Score (0 to 10): ");
        double managerReview = scanner.nextDouble();

        System.out.print("Enter Co-worker Review Score (0 to 10): ");
        double coworkerReview = scanner.nextDouble();

        System.out.print("Enter Innovation Score (0 to 10): ");
        double innovation = scanner.nextDouble();

        System.out.print("Enter Punctuality Score (0 to 10): ");
        double punctuality = scanner.nextDouble();

        System.out.print("Enter current salary in LPA: ");
        double currentSalaryLPA = scanner.nextDouble();


        double score = 0;
        score += ticketsClosed * 2;         // Positive weight
        score -= disciplinaryActions * 5;   // Negative weight
        score -= ticketsRemaining * 1.5;    // Negative weight
        score += selfReview * 2;
        score += managerReview * 3;
        score += coworkerReview * 2;
        score += innovation * 2;
        score += punctuality * 1.5;


        double normalizedScore = Math.min(Math.max(score, 0), 100);


        double appraisalPercentage = 0;
        if (normalizedScore >= 80) {
            appraisalPercentage = 15;
        } else if (normalizedScore >= 60) {
            appraisalPercentage = 10;
        } else if (normalizedScore >= 40) {
            appraisalPercentage = 5;
        } else {
            appraisalPercentage = 0;
        }

        
        if (currentSalaryLPA > 30) {
            appraisalPercentage *= 0.5;  // 50% reduction
        } else if (currentSalaryLPA < 8) {
            appraisalPercentage *= 1.5;  // 50% boost
        }

        // Round off
        appraisalPercentage = Math.round(appraisalPercentage * 100.0) / 100.0;

        // Calculate new salary
        double newSalaryLPA = currentSalaryLPA + (currentSalaryLPA * appraisalPercentage / 100);

        // Display report
        System.out.println("\n--- Appraisal Report ---");
        System.out.println("Performance Score: " + normalizedScore + " / 100");
        System.out.println("Appraisal Percentage: " + appraisalPercentage + "%");
        System.out.println("Revised Salary: ₹" + newSalaryLPA + " LPA");

        scanner.close();
    }
}
