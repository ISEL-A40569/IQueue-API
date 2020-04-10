package pt.ipl.isel.ps.iqueue.model;

public class Operator {
    private int operatorId;
    private String operatorDescription;
    private String email;
    private int phoneNumber;
    private String address;

    public Operator() {
    }

    public Operator(String operatorDescription, String email, int phoneNumber, String address) {
        this.operatorDescription = operatorDescription;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Operator(int operatorId, String operatorDescription, String email, int phoneNumber, String address) {
        this.operatorId = operatorId;
        this.operatorDescription = operatorDescription;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorDescription() {
        return operatorDescription;
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
}
