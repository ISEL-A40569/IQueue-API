package pt.ipl.isel.ps.iqueue.model;

public class ServiceQueueType {
    private final int serviceQueueTypeId;
    private final int languageId;
    private final String serviceQueueTypeDescription;

    public ServiceQueueType(int serviceQueueTypeId, int languageId, String serviceQueueTypeDescription) {
        this.serviceQueueTypeId = serviceQueueTypeId;
        this.languageId = languageId;
        this.serviceQueueTypeDescription = serviceQueueTypeDescription;
    }

    public int getServiceQueueTypeId() {
        return serviceQueueTypeId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public String getServiceQueueTypeDescription() {
        return serviceQueueTypeDescription;
    }
}
