package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.Language;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.LanguageRowMapper;
import java.util.List;

@Component
public class LanguageRepository extends Repository<Language> {

    public LanguageRepository(JdbcTemplate jdbcTemplate, LanguageRowMapper languageRowMapper) {
        super(jdbcTemplate, languageRowMapper, "exec GetLanguage ?", "exec InsertLanguage ?, ?",
                "exec DeleteLanguage ?", "exec UpdateLanguage ?, ?");
    }

    @Override
    public Language get(int languageId) {
        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{languageId}, rowMapper);
    }

    @Override
    public List<Language> getAll() {
        long startTime = System.nanoTime();
        List<Language> query = jdbcTemplate.query(getQueryTemplate, new Object[]{null}, rowMapper);
        long stopTime = System.nanoTime() - startTime;
        return query;
//        return jdbcTemplate.query(getQueryTemplate, new Object[]{null}, rowMapper);
    }

    @Override
    public boolean add(Language language) {
        return jdbcTemplate.update(insertQueryTemplate, new Object[]{language.getLanguageId(), language.getLanguageDescription()}) == 1;
    }

    @Override
    public boolean remove(int languageId) {
        return jdbcTemplate.update(deleteQueryTemplate, new Object[]{languageId}) == 1;
    }

    @Override
    public boolean update(Language language) {
        return jdbcTemplate.update(updateQueryTemplate, new Object[]{language.getLanguageId(), language.getLanguageDescription()}) == 1;
    }
}
