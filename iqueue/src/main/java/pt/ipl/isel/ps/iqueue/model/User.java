package pt.ipl.isel.ps.iqueue.model;

public class User {

    private final int userId;

    private final String userName;

    private final String email;

    private final String telephoneNumber;

    private final String address;

    private final int userProfileId;

    public User(int userId, String userName, String email, String telephoneNumber, String address, int userProfileId) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.userProfileId = userProfileId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getUserProfileId() {
        return userProfileId;
    }
}
