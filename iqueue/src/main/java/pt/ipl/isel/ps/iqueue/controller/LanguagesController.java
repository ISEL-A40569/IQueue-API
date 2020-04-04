package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.Language;
import pt.ipl.isel.ps.iqueue.repository.LanguageRepository;

@RestController
@RequestMapping("/api/iqueue/language")
public class LanguagesController {

    @Autowired
    private final LanguageRepository languageRepository;

    public LanguagesController(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @GetMapping(value = "{languageId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int languageId) {
        try {
            return ResponseEntity.ok(languageRepository.getById(languageId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity<? extends Object> getAll() {
        try {
            return ResponseEntity.ok(languageRepository.getAll());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity<?> add(@RequestBody Language language) {
        try {
            if (languageRepository.add(language)) {
                return ResponseEntity
                        .status(201)
                        .header("Location", "/api/iqueue/language/" + language.getLanguageId())
                        .build();
            }
            else {
                return ResponseEntity.status(409).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{languageId}", headers = {"Accept=application/json"})
    public ResponseEntity<?> remove(@PathVariable int languageId) {
        try {
            if (languageRepository.remove(languageId)) {
                return ResponseEntity.ok().build();
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(value = "{languageId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity<?> update(@RequestBody Language language) {
        try {
            if (languageRepository.update(language)) {
                return ResponseEntity.ok().build();
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }
}
