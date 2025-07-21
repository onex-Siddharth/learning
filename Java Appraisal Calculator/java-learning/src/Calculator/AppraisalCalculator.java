package Calculator;

import model.Employee;
import Services.AppraisalService;

import java.util.Scanner;

public class AppraisalCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();  // Changed variable name from 'e' to 'employee'

        try {
            System.out.println("\n=== Employee Appraisal Calculator ===");

            // Employee Details
            System.out.print("\nEnter Employee Name: ");
            employee.setName(scanner.nextLine());

            System.out.print("Enter Employee ID: ");
            employee.setId(scanner.nextLine());

            // Work Metrics
            System.out.print("\nEnter number of Jira tickets closed: ");
            employee.setTicketsClosed(getValidIntInput(scanner));

            System.out.print("Enter number of disciplinary actions: ");
            employee.setDisciplinaryActions(getValidIntInput(scanner));

            System.out.print("Enter number of tickets remaining: ");
            employee.setTicketsRemaining(getValidIntInput(scanner));

            // Review Scores
            System.out.println("\nEnter Review Scores (0-10):");
            System.out.print("Self Review Score: ");
            employee.setSelfReview(getValidDoubleInput(scanner, 0, 10));

            System.out.print("Manager Review Score: ");
            employee.setManagerReview(getValidDoubleInput(scanner, 0, 10));

            System.out.print("Co-worker Review Score: ");
            employee.setCoworkerReview(getValidDoubleInput(scanner, 0, 10));

            // Additional Metrics
            System.out.print("\nInnovation Score (0-10): ");
            employee.setInnovation(getValidDoubleInput(scanner, 0, 10));

            System.out.print("Punctuality Score (0-10): ");
            employee.setPunctuality(getValidDoubleInput(scanner, 0, 10));

            // Salary Information
            System.out.print("\nEnter current salary in LPA: ");
            employee.setCurrentSalaryLPA(getValidDoubleInput(scanner, 0, Double.MAX_VALUE));
            scanner.nextLine();
            // Date and Time Information
            System.out.print("\nEnter joining date (yyyy-MM-dd): ");
            employee.setJoiningDate(scanner.nextLine());

            System.out.print("Enter office arrival time (HH:mm): ");
            employee.setArrivalTime(scanner.nextLine());

            // Process Appraisal
            AppraisalService service = new AppraisalService();
            service.evaluate(employee);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Helper method for validating integer input
    private static int getValidIntInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a whole number: ");
                scanner.next(); // Clear invalid input
            }
        }
    }

    // Helper method for validating double input within range
    private static double getValidDoubleInput(Scanner scanner, double min, double max) {
        while (true) {
            try {
                double input = scanner.nextDouble();
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.printf("Input must be between %.1f and %.1f. Please try again: ", min, max);
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next(); // Clear invalid input
            }
        }
    }
}