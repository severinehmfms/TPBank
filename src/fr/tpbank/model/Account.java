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

    protected String numBankAccount;				//Numéro de compte
    protected Customer customer;					//Titulaire du compte
    protected double balance;					    //Solde du compte (mis à jour après chaque opération)
    protected List<Transaction> lstTransactions;	//Liste des transactions associées à ce compte

    /**
     * Méthode toString
     */
    public String toString() {
        return "Numéro de compte : " + this.numBankAccount + " - Titulaire : " + this.customer.name + " - Solde : " + this.balance + "€";
    }


}






