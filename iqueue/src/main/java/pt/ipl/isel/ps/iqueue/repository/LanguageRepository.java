package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.Language;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.LanguageRowMapper;
import java.util.List;

@Component
public class LanguageRepository extends Repository<Language> {

    public LanguageRepository(JdbcTemplate jdbcTemplate, LanguageRowMapper languageRowMapper) {
        super(jdbcTemplate, languageRowMapper);
    }

    @Override
    public Language get(int languageId) {
        String query = "exec GetLanguage ?";

        return jdbcTemplate.queryForObject( query, new Object[]{languageId}, rowMapper);
    }

    @Override
    public List<Language> getAll() {
        String query = "exec GetLanguages";

        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public boolean add(Language language) {
        String query = "exec InsertLanguage ?, ?";

        return jdbcTemplate.update(query, new Object[]{language.getLanguageId(), language.getLanguageDescription()}) == 1;
    }

    @Override
    public boolean remove(int languageId) {
        String query = "exec DeleteLanguage ?";

        return jdbcTemplate.update(query, new Object[]{languageId}) == 1;
    }

    @Override
    public boolean update(Language language) {
        String query = "exec UpdateLanguage ?, ?";

        return jdbcTemplate.update(query, new Object[]{language.getLanguageId(), language.getLanguageDescription()}) == 1;
    }
}
