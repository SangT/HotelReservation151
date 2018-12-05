package general.user;

import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Account.java - A class to store account information
 * @author Sang To
 * @version 1.0
 */
public class Account implements Serializable {
    private String username;
    private String id;
    private String password;

    /**
     * Account class has id and password for log in
     * @param id
     * @param password
     */
    public Account(String id, String password) {
//        this.username = username;
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void writeObject(ObjectOutputStream out) {

    }
}
