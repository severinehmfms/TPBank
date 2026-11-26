package fr.tpbank.dao;

import java.sql.Connection;
import java.util.List;

import fr.tpbank.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public Customer findById(int id, Connection connection) {
        return null;
    }

    @Override
    public List<Customer> findAll(Connection connection) {
        return null;
    }

    @Override
    public void save(Customer customer, Connection connection) {

    }
}
