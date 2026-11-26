package fr.tpbank.dao;

import fr.tpbank.model.Account;

import java.sql.Connection;
import java.util.List;

public interface AccountDao {
    Account findById(int id, Connection connection);
    List<Account> findAll(Connection connection);
    void save(Account account, Connection connection);
}
