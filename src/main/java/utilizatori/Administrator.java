package utilizatori;

import java.io.Serializable;

public class Administrator implements Serializable {

    public static final String ADMIN = "adm";
    private static int idGenerator = 1;
    private final String id;
    private final String userName;
    private String password;

    public Administrator(String userName, String password){
        this.id = ADMIN + idGenerator;
        idGenerator++;
        this.userName = userName;
        this.password = password;
    }

    public String getId() {
        return this.id;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "Admin ID: " + this.id + ", User: " + this.userName + ", Password: " + this.password + "\n";
    }
}
