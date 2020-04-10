package pt.ipl.isel.ps.iqueue.model;

public class ServiceQueueType {
    private int serviceQueueTypeId;
    private int languageId;
    private String serviceQueueTypeDescription;

    public ServiceQueueType() {
    }

    public ServiceQueueType(int serviceQueueTypeId, int languageId, String serviceQueueTypeDescription) {
        this.serviceQueueTypeId = serviceQueueTypeId;
        this.languageId = languageId;
        this.serviceQueueTypeDescription = serviceQueueTypeDescription;
    }

    public int getServiceQueueTypeId() {
        return serviceQueueTypeId;
    }

    public void setServiceQueueTypeId(int serviceQueueTypeId) {
        this.serviceQueueTypeId = serviceQueueTypeId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public String getServiceQueueTypeDescription() {
        return serviceQueueTypeDescription;
    }
}
