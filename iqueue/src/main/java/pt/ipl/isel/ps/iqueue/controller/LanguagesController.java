package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.Language;
import pt.ipl.isel.ps.iqueue.repository.LanguageRepository;

@RestController
@RequestMapping("/api/iqueue/language")
public class LanguagesController extends Controller<Language> {

    public LanguagesController(LanguageRepository languageRepository) {
        super(languageRepository);
    }

    @GetMapping(value = "{languageId}", headers = {"Accept=application/json"})
    public ResponseEntity get(@PathVariable int languageId) {
        try {
            return ResponseEntity.ok(repository.get(languageId));
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
            return ResponseEntity.ok(repository.getAll());
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
            if (repository.add(language)) {
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
            if (repository.remove(languageId)) {
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
    public ResponseEntity<?> update(@PathVariable int languageId, @RequestBody Language language) {
        try {
            if (repository.update(language)) {
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
