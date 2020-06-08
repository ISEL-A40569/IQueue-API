package pt.ipl.isel.ps.iqueue.dao.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class ServiceQueueTypeIds {
    int serviceQueueTypeId;
    int languageId;

    public ServiceQueueTypeIds() {
    }

    public ServiceQueueTypeIds(int serviceQueueTypeId, int languageId) {
        this.serviceQueueTypeId = serviceQueueTypeId;
        this.languageId = languageId;
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

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
