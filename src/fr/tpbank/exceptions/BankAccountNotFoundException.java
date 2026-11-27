package fr.tpbank.exceptions;

public class BankAccountNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public BankAccountNotFoundException(String msg) {
        super(msg);
    }
    public BankAccountNotFoundException() {
        super("Aucun compte n'est associé à ce numéro de compte");
    }
}