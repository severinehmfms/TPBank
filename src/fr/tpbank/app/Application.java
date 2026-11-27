package fr.tpbank.app;
import fr.tpbank.dao.*;
import fr.tpbank.database.DatabaseConnection;
import fr.tpbank.exceptions.BankAccountNoExistsException;
import fr.tpbank.model.Account;
import fr.tpbank.model.Customer;
import fr.tpbank.model.Transaction;
import fr.tpbank.services.AccountServices;
import fr.tpbank.services.CustomerServices;
import fr.tpbank.services.TransactionServices;
import fr.tpbank.utils.Functions;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Application : Partie IHM
 */
public class Application {

    //On initialise le scanner
    private static Scanner scanner = new Scanner(System.in);

    //Services
    private static CustomerServices customerServices = new CustomerServices();
    private static AccountServices accountServices = new AccountServices();
    private static TransactionServices transactionServices = new TransactionServices();

    public static void main(String[] args) throws ParseException, BankAccountNoExistsException {
        String[] menu = {
                "Afficher la liste des clients",
                "Afficher les comptes d'un client",
                "Effectuer un dépôt",
                "Effectuer un retrait",
                "Afficher l'historique des opérations d'un compte"
        };

        String numAccount;
        double amount;

        int choice_user = -1;
        while (choice_user != 0) {
            //On demande à l'utilisateur son choix par rapport au menu proposé
            choice_user = Functions.ask_user_choice(scanner, menu);
            switch(choice_user) {
                case 1:
                    //Afficher la liste des clients
                    System.out.println("Liste des clients : ");
                    List<Customer> lstCustomers = customerServices.readAll();
                    for (Customer customer : lstCustomers) {
                        System.out.println(customer+"\n");
                    }

                    break;
                case 2:
                    //Afficher les comptes d'un client
                    System.out.println("Afficher les comptes d'un client");

                    int customer_id = Functions.input_int(scanner, "Id du client : ");
                    List<Account> lstAccounts = accountServices.readAllByCustomer(customer_id);
                    for (Account account : lstAccounts) {
                        System.out.println(account+"\n");
                    }

                    break;
                case 3:
                    //Effectuer un dépôt
                    System.out.println("Effectuer un dépôt");

                    //TODO Demander au service les montants mini et maxi du dépôt

                    numAccount = inputNumBankAccount(accountServices, "Entrez le numéro du compte sur lequel vous souhaitez effectuer un dépôt : ");
                    amount = Functions.input_double(scanner, "Montant du dépôt : ");
                    transactionServices.deposit(numAccount, amount);

                    break;
                case 4:
                    //Effectuer un retrait
                    System.out.println("Effectuer un retrait");

                    //TODO Demander au service les montants mini et maxi du retrait

                    numAccount = inputNumBankAccount(accountServices, "Entrez le numéro du compte sur lequel vous souhaitez effectuer un dépôt : ");
                    amount = Functions.input_double(scanner, "Montant du retrait : ");
                    transactionServices.withdrawal(numAccount, amount);

                    break;
                case 5:
                    //Historique des opérations
                    System.out.println("Historique des opérations d'un compte");
                    numAccount = inputNumBankAccount(accountServices, "Entrez le numéro du compte dont vous souhaitez consulter l'historique : ");

                    //On récupère le compte correspondant pour l'afficher aussi
                    Account account = accountServices.readByNum(numAccount);
                    System.out.println(account+"\n");

                    //On récupère les transactions liées à ce compte
                    List<Transaction> lstTransactions = transactionServices.readAllByAccount(numAccount);
                    for (Transaction transaction : lstTransactions) {
                        System.out.println(transaction+"\n");
                    }
                    break;
                case 0:
                    System.out.println("Au-revoir et à bientôt !");
                    break;
            }
        }

        //On referme le scanner
        scanner.close();
    }

    /**
     * Fonction qui permet de demander un numéro de compte au format FR-XXXX-XXXX
     * @param accountDao Dao qui permet de gérer en base les Account
     * @param prompt Prompt qui demande à l'utilisateur de saisir
     * @return
     * @throws ParseException
     * @throws BankAccountNoExistsException
     */

    public static String inputNumBankAccount(AccountServices accountServices, String prompt) {
        boolean is_input_ok = false;
        String input_user = "";
        while (!is_input_ok) {
            System.out.println(prompt);
            input_user = scanner.nextLine();

            try {
                if (input_user.trim().isEmpty()) {
                    System.out.println("ERREUR - La saisie ne peut pas être à vide");
                    is_input_ok = false;

                //On vérifie que l'input correspond au format attendu
                }else if (!input_user.matches("^FR-\\d{4}-\\d{4}$")) {
                    throw new ParseException("La saisie doit être au format FR-XXXX-XXXX", 0);

                //On vérifie que ce compte existe
                }else if ( accountServices.readByNum(input_user) == null){
                    throw new BankAccountNoExistsException("Ce compte n'existe pas!");
                }else {
                    is_input_ok = true;
                }
            }catch(ParseException e) {
                e.printStackTrace();
            }catch(BankAccountNoExistsException e) {
                e.printStackTrace();
            }
        }
        return input_user;
    }


}