package pt.ipl.isel.ps.iqueue.mapping;

import pt.ipl.isel.ps.iqueue.dao.AttendanceClassificationDao;
import pt.ipl.isel.ps.iqueue.model.AttendanceClassification;

public class AttendanceClassificationDaoModelMapper implements DaoModelMapper<AttendanceClassificationDao, AttendanceClassification> {
    @Override
    public AttendanceClassification mapDtoToModel(AttendanceClassificationDao dao) {
        return new AttendanceClassification(dao.getAttendanceId(), dao.getClassificationCreationTime(),
                dao.getRate(), dao.getObservations());
    }

    @Override
    public AttendanceClassificationDao mapModelToDto(AttendanceClassification model) {
        return new AttendanceClassificationDao(model.getAttendanceId(), model.getClassificationCreationTime(),
                model.getRate(), model.getObservations());
    }
}
