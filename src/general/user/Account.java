package general.user;

import general.Hotel;

import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Account.java - A class to store account information
 * @author Sang To
 * @version 1.0
 */
public class Account implements Serializable {
    private String id;
    private String password;
    protected Hotel hotelStayingAt;

    /**
     * Account class has id and password for log in
     * @param id
     * @param password
     */
    public Account(Hotel h, String id, String password) {
        hotelStayingAt = h;
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Hotel getHotelStayingAt() {
        return hotelStayingAt;
    }
}
