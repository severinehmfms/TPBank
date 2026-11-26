package fr.tpbank.dao;

import java.sql.Connection;
import fr.tpbank.model.Transaction;
import java.util.List;

public interface TransactionDao {

    Transaction findById(int id, Connection connection);
    List<Transaction> findAll(Connection connection);
    void save(Transaction transaction, Connection connection);
}
