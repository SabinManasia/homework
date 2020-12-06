package cache;

import utilizatori.Client;
import java.io.Serializable;
import java.util.HashMap;

public class UserList implements Crud<Client>, Serializable {

    private static final long serialVersionUID = 1L;
    private HashMap<String, Client> userList = new HashMap<String, Client>();

    @Override
    public Client create(Client element) {
        return userList.put(element.getUserName(), element);
    }

    @Override
    public Client read(String id) {
        return userList.get(id);
    }

    @Override
    public Client update(String id, Client element) {
        return userList.replace(id, element);
    }

    @Override
    public Client delete(String id) {
        return userList.remove(id);
    }

    @Override
    public String toString(){
        String display = "-->";
        for(String key : userList.keySet()) {
            String id = key.toString();
            String user = userList.get(key.toString()).toString();
            display += "Map id: " + id + " " + user;
        }
        return display;
    }
}
