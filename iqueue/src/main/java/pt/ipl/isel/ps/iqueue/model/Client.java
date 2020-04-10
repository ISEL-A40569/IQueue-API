package pt.ipl.isel.ps.iqueue.model;

public class Client {

    private int clientId;
    private String clientName;
    private String email;

    public Client() {
    }

    public Client(String clientName, String email) {
        this.clientName = clientName;
        this.email = email;
    }

    public Client(int clientId, String clientName, String email) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.email = email;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getEmail() {
        return email;
    }
}
