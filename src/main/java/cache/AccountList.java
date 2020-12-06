package cache;

import java.io.Serializable;
import java.util.HashMap;

public class AccountList implements Serializable {

    private static final long serialVersionUID = 1L;
    private HashMap<String, String> accountList = new HashMap<String, String>();

    public void create(String Iban, String userName) {
        this.accountList.put(Iban, userName);
    }

    public String getUser(String Iban) {
        return this.accountList.get(Iban);
    }

}
