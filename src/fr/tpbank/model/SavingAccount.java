package fr.tpbank.model;

import java.util.Date;
import java.util.List;

public class SavingAccount extends Account{

    /**
     * Constructeur
     *
     * @param numBankAccount
     * @param customer
     * @param balance
     */
    public SavingAccount(String numBankAccount, Customer customer, double balance, Date createDate) {
        super(typesAccount.SAVING_ACCOUNT.toString(), numBankAccount, customer, balance, createDate);
    }

    @Override
    public String toString() {
        return "COMPTE D'EPARGNE : " + super.toString();
    }
}
