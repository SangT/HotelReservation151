package mvc.action;

import mvc.user.Account;

/**
 * A LogIn class to check username and password
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
