package cache;

import utilizatori.Administrator;
import java.io.Serializable;
import java.util.HashMap;

public class AdminList implements Crud<Administrator>, Serializable {

    private static final long serialVersionUID = 1L;
    private HashMap<String, Administrator> adminList = new HashMap<>();

    @Override
    public Administrator create(Administrator element) {
        return adminList.put(element.getId(), element);
    }

    @Override
    public Administrator read(String id) {
        return adminList.get(id);
    }

    @Override
    public Administrator update(String id, Administrator element) {
        return adminList.replace(id, element);
    }

    @Override
    public Administrator delete(String id) {
        return adminList.remove(id);
    }

    @Override
    public String toString(){
        String display = "-->";
        for(String key : adminList.keySet()) {
            String id = key.toString();
            String admin = adminList.get(key.toString()).toString();
            display += "Map id: " + id + " " + admin;
        }
        return display;
    }
}
