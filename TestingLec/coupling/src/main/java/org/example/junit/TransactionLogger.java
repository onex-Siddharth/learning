package org.example.junit;

public interface TransactionLogger {
    void logTransaction(String message);
    void logError(String error);
}
