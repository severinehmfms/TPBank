package fr.tpbank.dao;

import fr.tpbank.model.Account;

import java.util.List;

public interface AccountDao {
    Account findById(int id);
    List<Account> findAll();
    void save(Account account);
}
