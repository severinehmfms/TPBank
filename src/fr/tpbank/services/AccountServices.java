package fr.tpbank.services;

import fr.tpbank.dao.AccountDaoImpl;
import fr.tpbank.model.Account;

import java.util.List;

/**
 * Classe qui contient les méthodes métiers concernant les comptes bancaires
 */
public class AccountServices {

    //Dao pour gérer les comptes bancaires en base
    AccountDaoImpl accountDao = new AccountDaoImpl();

    /**
     * Service qui permet de récupérer un compte à partir du numéro de compte
     * @param numAccount
     * @return
     */
    public Account readByNum(String numAccount){
        return accountDao.readByNum(numAccount);
    }

    /**
     * Service qui permet de récupérer la liste des comptes d'un client à partir de son numéro de client
     * @param id_customer
     * @return
     */
    public List<Account> readAllByCustomer(int id_customer) {
        return accountDao.readAllByCustomer(id_customer);
    }

}
