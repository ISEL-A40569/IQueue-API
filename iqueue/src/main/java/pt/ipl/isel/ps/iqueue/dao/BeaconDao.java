package pt.ipl.isel.ps.iqueue.dao;

import javax.persistence.*;

@Entity
@Table(name = "Beacon")
public class BeaconDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beaconId")
    private int beaconId;

    @Column(name = "beaconMacAddress")
    private String beaconMacAddress;

    @Column(name = "namespaceId")
    private String namespaceId;

    @Column(name = "instanceId")
    private String instanceId;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "model")
    private String model;

    public BeaconDao() {
    }

    public BeaconDao(int beaconId, String beaconMacAddress, String namespaceId, String instanceId, String manufacturer, String model) {
        this.beaconId = beaconId;
        this.beaconMacAddress = beaconMacAddress;
        this.namespaceId = namespaceId;
        this.instanceId = instanceId;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public int getBeaconId() {
        return beaconId;
    }

    public void setBeaconId(int beaconId) {
        this.beaconId = beaconId;
    }

    public String getBeaconMacAddress() {
        return beaconMacAddress;
    }

    public void setBeaconMacAddress(String beaconMacAddress) {
        this.beaconMacAddress = beaconMacAddress;
    }

    public String getNamespaceId() {
        return namespaceId;
    }

    public void setNamespaceId(String namespaceId) {
        this.namespaceId = namespaceId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
