package fr.tpbank.dao;

import fr.tpbank.database.DatabaseConnection;
import fr.tpbank.model.Account;

import java.util.Collections;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    //On récupère l'instance de la connection
    DatabaseConnection connection = DatabaseConnection.getInstance();

    @Override
    public Account findById(int id) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return Collections.emptyList();
    }

    @Override
    public void save(Account account) {

    }
}
