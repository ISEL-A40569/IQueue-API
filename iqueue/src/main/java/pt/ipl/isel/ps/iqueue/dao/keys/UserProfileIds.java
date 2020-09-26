package pt.ipl.isel.ps.iqueue.dao.keys;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserProfileIds implements Serializable {
    int userProfileId;
    int languageId;

    public UserProfileIds() {
    }

    public UserProfileIds(int userProfileId, int languageId) {
        this.userProfileId = userProfileId;
        this.languageId = languageId;
    }

    public int getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(int userProfileId) {
        this.userProfileId = userProfileId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
