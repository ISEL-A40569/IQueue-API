package pt.ipl.isel.ps.iqueue.model;

import javax.persistence.*;

@Entity
@Table(name = "UserCredentials")
public class UserCredentials {
    @Id
    @Column(name = "userId")
    private int userId;

    @Column(name = "password")
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
