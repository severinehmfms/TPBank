package fr.tpbank.dao;

import fr.tpbank.database.DatabaseConnection;
import fr.tpbank.factories.AccountFactory;
import fr.tpbank.model.Account;
import fr.tpbank.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    //On récupère la connection à la base de données via le Singleton
    Connection connection = DatabaseConnection.getInstance().getConnection();

    /**
     * Méthode qui permet à partir d'un ResultSet de la base de données, de créer une instance Account
     * @param resultSet
     * @return
     * @throws SQLException
     */
    public Account getAccountFromDb(ResultSet resultSet) throws SQLException {
        //Dao pour gérer les opérations en base
        //TransactionDaoImpl opDao = new TransactionDaoImpl();

        //Dao pour récupérer le customer
        CustomerDao customerDao = new CustomerDaoImpl();
        AccountFactory accountFactory = new AccountFactory();

        Account account = null;
        try {
            String rsNumBankAccount = resultSet.getString("account_num");
            String rsTypeAccount = resultSet.getString("type_account");

            java.sql.Date rsCreateDate = resultSet.getDate("create_date");
            java.util.Date utilCreateDate = new java.util.Date(rsCreateDate.getTime());

            double rsBalance = resultSet.getDouble("balance");

            int rsCustomerId = resultSet.getInt("customer_id");

            //On va récupérer le customer correspondant à cet id
            Customer customer = customerDao.readById(rsCustomerId);

            //On va récupérer la liste des opérations correspondant à ce compte bancaire
            //List<Transaction> listTransactions = new ArrayList<Transaction>();
            //listTransactions = opDao.findAllByAccount(rsNumBankAccount);

            //On va passer par le factory pour créer l'account !
            account = accountFactory.CreateFactory(rsTypeAccount, rsNumBankAccount, customer, rsBalance, rsCreateDate);

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account readByNum(String numAccount) {
        Account account = null;
        String strSql = "SELECT * FROM Account WHERE account_num = ?";
        try (PreparedStatement ps = connection.prepareStatement(strSql)){
            ps.setString(1, numAccount);
            //System.out.println(strSql);
            try(ResultSet resultSet = ps.executeQuery()){
                if (resultSet.next()) { // On lit la première (et unique) ligne
                    //On va construire l'objet Account correspondant à ce ResultSet
                    account = getAccountFromDb(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public List<Account> readAllByCustomer(int idCustomer) {
        List<Account> lstAccounts = new ArrayList<Account>();

        String strSql = "SELECT * FROM Account WHERE customer_id=?";
        try (PreparedStatement ps = connection.prepareStatement(strSql)){
            ps.setInt(1, idCustomer);

            try(ResultSet resultSet = ps.executeQuery()){
                while(resultSet.next()) {
                    lstAccounts.add(getAccountFromDb(resultSet));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstAccounts;
    }

}
