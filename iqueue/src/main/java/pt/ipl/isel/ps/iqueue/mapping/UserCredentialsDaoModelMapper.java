package pt.ipl.isel.ps.iqueue.mapping;

import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.UserCredentialsDao;
import pt.ipl.isel.ps.iqueue.model.UserCredentials;

@Component
public class UserCredentialsDaoModelMapper implements DaoModelMapper<UserCredentialsDao, UserCredentials> {
    @Override
    public UserCredentials mapDaoToModel(UserCredentialsDao dao) {
        return new UserCredentials(dao.getUserId(),
                dao.getPassword());
    }

    @Override
    public UserCredentialsDao mapModelToDao(UserCredentials model) {
        return new UserCredentialsDao(model.getUserId(),
                model.getPassword());
    }
}
