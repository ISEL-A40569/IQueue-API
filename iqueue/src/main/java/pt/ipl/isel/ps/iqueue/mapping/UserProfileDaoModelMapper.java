package pt.ipl.isel.ps.iqueue.mapping;

import pt.ipl.isel.ps.iqueue.dao.UserProfileDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.UserProfileIds;
import pt.ipl.isel.ps.iqueue.model.UserProfile;

public class UserProfileDaoModelMapper implements DaoModelMapper<UserProfileDao, UserProfile> {

    @Override
    public UserProfile mapDtoToModel(UserProfileDao dao) {
        return new UserProfile(dao.getUserProfileIds().getUserProfileId(),
                dao.getUserProfileIds().getLanguageId(),
                dao.getUserProfileDescription());
    }

    @Override
    public UserProfileDao mapModelToDto(UserProfile model) {
        return new UserProfileDao(new UserProfileIds(model.getUserProfileId(),
                model.getLanguageId()),
                model.getUserProfileDescription());
    }
}
