package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

public abstract class Repository<T> {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    protected RowMapper<T> rowMapper;

    public Repository(JdbcTemplate jdbcTemplate, RowMapper<T> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    public abstract T get(int id);

    public abstract List<T> getAll();

    public abstract boolean add(T t);

    public abstract boolean remove(int id);

    public abstract boolean update(T t);

}
