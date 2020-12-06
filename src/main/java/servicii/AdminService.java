package servicii;

import cache.AccountList;
import cache.DataBase;
import cache.UserList;
import dto.CreditBankAccountDTO;
import dto.DebitBankAccountDTO;
import utilizatori.Client;
import utilizatori.ClientPF;
import utilizatori.ClientPJ;

public class AdminService {

    private final DataBase<UserList> userListDataBase = new DataBase<UserList>("userList.dat");
    private final DataBase<AccountList> accountListDataBase = new DataBase<AccountList>("accountList.dat");
    private UserList userList;
    private AccountList accountList;

    public void createNewUser(Client newUser){
        this.userList = userListDataBase.readObject();
        this.userList.create(newUser);
        this.userListDataBase.writeObject(this.userList);
    }

    public void deleteUser(Client client){
        this.userList = userListDataBase.readObject();
        this.userList.delete(client.getUserName());
        this.userListDataBase.writeObject(this.userList);
    }
    public void createDebitAccount(String userName){
        this.userList = userListDataBase.readObject();
        this.accountList = accountListDataBase.readObject();

        Client client = this.userList.read(userName);
        DebitBankAccountDTO newDebitAccount = new DebitBankAccountDTO(userName);
        client.addDebitAccountDTO(newDebitAccount);
        this.accountList.create(newDebitAccount.getIBAN(), userName);
        this.userList.update(userName, client);
        this.userListDataBase.writeObject(this.userList);
        this.accountListDataBase.writeObject(this.accountList);
    }

    public void createCreditAccount(String userName){
        this.userList = userListDataBase.readObject();
        Client client = this.userList.read(userName);
        double creditLimit = this.creditLimitCalculator(client);
        CreditBankAccountDTO newCreditAccount = new CreditBankAccountDTO(userName, creditLimit);
        client.addCreditAccountDTO(newCreditAccount);
        this.accountList.create(newCreditAccount.getId(), userName);
        this.userList.update(userName, client);
        this.userListDataBase.writeObject(this.userList);
    }

    private double creditLimitCalculator(Client client) {
        if (client instanceof ClientPJ) {
            return client.getIncome() * 1.1;
        }
        if (client instanceof ClientPF) {
            return client.getIncome() * 2;
        }
        System.out.println("Client does not have correct class"); // error log entry
        return 0;
    }

}
