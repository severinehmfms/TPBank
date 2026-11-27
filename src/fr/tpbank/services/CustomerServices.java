package fr.tpbank.services;

import fr.tpbank.dao.CustomerDao;
import fr.tpbank.dao.CustomerDaoImpl;
import fr.tpbank.model.Customer;

import java.util.List;

public class CustomerServices {

    //Dao pour gérer les clients en base
    CustomerDao customerDao = new CustomerDaoImpl();

    /**
     * Méthode qui retourne un client à partir de son id
     * @param id_customer
     * @return
     */
    public Customer readById(int id_customer){
        return customerDao.readById(id_customer);
    }

    /**
     * Méthode qui retourne la liste des clients
     * @return
     */
    public List<Customer> readAll() {
        return customerDao.readAll();
    }

}
