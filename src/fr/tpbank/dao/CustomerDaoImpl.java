package fr.tpbank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.tpbank.database.DatabaseConnection;
import fr.tpbank.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

    //On récupère l'instance de la connection
    DatabaseConnection connection = DatabaseConnection.getInstance();

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> lstCustomers = new ArrayList<Customer>();

        String strSql = "SELECT * FROM Customer";
        try(Statement statement = connection.createStatement()){
            try(ResultSet resultSet = statement.executeQuery(strSql)){
                while(resultSet.next()) {

                    int rsId = resultSet.getInt("customer_id");
                    String rsName = resultSet.getString("name");
                    String rsFirstName = resultSet.getString("first_name");
                    String rsLastName = resultSet.getString("last_name");
                    String rsMail = resultSet.getString("mail");
                    lstCustomers.add(new Customer(rsName, rsFirstName, rsLastName));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return lstCustomers;



    }

    @Override
    public void save(Customer customer) {

    }
}
