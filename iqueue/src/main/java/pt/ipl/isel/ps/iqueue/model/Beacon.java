package pt.ipl.isel.ps.iqueue.model;

public class Beacon {
    private final int beaconId;
    private final String beaconMacAddress;
    private final String namespaceId;
    private final String instanceId;
    private final String manufacturer;
    private final String model;

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

    public String getBeaconMacAddress() {
        return beaconMacAddress;
    }

    public String getNamespaceId() {
        return namespaceId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }
}
