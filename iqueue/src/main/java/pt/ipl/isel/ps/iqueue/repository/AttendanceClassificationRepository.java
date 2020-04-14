package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.AttendanceClassification;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.AttendanceClassificationRowMapper;

import java.util.List;

@Component
public class AttendanceClassificationRepository extends Repository<AttendanceClassification> {

    public AttendanceClassificationRepository(JdbcTemplate jdbcTemplate, AttendanceClassificationRowMapper attendanceClassificationRowMapper) {
        super(jdbcTemplate, attendanceClassificationRowMapper,
                "exec SelectAttendanceClassification ?",
                "exec InsertAttendanceClassification ?, ?, ?, ?",
               null, null);
    }

    @Override
    public AttendanceClassification getById(int attendanceId) {
        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{attendanceId}, rowMapper);
    }

    @Override
    public List<AttendanceClassification> getAll() {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null}, rowMapper);
    }

    @Override
    public int add(AttendanceClassification attendanceClassification) {
        return jdbcTemplate.update(insertQueryTemplate, attendanceClassification.getAttendanceId(),
                attendanceClassification.getClassificationCreationTime(),
                attendanceClassification.getRate(),
                attendanceClassification.getObservations()) == 1 ? attendanceClassification.getAttendanceId() : 0;
    }

    @Override
    public boolean remove(int id) {
        throw new UnsupportedOperationException();
    }     // TODO: DELETE function

    @Override
    public boolean update(AttendanceClassification attendanceClassification) {
        throw new UnsupportedOperationException();
    }
}
