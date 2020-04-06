package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.AttendanceStatus;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.AttendanceStatusRowMapper;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.BeaconRowMapper;

import java.util.List;

@Component
public class AttendanceStatusRepository extends Repository<AttendanceStatus> {

    public AttendanceStatusRepository(JdbcTemplate jdbcTemplate, AttendanceStatusRowMapper attendanceStatusRowMapper) {
        super(jdbcTemplate, attendanceStatusRowMapper, "exec SelectAttendanceStatus ?, ?",
                "exec InsertAttendanceStatus ?, ?, ?",
                "exec DeleteAttendanceStatus ?, ?",
                "exec UpdateAttendanceStatus ?, ?, ?");
    }

    @Override
    public AttendanceStatus getById(int attendanceStatusId) {
        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{attendanceStatusId}, rowMapper);
    }

    @Override
    public List<AttendanceStatus> getAll() {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null}, rowMapper);
    }

    @Override
    public boolean add(AttendanceStatus attendanceStatus) {
        return jdbcTemplate.update(insertQueryTemplate, attendanceStatus.getAttendanceStatusId(),
                attendanceStatus.getLanguageId(), attendanceStatus.getAttendanceStatusDescription()) == 1;
    }

    @Override
    public boolean remove(int attendanceStatusId) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(int attendanceStatusId, int languageId) {
        return jdbcTemplate.update(removeQueryTemplate, attendanceStatusId, languageId) == 1;
    }

    @Override
    public boolean update(AttendanceStatus attendanceStatus) {
        return jdbcTemplate.update(updateQueryTemplate, attendanceStatus.getAttendanceStatusId(),
                attendanceStatus.getLanguageId(), attendanceStatus.getAttendanceStatusDescription()) == 1;    }
}
