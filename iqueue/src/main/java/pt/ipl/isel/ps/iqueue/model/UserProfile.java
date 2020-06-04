package pt.ipl.isel.ps.iqueue.model;

import pt.ipl.isel.ps.iqueue.model.embedded.UserProfileIds;

import javax.persistence.*;

@Entity
@Table(name = "UserProfile")
public class UserProfile {

    @EmbeddedId
    UserProfileIds userProfileIds;

    @Column(name = "userProfileDescription")
    private String userProfileDescription;

    public UserProfile() {
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
