package pt.ipl.isel.ps.iqueue.mapping;

import pt.ipl.isel.ps.iqueue.dao.LanguageDao;
import pt.ipl.isel.ps.iqueue.model.Language;

public class LanguageDaoModelMapper implements DaoModelMapper<LanguageDao, Language> {
    @Override
    public Language mapDtoToModel(LanguageDao dao) {
        return new Language(dao.getLanguageId(), dao.getLanguageDescription());
    }

    @Override
    public LanguageDao mapModelToDto(Language model) {
        return new LanguageDao(model.getLanguageId(), model.getLanguageDescription());
    }
}
