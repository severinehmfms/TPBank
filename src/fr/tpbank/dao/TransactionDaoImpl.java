package fr.tpbank.dao;

import fr.tpbank.model.Transaction;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao{

    @Override
    public Transaction findById(int id, Connection connection) {
        return null;
    }

    @Override
    public List<Transaction> findAll(Connection connection) {
        return Collections.emptyList();
    }

    @Override
    public void save(Transaction transaction, Connection connection) {

    }
}
