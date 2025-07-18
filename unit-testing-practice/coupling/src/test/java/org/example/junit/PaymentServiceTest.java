package org.example.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

  @Mock private BankAccount mockAccount;

  @Mock private TransactionLogger mockLogger;

  @InjectMocks private PaymentService paymentService;

  @Test
  public void makePaymentSufficientFundsShouldSucceedAndLog() {
    // Given
    double paymentAmount = 100.0;
    String recipient = "Amazon";
    double initialBalance = 200.0;

    // Configure mock behavior
    doNothing().when(mockAccount).withdraw(paymentAmount);

    // When
    boolean result = paymentService.makePayment(paymentAmount, recipient);

    // Then
    assertTrue(result);
    verify(mockAccount).withdraw(paymentAmount);
    verify(mockLogger).logTransaction("Payment of " + paymentAmount + " to " + recipient);
    verify(mockLogger, never()).logError(anyString());
  }

  @Test
  public void makePaymentInsufficientFundsShouldFailAndLogError() {
    // Given
    double paymentAmount = 500.0;
    String recipient = "Netflix";
    String errorMessage = "Insufficient funds";

    // Configure mock to throw exception
    doThrow(new IllegalArgumentException(errorMessage)).when(mockAccount).withdraw(paymentAmount);
    // When
    boolean result = paymentService.makePayment(paymentAmount, recipient);

    // Then
    assertFalse(result);
    verify(mockAccount).withdraw(paymentAmount);
    verify(mockLogger).logError("Payment failed: " + errorMessage);
    verify(mockLogger, never()).logTransaction(anyString());
  }

  @Test
  public void receivePaymentValidAmountShouldDepositAndLog() {
    // Given
    double paymentAmount = 200.0;
    String sender = "Client ABC";

    // Configure mock behavior
    doNothing().when(mockAccount).deposit(paymentAmount);

    // When
    paymentService.receivePayment(paymentAmount, sender);

    // Then
    verify(mockAccount).deposit(paymentAmount);
    verify(mockLogger).logTransaction("Received " + paymentAmount + " from " + sender);
  }

  @Test
    public void getAccountBalanceShouldReturnCorrectBalance() {
        // Given
        double expectedBalance = 300.0;

        // Configure mock behavior
        when(mockAccount.getBalance()).thenReturn(expectedBalance);

        // When
        double actualBalance = paymentService.getAccountBalance();

        // Then
        assertEquals(expectedBalance, actualBalance);
        verify(mockAccount).getBalance();
    }
}
