package pt.ipl.isel.ps.iqueue.dao;

import pt.ipl.isel.ps.iqueue.dao.keys.ServiceQueueTypeIds;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ServiceQueueType")
public class ServiceQueueTypeDao {

    @EmbeddedId
    private ServiceQueueTypeIds serviceQueueTypeIds;

    @Column(name = "serviceQueueTypeDescription")
    private String serviceQueueTypeDescription;

    public ServiceQueueTypeDao() {
    }

    public ServiceQueueTypeDao(ServiceQueueTypeIds serviceQueueTypeIds, String serviceQueueTypeDescription) {
        this.serviceQueueTypeIds = serviceQueueTypeIds;
        this.serviceQueueTypeDescription = serviceQueueTypeDescription;
    }

    public ServiceQueueTypeIds getServiceQueueTypeIds() {
        return serviceQueueTypeIds;
    }

    public void setServiceQueueTypeIds(ServiceQueueTypeIds serviceQueueTypeIds) {
        this.serviceQueueTypeIds = serviceQueueTypeIds;
    }

    public String getServiceQueueTypeDescription() {
        return serviceQueueTypeDescription;
    }

    public void setServiceQueueTypeDescription(String serviceQueueTypeDescription) {
        this.serviceQueueTypeDescription = serviceQueueTypeDescription;
    }
}


