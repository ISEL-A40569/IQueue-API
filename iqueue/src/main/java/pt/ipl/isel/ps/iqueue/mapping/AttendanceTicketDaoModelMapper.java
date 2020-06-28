package pt.ipl.isel.ps.iqueue.mapping;

import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.AttendanceTicketDao;
import pt.ipl.isel.ps.iqueue.model.AttendanceTicket;

@Component
public class AttendanceTicketDaoModelMapper implements DaoModelMapper<AttendanceTicketDao, AttendanceTicket> {
    @Override
    public AttendanceTicket mapDaoToModel(AttendanceTicketDao dao) {
        return new AttendanceTicket(dao.getAttendanceId(), dao.getTicketNumber());
    }

    @Override
    public AttendanceTicketDao mapModelToDao(AttendanceTicket model) {
        return new AttendanceTicketDao(model.getAttendanceId(), model.getTicketNumber());
    }
}
