package pt.ipl.isel.ps.iqueue.mapping;

import pt.ipl.isel.ps.iqueue.dao.AttendanceStatusDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.AttendanceStatusIds;
import pt.ipl.isel.ps.iqueue.model.AttendanceStatus;

public class AttendanceStatusDaoModelMapper implements DaoModelMapper<AttendanceStatusDao, AttendanceStatus> {
    @Override
    public AttendanceStatus mapDtoToModel(AttendanceStatusDao dao) {
        return new AttendanceStatus(dao.getAttendanceStatusIds().getAttendanceStatusId(),
                dao.getAttendanceStatusIds().getLanguageId(),
                dao.getAttendanceStatusDescription());
    }

    @Override
    public AttendanceStatusDao mapModelToDto(AttendanceStatus model) {
        return new AttendanceStatusDao(new AttendanceStatusIds(model.getAttendanceStatusId(),
                model.getLanguageId()), model.getAttendanceStatusDescription());
    }
}
