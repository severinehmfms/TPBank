package fr.tpbank.app;

import fr.tpbank.model.Account;
import fr.tpbank.model.Customer;
import fr.tpbank.model.Transaction;
import fr.tpbank.services.AccountServices;
import fr.tpbank.services.CustomerServices;
import fr.tpbank.services.TransactionServices;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args){
        testCustomer();

        testAccount();

        testTransaction();
    }

    public static void testCustomer() {
        System.out.println("\n\nTest pour les clients");

        CustomerServices service = new CustomerServices();

        //TODO Si je veux supprimer les clients créés après je met à true
        boolean wanttosup = true;

        //Test affichage de tous les clients
        System.out.println("--Test findAll : Liste de toutes les opérations existantes :\n");
        List<Customer> lstCustomers = service.readAll();
        for (Customer customer : lstCustomers) {
            System.out.println(customer + "\n");
        }

        //Test affichage d'un client par son id
        Customer customer = service.readById(1);
        System.out.println(customer);

    }

    public static void testAccount() {
        System.out.println("\n\nTest pour les comptes bancaires");

        AccountServices service = new AccountServices();

        //TODO Si je veux supprimer le compte après je met à true
        boolean wanttosup = false;

        //Test affichage d'un compte par son id.
        String numAccountTestEnBase = "FR1245FR1245";
        Account account = service.readByNum(numAccountTestEnBase);
        System.out.println(account);

        //Test affichage de tous les comptes bancaires d'un client
        System.out.println("--Test readAllByCustomer : Liste des comptes bancaires existants pour le client numéro 1 :\n");
        List<Account> lstComptes = service.readAllByCustomer(1);
        for (Account compte : lstComptes) {
            System.out.println(compte+"\n");
        }
    }

    public static void testTransaction() {
        System.out.println("\n\nTest pour les opérations bancaires");

        TransactionServices service = new TransactionServices();

        //Test affichage de la transaction numéro 1
        System.out.println("\n\nAffichage de la transaction numéro 1 :");
        Transaction transaction = service.readById(1);
        System.out.println(transaction);

        //Affichage des transactions concernant le compte FR1245FR1245
        System.out.println("\n\nAffichage des transactions du compte FR1245FR1245 :");
        String numAccountTestEnBase = "FR1245FR1245";
        List<Transaction> lstTransactions = service.readAllByAccount(numAccountTestEnBase);
        for (Transaction t : lstTransactions) {
            System.out.println(t+"\n");
        }

    }

}
