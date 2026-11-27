package fr.tpbank.model;

import java.util.List;

public class SavingAccount extends Account{

    /**
     * Constructeur complet
     *
     * @param typeAccount
     * @param numBankAccount
     * @param customer
     * @param balance
     * @param lstTransactions
     */
    public SavingAccount(int typeAccount, String numBankAccount, Customer customer, double balance, List<Transaction> lstTransactions) {
        super(typeAccount, numBankAccount, customer, balance, lstTransactions);
    }
}
