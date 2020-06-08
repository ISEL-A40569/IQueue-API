package pt.ipl.isel.ps.iqueue.mapping;

import pt.ipl.isel.ps.iqueue.dao.UserCredentialsDao;
import pt.ipl.isel.ps.iqueue.model.UserCredentials;

public class UserCredentialsDaoModelMapper implements DaoModelMapper<UserCredentialsDao, UserCredentials> {
    @Override
    public UserCredentials mapDtoToModel(UserCredentialsDao dao) {
        return new UserCredentials(dao.getUserId(),
                dao.getPassword());
    }

    @Override
    public UserCredentialsDao mapModelToDto(UserCredentials model) {
        return new UserCredentialsDao(model.getUserId(),
                model.getPassword());
    }
}
