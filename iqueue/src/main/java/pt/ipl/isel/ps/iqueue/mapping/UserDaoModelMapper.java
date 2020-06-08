package pt.ipl.isel.ps.iqueue.mapping;

import pt.ipl.isel.ps.iqueue.dao.UserDao;
import pt.ipl.isel.ps.iqueue.model.User;

public class UserDaoModelMapper implements DaoModelMapper<UserDao, User> {
    @Override
    public User mapDtoToModel(UserDao dao) {
        return new User(dao.getUserId(), dao.getEmail(), dao.getEmail(),
                dao.getTelephoneNumber(), dao.getAddress(), dao.getUserProfileId());
    }

    @Override
    public UserDao mapModelToDto(User model) {
        return new UserDao(model.getUserId(), model.getEmail(), model.getEmail(),
                model.getTelephoneNumber(), model.getAddress(), model.getUserProfileId());
    }
}
