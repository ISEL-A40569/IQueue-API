package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.Attendance;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.AttendanceRowMapper;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class AttendanceRepository extends Repository<Attendance> {

    public AttendanceRepository(JdbcTemplate jdbcTemplate, AttendanceRowMapper attendanceRowMapper) {
        super(jdbcTemplate, attendanceRowMapper,
                "exec SelectAttendance ?, ?, ?, ?, ?, ?", "exec InsertAttendance ?, ?, ?, ?, ?, ?, ?",
                "exec DeleteAttendance ?","exec UpdateAttendance ?, ?, ?, ?, ?");
    }

    @Override
    public Attendance getById(int attendanceId) {
        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{attendanceId, null, null, null, null, null}, rowMapper);
    }

    @Override
    public List<Attendance> getAll() {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null, null, null, null, null, null}, rowMapper);
    }

    public List<Attendance> getSome(int operatorId, int serviceQueueId, int deskId, int clientId, LocalDateTime startWaitingTime) {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null, operatorId, serviceQueueId, deskId, clientId, startWaitingTime}, rowMapper);
    }

    @Override
    public int add(Attendance attendance) {
        return jdbcTemplate.update(insertQueryTemplate, attendance.getOperatorId(),
                attendance.getServiceQueueId(), attendance.getDeskId(), attendance.getClientId(),
                attendance.getStartWaitingTime(), attendance.getAttendanceStatusId(),
                attendance.getAttendanceUserId());
    }

    @Override
    public boolean remove(int attendanceId) {
        return jdbcTemplate.update(removeQueryTemplate, attendanceId) == 1;
    }

    @Override
    public boolean update(Attendance attendance) {
        return jdbcTemplate.update(updateQueryTemplate, attendance.getAttendanceId(),
                attendance.getEndWaitingTime(), attendance.getStartAttendanceTime(),
                attendance.getEndAttendanceTime(), attendance.getAttendanceStatusId()) == 1;
    }
}
