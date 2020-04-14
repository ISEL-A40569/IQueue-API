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
public class ClientRepository extends Repository<Client>{

    public ClientRepository(JdbcTemplate jdbcTemplate, ClientRowMapper clientRowMapper) {
        super(jdbcTemplate, clientRowMapper, "exec SelectClient ?",
                "exec InsertClient ?, ?",
                "exec DeleteClient ?",
                "exec UpdateClient ?, ?, ?");
    }

    public Client getById(int clientId) {
        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{clientId}, rowMapper);
    }

    public List<Client> getAll() {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null}, rowMapper);
    }

    public int add(Client client) {
        return jdbcTemplate.queryForObject(insertQueryTemplate, new Object[]{client.getClientName(), client.getEmail()}, Integer.class);
//        return update == 1;
//        return jdbcTemplate.update(insertQueryTemplate, client.getClientName(), client.getEmail()) == 1;
    }

    public boolean remove(int clientId) {
        return jdbcTemplate.update(removeQueryTemplate, clientId) == 1;
    }

    public boolean update(Client client) {
        return jdbcTemplate.update(updateQueryTemplate, client.getClientId(),
                client.getClientName(), client.getEmail()) == 1;
    }
}
