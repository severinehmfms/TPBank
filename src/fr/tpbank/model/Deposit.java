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
    public Deposit(int transactionId, Date dateTransaction, double amount, String numBankAccount) {
        super(transactionId, dateTransaction, amount, numBankAccount);
    }
}
