package pt.ipl.isel.ps.iqueue.model;

public class EddystoneUid {
    private final String namespaceId;

    private final String instanceId;

    public EddystoneUid(String namespaceId, String instanceId) {
        this.namespaceId = namespaceId;
        this.instanceId = instanceId;
    }

    public String getNamespaceId() {
        return namespaceId;
    }

    public String getInstanceId() {
        return instanceId;
    }
}
