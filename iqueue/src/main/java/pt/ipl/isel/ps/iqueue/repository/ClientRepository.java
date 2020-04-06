package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.Client;
import pt.ipl.isel.ps.iqueue.model.Language;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.ClientRowMapper;

import java.util.List;

@Component
public class ClientRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private final RowMapper<Client> clientRowMapper;

    public ClientRepository(JdbcTemplate jdbcTemplate, ClientRowMapper clientRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.clientRowMapper = clientRowMapper;
    }

    private final String getQueryTemplate = "exec SelectClient ?";
    private final String insertQueryTemplate = "exec InsertClient ?, ?";
    private final String removeQueryTemplate = "exec DeleteClient ?";
    private final String updateQueryTemplate = "exec UpdateClient ?, ?, ?";

    public Client getByIy(int clientId) {
        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{clientId}, clientRowMapper);
    }

    public List<Client> getAll() {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null}, clientRowMapper);
    }

    public boolean add(Client client) {
        return jdbcTemplate.update(insertQueryTemplate, client.getClientName(), client.getEmail()) == 1;
    }

    public boolean delete(int clientId) {
        return jdbcTemplate.update(removeQueryTemplate, clientId) == 1;
    }

    public boolean update(Client client) {
        return jdbcTemplate.update(updateQueryTemplate, client.getClientId(),
                client.getClientName(), client.getEmail()) == 1;
    }
}
