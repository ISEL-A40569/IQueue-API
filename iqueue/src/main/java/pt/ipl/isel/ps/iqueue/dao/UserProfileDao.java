package pt.ipl.isel.ps.iqueue.dao;

import pt.ipl.isel.ps.iqueue.dao.keys.UserProfileIds;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "UserProfile")
public class UserProfileDao {

    @EmbeddedId
    private UserProfileIds userProfileIds;

    @Column(name = "userProfileDescription")
    private String userProfileDescription;

    public UserProfileDao() {
    }

    public UserProfileDao(UserProfileIds userProfileIds, String userProfileDescription) {
        this.userProfileIds = userProfileIds;
        this.userProfileDescription = userProfileDescription;
    }

    public UserProfileIds getUserProfileIds() {
        return this.userProfileIds;
    }

    public void setUserProfileId(UserProfileIds userProfileId) {
        this.userProfileIds = userProfileId;
    }

    public String getUserProfileDescription() {
        return userProfileDescription;
    }

    public void setUserProfileDescription(String userProfileDescription) {
        this.userProfileDescription = userProfileDescription;
    }
}
