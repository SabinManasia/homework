package servicii;

import cache.AccountList;
import cache.DataBase;
import cache.UserList;
import utilizatori.Client;

public class AccountService {

    private final DataBase<UserList> userListDataBase = new DataBase<UserList>("userList.dat");
    private final DataBase<AccountList> accountListDataBase = new DataBase<AccountList>("accountList.dat");
    private UserList userList;
    private AccountList accountList;

    public void moneyTransfer(String fromIban, String toIban, double amount){
        this.userList = userListDataBase.readObject();
        this.accountList = accountListDataBase.readObject();

        Client fromClient = userList.read(accountList.getUser(fromIban));
        Client toClient = userList.read(accountList.getUser(toIban));

        decreaseAccountAmountDebit(fromIban, amount, fromClient);
        toClient.getDebitAccountByIban(toIban).increaseAmountBy(amount);
        System.out.println("Transfer successful!");

        this.userList.update(fromClient.getUserName(), fromClient);
        this.userList.update(toClient.getUserName(), toClient);
        this.userListDataBase.writeObject(this.userList);

    }

    public void moneyExtraction(String fromIban, double amount){
        this.userList = userListDataBase.readObject();
        this.accountList = accountListDataBase.readObject();

        Client fromClient = userList.read(accountList.getUser(fromIban));
        decreaseAccountAmountDebit(fromIban,amount, fromClient);
        System.out.println("Payment successful!");

        this.userList.update(fromClient.getUserName(), fromClient);
        this.userListDataBase.writeObject(this.userList);
    }

    public void depositToAccount(String toIban, double amount){
        this.userList = userListDataBase.readObject();
        this.accountList = accountListDataBase.readObject();

        Client toClient = userList.read(accountList.getUser(toIban));
        toClient.getDebitAccountByIban(toIban).increaseAmountBy(amount);
        this.userList.update(toClient.getUserName(), toClient);
        this.userListDataBase.writeObject(this.userList);
    }

    public void creditExtraction(String fromIban, double amount){
        this.userList = userListDataBase.readObject();
        this.accountList = accountListDataBase.readObject();

        Client fromClient = userList.read(accountList.getUser(fromIban));
        decreaseAccountAmountDebit(fromIban,amount, fromClient);
        System.out.println("Payment successful!");

        this.userList.update(fromClient.getUserName(), fromClient);
        this.userListDataBase.writeObject(this.userList);
    }

    private  void decreaseAccountAmountCredit(String fromIban, double amount, Client fromClient){
        if(hasCreditAvailable(amount,fromClient.getCreditAccountById(fromIban).getLimitAmount(), fromClient.getCreditAccountById(fromIban).getUsedAmount())){
            fromClient.getCreditAccountById(fromIban).decreaseAmountBy(amount);
        }
    }

    private boolean hasCreditAvailable(double trasferAmount, double limit, double usedAmount){
        if(trasferAmount <= limit - usedAmount){
            return true;
        }
        return false;
    }
    private void decreaseAccountAmountDebit(String fromIban, double amount, Client fromClient) {
        if(hasAmountForTransferDebit(amount, fromClient.getDebitAccountByIban(fromIban).getAmount())){
            fromClient.getDebitAccountByIban(fromIban).decreaseAmountBy(amount);
        }
    }
    private boolean hasAmountForTransferDebit(double transferAmount, double balance){
        if(balance - transferAmount < 0){
            System.out.println("Insufficient funds!");
            return false;
        }
        return true;
    }



}
