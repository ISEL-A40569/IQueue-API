package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public abstract class Repository<T> {

    @Autowired
    protected final JdbcTemplate jdbcTemplate;

    @Autowired
    protected final RowMapper<T> rowMapper;

    protected final String getQueryTemplate;
    protected final String insertQueryTemplate;
    protected final String removeQueryTemplate;
    protected final String updateQueryTemplate;

    public Repository(JdbcTemplate jdbcTemplate, RowMapper<T> rowMapper, String getQueryTemplate, String insertQueryTemplate, String removeQueryTemplate, String updateQueryTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
        this.getQueryTemplate = getQueryTemplate;
        this.insertQueryTemplate = insertQueryTemplate;
        this.removeQueryTemplate = removeQueryTemplate;
        this.updateQueryTemplate = updateQueryTemplate;
    }

    public abstract T getById(int id);

    public abstract List<T> getAll();

    public abstract int add(T t);

    public abstract boolean remove(int id);

    public abstract boolean update(T t);
}
