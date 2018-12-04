package general.gui;

import general.user.Account;

/**
 * A LogIn class to check username and password
 * @author Sang To
 * @version 1.0
 */
public class LogIn {
    private String id;
    private String pass;
    private Account account;

    public LogIn(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }

    public boolean checkAccount(String a, String b) {
        if (account.getId().equals(a) && account.getPassword().equals(b)) {
            return true;
        }
        return false;
    }
}
