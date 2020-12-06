package controller;

import utilizatori.Client;

public class ControllerPF {

    public static boolean transferToIBAN(String fromIBAN, String toIBAN, Client client){
        // call account service
        return true;
    }

    public static boolean externalTransfer(int amount, String fromIBAN, Client client){
        // call account service
        return true;
    }

    public static boolean externalReceive(int amount, String toIBAN, Client client){
        // call account service
        return true;
    }

    public static int checkAccountAmt(String IBAN, Client client){
        // call account service
        return 0;
    }
}
