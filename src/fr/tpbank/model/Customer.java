package fr.tpbank.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    /**
     * Client
     */
    protected int idCustomer;				    //Numéro du client (en base)
    protected String name;					    //Nom du client tel qu'il est inscrit sur les comptes
    protected String firstName;
    protected String lastName;

    /**
     * Constructeur simple sans l'id ni le mail
     * @param name
     * @param firstName
     * @param lastName
     */
    public Customer(String name, String firstName, String lastName) {
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
    }


}


