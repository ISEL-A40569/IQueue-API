package pt.ipl.isel.ps.iqueue.model;

public class Beacon {

    private int beaconId;
    private String beaconMacAddress;
    private String uidNamespaceId;
    private String uidInstanceId;
    private String iBeaconUuid;
    private String iBeaconMajor;
    private String iBeaconMinor;
    private String manufacturer;
    private String model;

    public Beacon() {
    }

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
