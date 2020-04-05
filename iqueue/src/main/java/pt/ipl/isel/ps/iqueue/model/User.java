package pt.ipl.isel.ps.iqueue.model;

public class User {

    private int userId;
    private final String userName;
    private final String email;
    private final int phoneNumber;
    private final String address;
    private final int userProfileId;

    public User(String userName, String email, int phoneNumber, String address, int userProfileId) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userProfileId = userProfileId;
    }

    public User(int userId, String userName, String email, int phoneNumber, String address, int userProfileId) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userProfileId = userProfileId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getUserProfileId() {
        return userProfileId;
    }
}
