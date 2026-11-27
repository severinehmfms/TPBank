package fr.tpbank.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.tpbank.database.DatabaseConnection;
import fr.tpbank.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

    //On récupère la connection à la base de données via le Singleton
    Connection connection = DatabaseConnection.getInstance().getConnection();

    /**
     * Méthode qui permet à partir d'un ResultSet de la base de données, de créer une instance Customer
     * @param resultSet
     * @return Customer
     * @throws SQLException
     */
    public Customer getCustomerFromDb(ResultSet resultSet) throws SQLException {
        Customer customer = null;
        try {
            int rsId = resultSet.getInt("customer_id");
            String rsName = resultSet.getString("name");
            String rsFirstName = resultSet.getString("first_name");
            String rsLastName = resultSet.getString("last_name");
            String rsMail = resultSet.getString("mail");

            customer = new Customer(rsId, rsName, rsFirstName, rsLastName, rsMail);

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer readById(int id_customer) {
        Customer customer = null;
        String strSql = "SELECT * FROM Customer WHERE customer_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(strSql)){
            ps.setInt(1, id_customer);
            //System.out.println(strSql);
            try(ResultSet resultSet = ps.executeQuery()){

                if (resultSet.next()) { // On lit la première (et unique) ligne
                    customer = getCustomerFromDb(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> readAll() {
        List<Customer> lstCustomers = new ArrayList<Customer>();

        String strSql = "SELECT * FROM Customer";
        try(Statement statement = connection.createStatement()){
            try(ResultSet resultSet = statement.executeQuery(strSql)){
                while(resultSet.next()) {
                    lstCustomers.add(getCustomerFromDb(resultSet));
                    /*
                    int rsId = resultSet.getInt("customer_id");
                    String rsName = resultSet.getString("name");
                    String rsFirstName = resultSet.getString("first_name");
                    String rsLastName = resultSet.getString("last_name");
                    String rsMail = resultSet.getString("mail");
                    lstCustomers.add(new Customer(rsName, rsFirstName, rsLastName));*/
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lstCustomers;
    }
}
