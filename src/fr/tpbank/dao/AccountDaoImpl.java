package fr.tpbank.dao;

import fr.tpbank.database.DatabaseConnection;
import fr.tpbank.model.Account;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    //On récupère la connection à la base de données via le Singleton
    Connection connection = DatabaseConnection.getInstance().getConnection();

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
