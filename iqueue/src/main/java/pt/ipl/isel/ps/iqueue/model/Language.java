package pt.ipl.isel.ps.iqueue.model;

public class Language {
    private int languageId;
    private String languageDescription;

    public Language() {
    }

    public Language(int languageId, String languageDescription) {
        this.languageId = languageId;
        this.languageDescription = languageDescription;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLanguageDescription() {
        return languageDescription;
    }

}
