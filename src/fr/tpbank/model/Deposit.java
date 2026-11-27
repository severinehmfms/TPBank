package fr.tpbank.model;

import java.util.Date;

public class Deposit extends Transaction{
    /**
     * Constructeur
     *
     * @param transactionId
     * @param dateTransaction
     * @param amount
     * @param numBankAccount
     */
    public Deposit(Date dateTransaction, double amount, String numBankAccount) {
        super(dateTransaction, amount, numBankAccount);
    }
}
