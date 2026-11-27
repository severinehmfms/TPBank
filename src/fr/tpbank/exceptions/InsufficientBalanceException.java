package fr.tpbank.exceptions;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException() {
        super("Solde insuffisant");
    }
}