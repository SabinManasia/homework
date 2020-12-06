package mainMethod;

import cache.AdminList;
import cache.DataBase;
import cache.UserList;
import com.sun.xml.internal.bind.v2.model.core.ID;
import dto.DebitBankAccountDTO;
import servicii.AdminService;
import servicii.IdGenerator;
import utilizatori.Administrator;
import utilizatori.Client;
import utilizatori.ClientPF;
import utilizatori.ClientPJ;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        //IdGenerator idGenerator = new IdGenerator();
        //DataBase<IdGenerator> idGeneratorDataBase = new DataBase<>("idList.dat");
        //idGeneratorDataBase.writeObject(idGenerator);
        DataBase<UserList> userListDataBase = new DataBase<UserList>("userList.dat");
        /*UserList userList = new UserList();
        Client client = new ClientPF("pf1", "1234", 3000, "1234", "Ion", "Ion");
        userList.create(client);

        userListDataBase.writeObject(userList);*/

        DebitBankAccountDTO dbt = new DebitBankAccountDTO("1");


        AdminService service = new AdminService();

        //service.createNewUser(new ClientPJ("pj1", "1234", 300000, "1234", "Ion"));

        Client client = userListDataBase.readObject().read("pj1");

        System.out.println(client.getCreditAccountList());
        System.out.println(client);

        //System.out.println(userList);

        /*DataBase<IdGenerator> idDataBase = new DataBase<>("idList.dat");
        IdGenerator id = idDataBase.readObject();
        System.out.println(id);*/

    }
}
