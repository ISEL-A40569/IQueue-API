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
        throw new UnsupportedOperationException();
    }

    public AttendanceStatus getByIds(int attendanceStatusId, int languageId) {
        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{attendanceStatusId, languageId}, rowMapper);
    }


    public AttendanceStatus getByLanguage(int languageId) {
        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{null, languageId}, rowMapper);
    }

    @Override
    public List<AttendanceStatus> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(AttendanceStatus attendanceStatus) {
        return jdbcTemplate.update(insertQueryTemplate, attendanceStatus.getAttendanceStatusId(),
                attendanceStatus.getLanguageId(), attendanceStatus.getAttendanceStatusDescription()) == 1;
    }

    @Override
    public boolean remove(int attendanceStatusId) {
        throw new UnsupportedOperationException();
    }   //TODO: implement this?!? if so, must change SQL SP query

    public boolean remove(int attendanceStatusId, int languageId) {
        return jdbcTemplate.update(removeQueryTemplate, attendanceStatusId, languageId) == 1;
    }

    @Override
    public boolean update(AttendanceStatus attendanceStatus) {
        return jdbcTemplate.update(updateQueryTemplate, attendanceStatus.getAttendanceStatusId(),
                attendanceStatus.getLanguageId(), attendanceStatus.getAttendanceStatusDescription()) == 1;    }
}
