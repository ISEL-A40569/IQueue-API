package pt.ipl.isel.ps.iqueue.model;

public class Beacon {
    private int beaconId;
    private String beaconMacAddress;
    private String namespaceId;
    private String instanceId;
    private String manufacturer;
    private String model;

    public Beacon(int beaconId, String beaconMacAddress, String namespaceId, String instanceId, String manufacturer, String model) {
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
