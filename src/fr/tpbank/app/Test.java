package fr.tpbank.app;

import fr.tpbank.exceptions.BankAccountNotFoundException;
import fr.tpbank.exceptions.InsufficientBalanceException;
import fr.tpbank.model.Account;
import fr.tpbank.model.Customer;
import fr.tpbank.model.Deposit;
import fr.tpbank.model.Transaction;
import fr.tpbank.services.AccountServices;
import fr.tpbank.services.CustomerServices;
import fr.tpbank.services.TransactionServices;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) throws BankAccountNotFoundException, SQLException, InsufficientBalanceException {
        testCustomer();

        testAccount();

        testTransaction();
    }

    public static void testCustomer() {
        System.out.println("\n\nTest pour les clients");
        CustomerServices service = new CustomerServices();

        //Test affichage de tous les clients
        System.out.println("\n\nTest readAll : Liste de tous les clients :\n");
        List<Customer> lstCustomers = service.readAll();
        for (Customer customer : lstCustomers) {
            System.out.println(customer + "\n");
        }

        //Test affichage d'un client par son id
        System.out.println("\n\nTest readById : Client numéro 1 :\n");
        Customer customer = service.readById(1);
        System.out.println(customer);
    }

    public static void testAccount() {
        System.out.println("\n\nTest pour les comptes bancaires");

        AccountServices service = new AccountServices();

        //TODO Si je veux supprimer le compte après je met à true
        boolean wanttosup = false;

        //Test affichage d'un compte par son id.
        System.out.println("\n\nTest readByNum : Affichage du compte FR-1234-5678 :\n");
        String numAccountTestEnBase = "FR-1234-5678";
        Account account = service.readByNum(numAccountTestEnBase);
        System.out.println(account);

        //Test affichage de tous les comptes bancaires d'un client
        System.out.println("\n\nTest readAllByCustomer : Liste des comptes bancaires existants pour le client numéro 1 :\n");
        List<Account> lstComptes = service.readAllByCustomer(1);
        for (Account compte : lstComptes) {
            System.out.println(compte+"\n");
        }

        //Modification d'un compte
        System.out.println("\n\nTest save : Modification du solde du compte FR-1234-5678 :\n");
        account.setBalance(20000.05);
        if (service.save(account)){
            System.out.println("La modification du solde du compte FR-1234-5678 a bien été effectuée ");
        }
    }

    public static void testTransaction() throws BankAccountNotFoundException, SQLException, InsufficientBalanceException {
        System.out.println("\n\nTest pour les opérations bancaires");

        TransactionServices service = new TransactionServices();

        //Test affichage de la transaction numéro 1
        System.out.println("\n\nAffichage de la transaction numéro 1 :");
        Transaction transaction = service.readById(1);
        System.out.println(transaction);

        //Affichage des transactions concernant le compte FR1245FR1245
        System.out.println("\n\nAffichage des transactions du compte FR1245FR1245 :");
        String numAccountTestEnBase = "FR-1234-5678";
        List<Transaction> lstTransactions = service.readAllByAccount(numAccountTestEnBase);
        for (Transaction t : lstTransactions) {
            System.out.println(t+"\n");
        }

        //Test dépôt
        if (service.deposit(numAccountTestEnBase, 5000)){
            System.out.println("Dépôt de 5000 sur le compte FR-1234-5678 bien effectué\n");
        }

        //Test retrait
        if (service.withdrawal(numAccountTestEnBase, 1000)){
            System.out.println("Retrait de 1000 sur le compte FR-1234-5678 bien effectué\n");
        }

        //TODO TEST d'une transaction
        //Transaction test = new Deposit(new Date(), 50000, numAccountTestEnBase);
        //service.create

    }

}
