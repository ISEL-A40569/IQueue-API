package pt.ipl.isel.ps.iqueue.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserCredentials")
public class UserCredentialsDao {
    @Id
    @Column(name = "userId")
    private int userId;

    @Column(name = "password")
    private String password;

    public UserCredentialsDao() {
    }

    public UserCredentialsDao(int userId, String password) {
        this.userId = userId;
        this.password = password;
    }

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
