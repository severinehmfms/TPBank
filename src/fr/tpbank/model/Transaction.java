package fr.tpbank.model;

import java.util.Date;

/**
 * Opération bancaire
 */
public abstract class Transaction {

    public static enum typesTransaction {
        DEPOSIT, WITHDRAWAL
    }

    private int transactionId;
    private Date dateTransaction;
    private double amount;
    private String numBankAccount;
    private Account account;

    /**
     * Constructeur
     * @param transactionId
     * @param dateTransaction
     * @param amount
     * @param numBankAccount
     */
    public Transaction(int transactionId, Date dateTransaction, double amount, String numBankAccount) {
        this.transactionId = transactionId;
        this.dateTransaction = dateTransaction;
        this.amount = amount;
        this.numBankAccount = numBankAccount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", dateTransaction=" + dateTransaction +
                ", amount=" + amount +
                ", numBankAccount='" + numBankAccount + '\'' +
                '}';
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNumBankAccount() {
        return numBankAccount;
    }

    public void setNumBankAccount(String numBankAccount) {
        this.numBankAccount = numBankAccount;
    }
}
