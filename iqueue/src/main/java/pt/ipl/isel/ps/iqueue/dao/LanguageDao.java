package pt.ipl.isel.ps.iqueue.dao;

import javax.persistence.*;

@Entity
@Table(name = "Language")
public class LanguageDao {
    @Id
    @Column(name = "languageId")
    private int languageId;

    @Column(name = "languageDescription")
    private String languageDescription;

    public LanguageDao() {
    }

    public LanguageDao(int languageId, String languageDescription) {
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
