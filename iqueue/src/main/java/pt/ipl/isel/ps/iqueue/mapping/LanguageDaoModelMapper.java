package pt.ipl.isel.ps.iqueue.mapping;

import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.LanguageDao;
import pt.ipl.isel.ps.iqueue.model.Language;

@Component
public class LanguageDaoModelMapper implements DaoModelMapper<LanguageDao, Language> {
    @Override
    public Language mapDaoToModel(LanguageDao dao) {
        return new Language(dao.getLanguageId(), dao.getLanguageDescription());
    }

    @Override
    public LanguageDao mapModelToDao(Language model) {
        return new LanguageDao(model.getLanguageId(), model.getLanguageDescription());
    }
}
