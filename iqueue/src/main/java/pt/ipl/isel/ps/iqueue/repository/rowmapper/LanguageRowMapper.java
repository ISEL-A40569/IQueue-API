package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.Language;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LanguageRowMapper implements RowMapper<Language> {

    @Override
    public Language mapRow(ResultSet rs, int rowNum) throws SQLException {
        return  new Language(rs.getInt("languageId"),
                rs.getString("languageDescription"));
    }
}