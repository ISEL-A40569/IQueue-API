package pt.ipl.isel.ps.iqueue.model;

public class UserProfile {
    private final int userProfileId;
    private final int languageId;
    private final String userProfileDescription;

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
}
