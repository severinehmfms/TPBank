package fr.tpbank.services;

import fr.tpbank.dao.CustomerDaoImpl;
import fr.tpbank.model.Customer;

import java.util.List;

public class CustomerServices {

    //Dao pour gérer les clients en base
    CustomerDaoImpl customerDao = new CustomerDaoImpl();

    public List<Customer> findAll() {
        List<Customer> lstCustomer = customerDao.findAll();
        return lstCustomer;
    }


}
