package pt.ipl.isel.ps.iqueue.dao;

import javax.persistence.*;

@Entity
@Table(name = "Operator")
public class OperatorDao {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "operatorId")
    private int operatorId;

    @Column(name = "operatorDescription")
    private String operatorDescription;

    @Column(name = "email")
    private String email;

    @Column(name = "telephoneNumber")
    private String telephoneNumber;

    @Column(name = "address")
    private String address;

    public OperatorDao() {
    }

    public OperatorDao(int operatorId, String operatorDescription, String email, String telephoneNumber, String address) {
        this.operatorId = operatorId;
        this.operatorDescription = operatorDescription;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
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

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getAddress() {
        return address;
    }
}
