package Calculator;

import model.Employee;
import services.AppraisalService;

import java.util.Scanner;

public class AppraisalCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee e = new Employee();

        System.out.print("Enter Employee Name: ");
        e.name = scanner.nextLine();

        System.out.print("Enter Employee ID: ");
        e.id = scanner.nextLine();

        System.out.print("Enter number of Jira tickets closed: ");
        e.ticketsClosed = scanner.nextInt();

        System.out.print("Enter number of disciplinary actions: ");
        e.disciplinaryActions = scanner.nextInt();

        System.out.print("Enter number of tickets remaining: ");
        e.ticketsRemaining = scanner.nextInt();

        System.out.print("Enter Self Review Score (0 to 10): ");
        e.selfReview = scanner.nextDouble();

        System.out.print("Enter Manager Review Score (0 to 10): ");
        e.managerReview = scanner.nextDouble();

        System.out.print("Enter Co-worker Review Score (0 to 10): ");
        e.coworkerReview = scanner.nextDouble();

        System.out.print("Enter Innovation Score (0 to 10): ");
        e.innovation = scanner.nextDouble();

        System.out.print("Enter Punctuality Score (0 to 10): ");
        e.punctuality = scanner.nextDouble();

        System.out.print("Enter current salary in LPA: ");
        e.currentSalaryLPA = scanner.nextDouble();
        scanner.nextLine(); // Consume leftover newline

        System.out.print("Enter joining date (yyyy-mm-dd): ");
        e.joiningDate = scanner.nextLine();

        System.out.print("Enter office arrival time (HH:mm): ");
        e.arrivalTime = scanner.nextLine();

        AppraisalService service = new AppraisalService();
        service.evaluate(e);

        scanner.close();
    }
}
