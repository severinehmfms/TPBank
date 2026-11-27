package fr.tpbank.model;

import java.util.Date;

public class Withdrawal extends Transaction{
    /**
     * Constructeur
     *
     * @param transactionId
     * @param dateTransaction
     * @param amount
     * @param numBankAccount
     */
    public Withdrawal(int transactionId, Date dateTransaction, double amount, String numBankAccount) {
        super(transactionId, dateTransaction, amount, numBankAccount);
    }
}
