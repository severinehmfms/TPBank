package fr.tpbank.model;

import java.util.Date;
import java.util.List;

public class SavingAccount extends Account{

    private double interestRate;

    /**
     * Constructeur
     *
     * @param numBankAccount
     * @param customer
     * @param balance
     */
    public SavingAccount(String numBankAccount, Customer customer, double balance, Date createDate) {
        super(typesAccount.SAVING_ACCOUNT.toString(), numBankAccount, customer, balance, createDate);
        this.interestRate = 0.03; // 3% par défaut
    }

    @Override
    public String toString() {
        return "COMPTE D'EPARGNE : " + super.toString();
    }

    @Override
    public String getType() {
        return typesAccount.SAVING_ACCOUNT.toString();
    }
}
