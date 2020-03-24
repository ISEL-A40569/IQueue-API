package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.Language;
import pt.ipl.isel.ps.iqueue.repository.LanguageRepository;
import java.util.List;

@RestController
@RequestMapping("/api/iqueue/language")
public class LanguagesController {

    @Autowired
    final private LanguageRepository languageRepository;

    public LanguagesController(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @GetMapping(value = "{languageId}")
    public Language getLanguage(@PathVariable int languageId) {
        return languageRepository.get(languageId);
    }

    @GetMapping
    public List<Language> getAllLanguages() {
        return languageRepository.getAll();
    }

    @PostMapping
    public ResponseEntity<?> addLanguage(@RequestBody Language language) {

        languageRepository.add(language);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping(value = "{languageId}")
    public ResponseEntity<?> removeLanguage(@PathVariable int languageId) {
        languageRepository.delete(languageId);
        return ResponseEntity.ok().build();
    }
}
