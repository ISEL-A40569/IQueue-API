package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.Language;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class LanguageRepository extends Repository<Language> {

    private class LanguageRowMapper implements RowMapper<Language> {

        @Override
        public Language mapRow(ResultSet rs, int rowNum) throws SQLException {
            return  new Language(rs.getInt("languageId"),
                    rs.getString("languageDescription"));
        }
    }

    public LanguageRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    private LanguageRowMapper languageRowMapper = new LanguageRowMapper();

    @Override
    public Language get(int id) {
        String query = "SELECT * FROM LANGUAGE WHERE languageId = ?";

        return super.jdbcTemplate.queryForObject( query, new Object[]{id}, languageRowMapper);
    }

    @Override
    public List<Language> getAll() {
        String query = "SELECT * FROM LANGUAGE";

        return super.jdbcTemplate.query(query, languageRowMapper);
    }

    @Override
    public void add(Language language) {
        String query = "INSERT INTO LANGUAGE VALUES(?, ?)";

        super.jdbcTemplate.update(query, new Object[]{language.getLanguageId(), language.getLanguageDescription()});
    }

    @Override
    public void delete(int id) {
        String query = "DELETE LANGUAGE WHERE languageId = ?";

        super.jdbcTemplate.update(query, new Object[]{id});
    }

    @Override
    public void update(Language language) {

    }
}
