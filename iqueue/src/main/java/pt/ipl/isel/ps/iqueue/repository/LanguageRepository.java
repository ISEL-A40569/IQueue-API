package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.Language;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.LanguageRowMapper;
import java.util.List;

@Component
public class LanguageRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private final RowMapper<Language> languageRowMapper;

    private final String getQueryTemplate = "exec SelectLanguage ?";

    public LanguageRepository(JdbcTemplate jdbcTemplate, LanguageRowMapper languageRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.languageRowMapper = languageRowMapper;
    }

    public Language getById(int languageId) {
        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{languageId}, languageRowMapper);
    }

    public List<Language> getAll() {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null}, languageRowMapper);
    }

    public boolean add(Language language) {
        String insertQueryTemplate = "exec InsertLanguage ?, ?";
        return jdbcTemplate.update(insertQueryTemplate, language.getLanguageId(), language.getLanguageDescription()) == 1;
    }

    public boolean remove(int languageId) {
        String deleteQueryTemplate = "exec DeleteLanguage ?";
        return jdbcTemplate.update(deleteQueryTemplate, languageId) == 1;
    }

    public boolean update(Language language) {
        String updateQueryTemplate = "exec UpdateLanguage ?, ?";
        return jdbcTemplate.update(updateQueryTemplate, language.getLanguageId(), language.getLanguageDescription()) == 1;
    }
}
