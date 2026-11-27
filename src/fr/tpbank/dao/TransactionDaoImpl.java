package fr.tpbank.dao;

import fr.tpbank.database.DatabaseConnection;
import fr.tpbank.model.Deposit;
import fr.tpbank.model.Transaction;
import fr.tpbank.model.Withdrawal;

import java.sql.*;
import java.util.ArrayList;
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

            //Date rsTransactionDate = resultSet.getDate("bank_transaction_date");
            java.sql.Date rsTransactionDate = resultSet.getDate("bank_transaction_date");
            java.util.Date utilTransactionDate = new java.util.Date(rsTransactionDate.getTime());

            double rsAmount = resultSet.getDouble("amount");
            String rsTypeTransaction = resultSet.getString("type_transaction");
            String numBankAccount = resultSet.getString("account_num");

            // Pour l'instant on gère que deux cas mais à améliorer dans l'absolu...
            if (rsTypeTransaction.equals(Transaction.typesTransaction.DEPOSIT.toString())) {
                transaction = new Deposit(rsTransactionDate, rsAmount, numBankAccount);
                transaction.setTransactionId(rsTransactionId);
            }else{
                transaction = new Withdrawal(rsTransactionDate, rsAmount, numBankAccount);
                transaction.setTransactionId(rsTransactionId);
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

        String strSql = "SELECT * FROM banktransaction WHERE account_num = ? ORDER BY bank_transaction_date DESC";
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
    public boolean create(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO banktransaction(bank_transaction_id, bank_transaction_date, amount, type_transaction, account_num ) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, transaction.getTransactionId());
            ps.setDate(2, new java.sql.Date(transaction.getDateTransaction().getTime()));

            ps.setDouble(3, transaction.getAmount());
            if (transaction instanceof Deposit) {
                // C'est un dépôt
                ps.setString(4, Transaction.typesTransaction.DEPOSIT.toString() );
            } else if (transaction instanceof Withdrawal) {
                // C'est un retrait
                ps.setString(4, Transaction.typesTransaction.WITHDRAWAL.toString() );
            }
            ps.setString(5, transaction.getNumBankAccount());
            if( ps.executeUpdate() == 0)
                 throw new SQLException("Échec de l'insertion, aucune ligne affectée.");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
