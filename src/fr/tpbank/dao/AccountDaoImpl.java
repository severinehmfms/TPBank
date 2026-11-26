package fr.tpbank.dao;

import fr.tpbank.model.Account;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account findById(int id, Connection connection) {
        return null;
    }

    @Override
    public List<Account> findAll(Connection connection) {
        return Collections.emptyList();
    }

    @Override
    public void save(Account account, Connection connection) {

    }
}
