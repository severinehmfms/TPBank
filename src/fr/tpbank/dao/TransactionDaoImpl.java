package fr.tpbank.dao;

import fr.tpbank.database.DatabaseConnection;
import fr.tpbank.model.Customer;
import fr.tpbank.model.Deposit;
import fr.tpbank.model.Transaction;
import fr.tpbank.model.Withdrawal;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao{

    //On récupère la connection à la base de données via le Singleton
    Connection connection = DatabaseConnection.getInstance().getConnection();

    /**
     * Méthode qui permet à partir d'un ResultSet de la base de données, de créer une instance Transaction
     * @param resultSet
     * @return
     * @throws SQLException
     */
    public Transaction getTransactionFromDb(ResultSet resultSet) throws SQLException {
        Transaction transaction = null;
        try {
            int rsTransactionId = resultSet.getInt("bank_transaction_id");
            Date rsTransactionDate = resultSet.getDate("bank_transaction_date");
            double rsAmount = resultSet.getDouble("amount");
            String rsTypeTransaction = resultSet.getString("type_transaction");
            String numBankAccount = resultSet.getString("account_num");

            if (rsTypeTransaction.equals(Transaction.typesTransaction.DEPOSIT.toString())) {
                transaction = new Deposit(rsTransactionId, rsTransactionDate, rsAmount, numBankAccount);
            }else{
                transaction = new Withdrawal(rsTransactionId, rsTransactionDate, rsAmount, numBankAccount);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    @Override
    public Transaction readById(int id_transaction) {
        Transaction transaction = null;
        String strSql = "SELECT * FROM Banktransaction WHERE bank_transaction_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(strSql)){
            ps.setInt(1, id_transaction);
            //System.out.println(strSql);
            try(ResultSet resultSet = ps.executeQuery()){

                if (resultSet.next()) { // On lit la première (et unique) ligne
                    transaction = getTransactionFromDb(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    @Override
    public List<Transaction> readAllByAccount(String numBankAccount) {
        List<Transaction> lstTransactions = new ArrayList<Transaction>();

        String strSql = "SELECT * FROM banktransaction WHERE account_num = ?";
        try (PreparedStatement ps = connection.prepareStatement(strSql)){
            ps.setString(1, numBankAccount);

            //System.out.println(strSql);
            try(ResultSet resultSet = ps.executeQuery()){
                while(resultSet.next()) {
                    lstTransactions.add(getTransactionFromDb(resultSet));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lstTransactions;
    }

    @Override
    public void save(Transaction transaction) {

    }
}
