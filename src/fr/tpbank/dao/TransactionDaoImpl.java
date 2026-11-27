package fr.tpbank.dao;

import fr.tpbank.database.DatabaseConnection;
import fr.tpbank.model.Transaction;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao{

    //On récupère la connection à la base de données via le Singleton
    Connection connection = DatabaseConnection.getInstance().getConnection();


    @Override
    public Transaction findById(int id) {
        return null;
    }

    @Override
    public List<Transaction> findAll() {
        return Collections.emptyList();
    }

    @Override
    public void save(Transaction transaction) {

    }
}
