package pt.ipl.isel.ps.iqueue.model;

import javax.persistence.Column;

public class Operator {
    private final int operatorId;
    private final String operatorDescription;
    private final String email;
    private final int phoneNumber;
    private final String address;

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
