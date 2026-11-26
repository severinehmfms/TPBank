package fr.tpbank.dao;
import java.sql.Connection;
import fr.tpbank.model.Customer;
import java.util.List;

public interface CustomerDao {

    Customer findById(int id);
    List<Customer> findAll();
    void save(Customer customer);

}
