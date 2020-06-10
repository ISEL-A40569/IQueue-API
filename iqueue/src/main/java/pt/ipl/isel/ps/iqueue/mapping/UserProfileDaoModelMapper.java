package pt.ipl.isel.ps.iqueue.mapping;

import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.UserProfileDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.UserProfileIds;
import pt.ipl.isel.ps.iqueue.model.UserProfile;

@Component
public class UserProfileDaoModelMapper implements DaoModelMapper<UserProfileDao, UserProfile> {

    @Override
    public UserProfile mapDaoToModel(UserProfileDao dao) {
        return new UserProfile(dao.getUserProfileIds().getUserProfileId(),
                dao.getUserProfileIds().getLanguageId(),
                dao.getUserProfileDescription());
    }

    @Override
    public UserProfileDao mapModelToDao(UserProfile model) {
        return new UserProfileDao(new UserProfileIds(model.getUserProfileId(),
                model.getLanguageId()),
                model.getUserProfileDescription());
    }
}
