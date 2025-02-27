package pt.ipl.isel.ps.iqueue.mapping;

import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.AttendanceDao;
import pt.ipl.isel.ps.iqueue.model.Attendance;

@Component
public class AttendanceDaoModelMapper implements DaoModelMapper<AttendanceDao, Attendance> {
    @Override
    public Attendance mapDaoToModel(AttendanceDao dao) {
        return new Attendance(dao.getAttendanceId(), dao.getServiceQueueId(),
                dao.getDeskId(), dao.getClientId(), dao.getStartWaitingDateTime(),
                dao.getStartAttendanceDateTime(), dao.getEndAttendanceDateTime(),
                dao.getAttendanceStatusId());
    }

    @Override
    public AttendanceDao mapModelToDao(Attendance model) {
        return new AttendanceDao(model.getAttendanceId(), model.getServiceQueueId(),
                model.getDeskId(), model.getClientId(), model.getStartWaitingDateTime(),
                model.getStartAttendanceDateTime(), model.getEndAttendanceDateTime(),
                model.getAttendanceStatusId());
    }
}
