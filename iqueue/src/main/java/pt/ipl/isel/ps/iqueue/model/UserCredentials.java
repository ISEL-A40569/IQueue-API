package pt.ipl.isel.ps.iqueue.model;

public class UserCredentials {

    private int userId;

    private String password;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
