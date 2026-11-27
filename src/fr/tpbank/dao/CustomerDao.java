package fr.tpbank.dao;
import java.sql.Connection;
import fr.tpbank.model.Customer;
import java.util.List;

public interface CustomerDao {

    Customer readById(int id);

    List<Customer> readAll();

}
