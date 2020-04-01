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
    protected final String deleteQueryTemplate;
    protected final String updateQueryTemplate;

    public Repository(JdbcTemplate jdbcTemplate, RowMapper<T> rowMapper, String getQueryTemplate, String insertQueryTemplate,
                      String deleteQueryTemplate, String updateQueryTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
        this.getQueryTemplate = getQueryTemplate;
        this.insertQueryTemplate = insertQueryTemplate;
        this.deleteQueryTemplate = deleteQueryTemplate;
        this.updateQueryTemplate = updateQueryTemplate;
    }

    public abstract T get(int id);

    public abstract List<T> getAll();

    public abstract boolean add(T t);

    public abstract boolean remove(int id);

    public abstract boolean update(T t);

}
