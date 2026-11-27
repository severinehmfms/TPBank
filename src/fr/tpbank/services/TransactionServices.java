package fr.tpbank.services;

import fr.tpbank.dao.TransactionDao;
import fr.tpbank.dao.TransactionDaoImpl;
import fr.tpbank.model.Transaction;

public class TransactionServices {

    //Dao pour gérer les opérations en base
    TransactionDao transactionDao = new TransactionDaoImpl();

    /**
     * Service qui permet de récupérer une transaction à partir de son id
     * @param idTransaction
     * @return
     */
    public Transaction readById(int idTransaction){
        return transactionDao.readById(idTransaction);
    }

}
