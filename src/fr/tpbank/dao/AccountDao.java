package fr.tpbank.dao;

import fr.tpbank.model.Account;

import java.util.List;

public interface AccountDao {
    Account readByNum(String numAccount);

    List<Account> readAllByCustomer(int idCustomer);

    boolean save(Account account);
}
