package fr.tpbank.model;

import java.util.Date;
import java.util.List;

public class CheckingAccount extends Account{
    /**
     * Constructeur
     *
     * @param numBankAccount
     * @param customer
     * @param balance
     */
    public CheckingAccount(String numBankAccount, Customer customer, double balance, Date createDate) {
        super(typesAccount.CHECKING_ACCOUNT.toString(), numBankAccount, customer, balance, createDate);
    }

    @Override
    public String toString() {
        return "COMPTE COURANT : " + super.toString();
    }

    @Override
    public String getType() {
        return typesAccount.CHECKING_ACCOUNT.toString();
    }

}
