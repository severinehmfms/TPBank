package fr.tpbank.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Opération bancaire
 */
public abstract class Transaction {

    public static enum typesTransaction {
        DEPOSIT, WITHDRAWAL
    }

    protected int transactionId;
    protected Date dateTransaction;
    protected double amount;
    protected String numBankAccount;    // J'ai mis la chaine car j'avais déjà eu problème de boucle infinie..

}
