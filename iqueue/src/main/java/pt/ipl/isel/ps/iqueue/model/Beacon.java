package pt.ipl.isel.ps.iqueue.model;

public class Beacon {

    private int beaconId;
    private final String beaconMacAddress;
    private final String uidNamespaceId;
    private final String uidInstanceId;
    private final String iBeaconUuid;
    private final String iBeaconMajor;
    private final String iBeaconMinor;
    private final String manufacturer;
    private final String model;

    public Beacon(String beaconMacAddress, String uidNamespaceId, String uidInstanceId, String iBeaconUuid, String iBeaconMajor, String iBeaconMinor, String manufacturer, String model) {
        this.beaconMacAddress = beaconMacAddress;
        this.uidNamespaceId = uidNamespaceId;
        this.uidInstanceId = uidInstanceId;
        this.iBeaconUuid = iBeaconUuid;
        this.iBeaconMajor = iBeaconMajor;
        this.iBeaconMinor = iBeaconMinor;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public Beacon(int beaconId, String beaconMacAddress, String uidNamespaceId, String uidInstanceId, String iBeaconUuid, String iBeaconMajor, String iBeaconMinor, String manufacturer, String model) {
        this.beaconId = beaconId;
        this.beaconMacAddress = beaconMacAddress;
        this.uidNamespaceId = uidNamespaceId;
        this.uidInstanceId = uidInstanceId;
        this.iBeaconUuid = iBeaconUuid;
        this.iBeaconMajor = iBeaconMajor;
        this.iBeaconMinor = iBeaconMinor;
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

    public String getUidNamespaceId() {
        return uidNamespaceId;
    }

    public String getUidInstanceId() {
        return uidInstanceId;
    }

    public String getiBeaconUuid() {
        return iBeaconUuid;
    }

    public String getiBeaconMajor() {
        return iBeaconMajor;
    }

    public String getiBeaconMinor() {
        return iBeaconMinor;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }
}
