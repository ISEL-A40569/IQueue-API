package pt.ipl.isel.ps.iqueue.model;

public class Language {
    final private int languageId;
    final private String languageDescription;

    public Language(int languageId, String languageDescription) {
        this.languageId = languageId;
        this.languageDescription = languageDescription;
    }

    public int getLanguageId() {
        return languageId;
    }

    public String getLanguageDescription() {
        return languageDescription;
    }

    @Override
    public String toString() {
        return "ID: " + languageId + " - " + languageDescription;
    }
}
