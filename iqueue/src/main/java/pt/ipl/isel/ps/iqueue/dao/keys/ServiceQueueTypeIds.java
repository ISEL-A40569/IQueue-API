package pt.ipl.isel.ps.iqueue.dao.keys;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ServiceQueueTypeIds implements Serializable {
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
