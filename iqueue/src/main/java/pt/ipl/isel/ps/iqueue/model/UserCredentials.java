package pt.ipl.isel.ps.iqueue.model;

import javax.persistence.Column;

public class UserCredentials {

    private final int userId;

    private final String password;

    public UserCredentials(int userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
