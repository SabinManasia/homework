package servicii;

import utilizatori.Client;

public class Account {

    private final String IBAN;
    private Integer balance;
    private enum type {Credit, Debit};
    private Client owner;

    public Account(String IBAN){
        this.IBAN = IBAN;
    }

}
