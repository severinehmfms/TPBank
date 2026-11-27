package fr.tpbank.factories;

import fr.tpbank.model.Account;
import fr.tpbank.model.CheckingAccount;
import fr.tpbank.model.Customer;
import fr.tpbank.model.SavingAccount;

import java.util.Date;

/**
 * Fabrique pour un Account
 */
public class AccountFactory {

    /**
     * Méthode qui permet de créer le bon type d'Account suivant son type. Les types sont définis dans le modèle Account.
     * @param type
     * @param numBankAccount
     * @param customer
     * @param balance
     * @return
     */
    public Account CreateFactory(String type, String numBankAccount, Customer customer, double balance, Date createDate) {
        if (type.equalsIgnoreCase(Account.typesAccount.CHECKING_ACCOUNT.toString())) {
            return new CheckingAccount(numBankAccount,customer,balance,createDate);
        } else if (type.equalsIgnoreCase(Account.typesAccount.SAVING_ACCOUNT.toString())) {
            return new SavingAccount(numBankAccount,customer,balance,createDate);
        }else
            throw new UnsupportedOperationException("Type de compte non supporté : " + type);
    }
}

