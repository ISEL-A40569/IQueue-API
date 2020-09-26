package pt.ipl.isel.ps.iqueue.model;

public class UserProfile {
    private int userProfileId;
    private int languageId;
    private String userProfileDescription;

    public UserProfile(int userProfileId, int languageId, String userProfileDescription) {
        this.userProfileId = userProfileId;
        this.languageId = languageId;
        this.userProfileDescription = userProfileDescription;
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

    public String getUserProfileDescription() {
        return userProfileDescription;
    }

    public void setUserProfileDescription(String userProfileDescription) {
        this.userProfileDescription = userProfileDescription;
    }
}
