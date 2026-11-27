package fr.tpbank.dao;

import java.sql.Connection;
import fr.tpbank.model.Transaction;
import java.util.List;

public interface TransactionDao {

    Transaction readById(int id);
    List<Transaction> readAllByAccount(String numBankAccount);
    void save(Transaction transaction);
}
