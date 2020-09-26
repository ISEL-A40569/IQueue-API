package pt.ipl.isel.ps.iqueue.mapping;

import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.AttendanceStatusDao;
import pt.ipl.isel.ps.iqueue.dao.keys.AttendanceStatusIds;
import pt.ipl.isel.ps.iqueue.model.AttendanceStatus;

@Component
public class AttendanceStatusDaoModelMapper implements DaoModelMapper<AttendanceStatusDao, AttendanceStatus> {
    @Override
    public AttendanceStatus mapDaoToModel(AttendanceStatusDao dao) {
        return new AttendanceStatus(dao.getAttendanceStatusIds().getAttendanceStatusId(),
                dao.getAttendanceStatusIds().getLanguageId(),
                dao.getAttendanceStatusDescription());
    }

    @Override
    public AttendanceStatusDao mapModelToDao(AttendanceStatus model) {
        return new AttendanceStatusDao(new AttendanceStatusIds(model.getAttendanceStatusId(),
                model.getLanguageId()), model.getAttendanceStatusDescription());
    }
}
