package fr.tpbank.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    /**
     * Client
     */
    private int idCustomer;				    //Numéro du client (en base)
    private String name;					    //Nom du client tel qu'il est inscrit sur les comptes
    private String firstName;
    private String lastName;
    private String mail;

    /**
     * Constructeur
     * @param idCustomer
     * @param name
     * @param firstName
     * @param lastName
     * @param mail
     */
    public Customer(int idCustomer, String name, String firstName, String lastName, String mail) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
    }

    /**
     * Redéfinition de la méthode toString
     * @return
     */
    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}


