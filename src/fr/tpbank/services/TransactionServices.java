package fr.tpbank.services;

import fr.tpbank.dao.CustomerDaoImpl;
import fr.tpbank.dao.TransactionDao;
import fr.tpbank.dao.TransactionDaoImpl;

public class TransactionServices {

    //Dao pour gérer les opérations en base
    TransactionDao transactionDao = new TransactionDaoImpl();


}
