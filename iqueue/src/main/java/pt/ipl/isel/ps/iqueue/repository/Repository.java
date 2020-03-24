package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

public abstract class Repository<T> {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public Repository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public abstract T get(int id);

    public abstract List<T> getAll();

    public abstract void add(T t);

    public abstract void delete(int id);

    public abstract void update(T t);
}
