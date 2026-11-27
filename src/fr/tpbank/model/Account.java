package fr.tpbank.model;

import java.util.Date;
import java.util.List;

/**
 * Compte bancaire
 */
public abstract class Account {

    public static enum typesAccount {
        CHECKING_ACCOUNT, SAVING_ACCOUNT
    }

    private String numAccount;		    		//Numéro de compte
    private String typeAccount;
    private Date createDate;
    private Customer customer;					//Titulaire du compte
    private double balance;					    //Solde du compte (mis à jour après chaque opération)
    private List<Transaction> lstTransactions;	//Liste des transactions associées à ce compte

    /**
     * Constructeur
     * @param typeAccount
     * @param numAccount
     * @param customer
     * @param balance
     */
    public Account(String typeAccount, String numAccount, Customer customer, double balance, Date createDate) {
        this.typeAccount = typeAccount;
        this.numAccount = numAccount;
        this.customer = customer;
        this.balance = balance;
        this.createDate = createDate;
    }

    /**
     * Méthode getType abstraite
     * @return
     */
    public abstract String getType();

    /**
     * Méthode toString
     */
    @Override
    public String toString() {
        return "Numéro de compte : " + this.numAccount + " - Titulaire : " + this.customer.getName() + " Créé le : " + this.createDate + " - Solde : " + this.balance + "€";
    }

    public String getNumAccount() {
        return numAccount;
    }

    public void setNumAccount(String numAccount) {
        this.numAccount = numAccount;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Transaction> getLstTransactions() {
        return lstTransactions;
    }

    public void setLstTransactions(List<Transaction> lstTransactions) {
        this.lstTransactions = lstTransactions;
    }
}






