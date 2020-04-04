package pt.ipl.isel.ps.iqueue.model;

public class UserProfile {
    final private int userProfileId;
    final private int languageId;
    private String userProfileDescription;

    public UserProfile(int userProfileId, int languageId, String userProfileDescription) {
        this.userProfileId = userProfileId;
        this.languageId = languageId;
        this.userProfileDescription = userProfileDescription;
    }

    public int getUserProfileId() {
        return userProfileId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public String getUserProfileDescription() {
        return userProfileDescription;
    }

    public void setUserProfileDescription(String userProfileDescription) {
        this.userProfileDescription = userProfileDescription;
    }
}
