package fr.tpbank.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Compte bancaire
 */
public abstract class Account {

    public static enum typesAccount {
        CHECKING_ACCOUNT, SAVING_ACCOUNT
    }

    private int typeAccount;
    private String numBankAccount;				//Numéro de compte
    private Customer customer;					//Titulaire du compte
    private double balance;					    //Solde du compte (mis à jour après chaque opération)
    private List<Transaction> lstTransactions;	//Liste des transactions associées à ce compte

    /**
     * Constructeur
     * @param typeAccount
     * @param numBankAccount
     * @param customer
     * @param balance
     */
    public Account(int typeAccount, String numBankAccount, Customer customer, double balance) {
        this.typeAccount = typeAccount;
        this.numBankAccount = numBankAccount;
        this.customer = customer;
        this.balance = balance;
    }

    /**
     * Méthode toString
     */
    @Override
    public String toString() {
        return "Numéro de compte : " + this.numBankAccount + " - Titulaire : " + this.customer.getName() + " - Solde : " + this.balance + "€";
    }

    public String getNumBankAccount() {
        return numBankAccount;
    }

    public void setNumBankAccount(String numBankAccount) {
        this.numBankAccount = numBankAccount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getLstTransactions() {
        return lstTransactions;
    }

    public void setLstTransactions(List<Transaction> lstTransactions) {
        this.lstTransactions = lstTransactions;
    }
}






