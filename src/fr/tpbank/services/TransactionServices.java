package fr.tpbank.services;

import fr.tpbank.dao.TransactionDao;
import fr.tpbank.dao.TransactionDaoImpl;
import fr.tpbank.exceptions.BankAccountNotFoundException;
import fr.tpbank.exceptions.InsufficientBalanceException;
import fr.tpbank.model.Account;
import fr.tpbank.model.Deposit;
import fr.tpbank.model.Transaction;
import fr.tpbank.model.Withdrawal;
import fr.tpbank.utils.Functions;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class TransactionServices {

    //Dao pour gérer les opérations en base
    TransactionDao transactionDao = new TransactionDaoImpl();

    /**
     * Service qui permet de récupérer une transaction à partir de son id
     * @param idTransaction
     * @return
     */
    public Transaction readById(int idTransaction){
        return transactionDao.readById(idTransaction);
    }

    public List<Transaction> readAllByAccount(String numAccount) {
        return transactionDao.readAllByAccount(numAccount);
    }

    public boolean deposit(String numAccount, double amount) throws BankAccountNotFoundException, SQLException {
        AccountServices accountServices = new AccountServices();
        Account account = accountServices.readByNum(numAccount);

        try {
            //On déclenche une exception si le compte n'existe pas
            if (account == null){
                throw new BankAccountNotFoundException(numAccount);
            }

            //On met à jour le solde du compte puis on l'enregistre
            account.setBalance(account.getBalance() + amount);
            if (accountServices.save(account)) {
                //TODO Si l'enregistrement a bien été effectué, on crée un nouveau retrait qu'on enregistre également en base
                Deposit deposit = new Deposit(new Date(), amount, numAccount);
                if (!transactionDao.create(deposit)) {
                    return false;
                }
            }else{
                return false;
            }
            return true;
        }catch(BankAccountNotFoundException e) {
            e.printStackTrace();
        }finally {
            return false;
        }
    }

    /**
     * Retrait
     * @param numAccount
     * @param amount
     */
    public boolean withdrawal(String numAccount, double amount) throws BankAccountNotFoundException, InsufficientBalanceException, SQLException {
        AccountServices accountServices = new AccountServices();
        Account account = accountServices.readByNum(numAccount);

        try {
            //On déclenche une exception si le compte n'existe pas
            if (account == null) {
                throw new BankAccountNotFoundException(numAccount);
            }

            //On déclenche une exception si le solde est insuffisant pour ce retrait
            if (account.getBalance() < amount) {
                throw new InsufficientBalanceException();
            }

            //On met à jour le solde du compte puis on l'enregistre
            account.setBalance(account.getBalance() - amount);
            if (accountServices.save(account)) {
                //Si l'enregistrement a bien été effectué, on crée un nouveau retrait qu'on enregistre également en base
                Withdrawal withdrawal = new Withdrawal(new Date(), amount, numAccount);
                if (!transactionDao.create(withdrawal)) {
                    return false;
                }
            } else {
                return false;
            }
            return true;
        }catch(BankAccountNotFoundException e) {
            e.printStackTrace();
        }catch(InsufficientBalanceException e) {
            e.printStackTrace();
        }finally {
            return false;
        }
    }
}
