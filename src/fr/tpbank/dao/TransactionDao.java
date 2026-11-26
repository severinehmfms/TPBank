package fr.tpbank.dao;

import java.sql.Connection;
import fr.tpbank.model.Transaction;
import java.util.List;

public interface TransactionDao {

    Transaction findById(int id);
    List<Transaction> findAll();
    void save(Transaction transaction);
}
