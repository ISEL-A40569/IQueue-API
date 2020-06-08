package pt.ipl.isel.ps.iqueue.mapping;

import pt.ipl.isel.ps.iqueue.dao.AttendanceDao;
import pt.ipl.isel.ps.iqueue.model.Attendance;

public class AttendanceDaoModelMapper implements DaoModelMapper<AttendanceDao, Attendance> {
    @Override
    public Attendance mapDtoToModel(AttendanceDao dao) {
        return new Attendance(dao.getAttendanceId(), dao.getServiceQueueId(),
                dao.getDeskId(), dao.getClientId(), dao.getStartWaitingTime(),
                dao.getStartAttendanceTime(), dao.getEndAttendanceTime(),
                dao.getAttendanceStatusId());
    }

    @Override
    public AttendanceDao mapModelToDto(Attendance model) {
        return new AttendanceDao(model.getAttendanceId(), model.getServiceQueueId(),
                model.getDeskId(), model.getClientId(), model.getStartWaitingTime(),
                model.getStartAttendanceTime(), model.getEndAttendanceTime(),
                model.getAttendanceStatusId());
    }
}
