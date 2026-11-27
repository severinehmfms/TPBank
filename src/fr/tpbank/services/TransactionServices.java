package fr.tpbank.services;

import fr.tpbank.dao.TransactionDao;
import fr.tpbank.dao.TransactionDaoImpl;
import fr.tpbank.model.Account;
import fr.tpbank.model.Transaction;
import fr.tpbank.utils.Functions;

import java.math.BigDecimal;
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

    public void deposit(String numAccount, double amount){
        AccountServices accountServices = new AccountServices();
        Account account = accountServices.readByNum(numAccount);

        /*
        maxAmount = Account.MAX_BALANCE.doubleValue() - Account.getBalance().doubleValue();
        //System.out.println("Plafond : : "+BankAccount.MAX_BALANCE);
        //System.out.println("Solde actuel : "+bankAccount.getBalance());
        System.out.println("Montant maximal du dépôt : "+maxAmount);
        amount = Functions.input_double(scanner, "Entrez le montant du dépôt", 1, maxAmount);

        if (maxAmount < 1) {
            System.out.println("Le plafond de votre compte est atteint, il ne vous est plus possible d'effectuer un dépôt !");
        }else {
            Deposit op = new Deposit(new Date(), new BigDecimal(amount), numBankAccount);
            opDao.create(op);
            //On met à jour le solde du compte avec ce dépôt
            bankAccount.setBalance(bankAccount.getBalance().add(new BigDecimal(amount)));
            //ON met à jour ce solde en base de données
            if (bkDao.update(bankAccount)) {
                System.out.println("Dépôt bien effectué sur ce compte, le solde est maintenant de "+bankAccount.getBalance() + "€");
            }
        }    */


    }

    public void withdrawal(String numAccount, double amount){
        AccountServices accountServices = new AccountServices();
        Account account = accountServices.readByNum(numAccount);

        /*
        //On récupère le montant disponible sur le compte et on le choisit comme montant max
        numBankAccount = inputNumBankAccount(bkDao, "Entrez le numéro du compte sur lequel vous souhaitez effectuer un dépôt : ",true, false);
        bankAccount = bkDao.readById(numBankAccount);

        maxAmount = bankAccount.getBalance().doubleValue();

        System.out.println("Montant maximal du retrait : "+maxAmount);
        amount = Functions.input_double(scanner, "Entrez le montant du retrait", 1, maxAmount);

        if (maxAmount < 1) {
            System.out.println("Vous n'avez plus d'argent sur votre compte, il ne vous est plus possible d'effectuer un retrait !");
        }else {
            Withdrawal op = new Withdrawal(new Date(), new BigDecimal(amount), numBankAccount);
            opDao.create(op);
            //On met à jour le solde du compte avec ce dépôt
            bankAccount.setBalance(bankAccount.getBalance().subtract(new BigDecimal(amount)));
            //ON met à jour ce solde en base de données
            if (bkDao.update(bankAccount)) {
                System.out.println("Retrait bien effectué sur ce compte, le solde est maintenant de "+bankAccount.getBalance() + "€");
            }
        }

        * */
    }

}
