package org.example.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void depositPositiveAmountShouldIncreaseBalance() {
        // **Given** - Initial state
        BankAccount account = new BankAccount(100.0);

        // **When** - Action under test
        account.deposit(50.0);

        // **Then** - Expected outcome
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    public void withdrawValidAmountShouldDecreaseBalance() {
        // Given
        BankAccount account = new BankAccount(200.0);

        // When
        account.withdraw(75.0);

        // Then
        assertEquals(125.0, account.getBalance(), 0.001);
    }

    @Test
    public void withdrawAmountExceedingBalanceShouldThrowException() {
        // Given
        BankAccount account = new BankAccount(50.0);

        // When-Then (combined for exception testing)
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(100.0);
        });
    }

    @Test
    public void depositNegativeAmountShouldThrowException() {
        // Given
        BankAccount account = new BankAccount(100.0);

        // When-Then
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-10.0);
        });
    }

    @Test
    public void initialBalanceCannotBeNegative() {
        // When-Then
        assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(-50.0);
        });
    }

    @Test
    public void withdrawNegativeAmountShouldThrowException() {
        // Given
        BankAccount account = new BankAccount(100.0);

        // When-Then
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-20.0);
        });
    }

}
