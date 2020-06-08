package pt.ipl.isel.ps.iqueue.model;

import javax.persistence.Column;

public class Language {
    private final int languageId;
    private final String languageDescription;

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
}
