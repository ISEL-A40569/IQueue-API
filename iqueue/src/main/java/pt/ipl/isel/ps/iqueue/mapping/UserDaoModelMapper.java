package pt.ipl.isel.ps.iqueue.mapping;

import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.UserDao;
import pt.ipl.isel.ps.iqueue.model.User;

@Component
public class UserDaoModelMapper implements DaoModelMapper<UserDao, User> {
    @Override
    public User mapDaoToModel(UserDao dao) {
        return new User(dao.getUserId(), dao.getUserName(), dao.getEmail(),
                dao.getTelephoneNumber(), dao.getAddress(), dao.getUserProfileId());
    }

    @Override
    public UserDao mapModelToDao(User model) {
        return new UserDao(model.getUserId(), model.getUserName(), model.getEmail(),
                model.getTelephoneNumber(), model.getAddress(), model.getUserProfileId());
    }
}
