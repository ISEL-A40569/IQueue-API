package pt.ipl.isel.ps.iqueue.model;

public class Operator {
    private int operatorId;
    private String operatorDescription;
    private String email;
    private String telephoneNumber;
    private String address;

    public Operator(int operatorId, String operatorDescription, String email, String telephoneNumber, String address) {
        this.operatorId = operatorId;
        this.operatorDescription = operatorDescription;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
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

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public void setOperatorDescription(String operatorDescription) {
        this.operatorDescription = operatorDescription;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
