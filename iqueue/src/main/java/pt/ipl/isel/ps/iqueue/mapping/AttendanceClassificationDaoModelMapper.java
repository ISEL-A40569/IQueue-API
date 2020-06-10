package pt.ipl.isel.ps.iqueue.mapping;

import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.AttendanceClassificationDao;
import pt.ipl.isel.ps.iqueue.model.AttendanceClassification;

@Component
public class AttendanceClassificationDaoModelMapper implements DaoModelMapper<AttendanceClassificationDao, AttendanceClassification> {
    @Override
    public AttendanceClassification mapDaoToModel(AttendanceClassificationDao dao) {
        return new AttendanceClassification(dao.getAttendanceId(), dao.getClassificationCreationTime(),
                dao.getRate(), dao.getObservations());
    }

    @Override
    public AttendanceClassificationDao mapModelToDao(AttendanceClassification model) {
        return new AttendanceClassificationDao(model.getAttendanceId(), model.getClassificationCreationTime(),
                model.getRate(), model.getObservations());
    }
}
