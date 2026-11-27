package fr.tpbank.dao;

import java.sql.Connection;
import fr.tpbank.model.Transaction;

import java.sql.SQLException;
import java.util.List;

public interface TransactionDao {

    Transaction readById(int id);
    List<Transaction> readAllByAccount(String numBankAccount);
    boolean create(Transaction transaction) throws SQLException;
}
